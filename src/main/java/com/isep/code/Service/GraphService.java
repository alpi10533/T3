package com.isep.code.Service;

import com.isep.code.Entity.*;
import com.isep.code.Repository.EdgeRepository;
import com.isep.code.Repository.NodeRepository;
import com.isep.code.Utils.Coordinate;
import com.isep.code.Utils.Distance;
import com.isep.code.Utils.Helper;
import com.isep.code.Repository.GraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class GraphService {

    private final GraphRepository graphRepository;
    private final EdgeRepository edgeRepository;
    private final NodeRepository nodeRepository;


    @Autowired
    public GraphService(GraphRepository graphRepository, EdgeRepository edgeRepository, NodeRepository nodeRepository) {
        this.graphRepository = graphRepository;
        this.edgeRepository = edgeRepository;
        this.nodeRepository = nodeRepository;
    }

    public GraphEntity saveGraph() {
        GraphEntity graphEntity = new GraphEntity();
        graphRepository.save(graphEntity);
        return graphEntity;
    }

    public void initGraph(GraphEntity graph, List<PlaceEntity> places, int numberOfNeighbors, int travelMode) {
        List<EdgeEntity> edges = new ArrayList<>();
        for (PlaceEntity place1 : places) {
            Coordinate coord1 = new Coordinate(place1.getLatitude(), place1.getLongitude());
            List<Distance> distances = new ArrayList<>();
            for (PlaceEntity place2 : places) {
                if (!place1.equals(place2)) {
                    Coordinate coord2 = new Coordinate(place2.getLatitude(), place2.getLongitude());
                    double distance = Helper.calculateDistance(coord1, coord2, travelMode);
                    distances.add(new Distance(place2, distance));
                }
            }
            Collections.sort(distances);
            for (int i = 0; i < numberOfNeighbors && i < distances.size(); i++) {
                PlaceEntity neighbor = distances.get(i).place();
                double distance = distances.get(i).distance();
                EdgeEntity edgeEntity = saveEdge(graph, place1, neighbor, distance);
                edges.add(edgeEntity);
            }

        }
        graph.setNumberOfNeighbors(numberOfNeighbors);
        graph.setTravelMode(travelMode);
        graph.setEdges(new HashSet<>(edges));
        graphRepository.save(graph);
    }

    public NodeEntity findBestStart(GraphEntity graph, String placeType, double originalBudget, double originalDuration) {
        Set<EdgeEntity> edges = graphRepository.findAllEdgesByGraph(graph);
        NodeEntity bestNode = null;
        double bestNote = 0.0;
        for (EdgeEntity edge : edges) {
            NodeEntity tempNode = edge.getDestination();
            double tempDuration = edge.getWeight();
            double tempNote = computeNote(tempNode, tempDuration, placeType, originalBudget, originalDuration);
            if (bestNode == null || tempNote > bestNote) {
                bestNode = tempNode;
                bestNote = tempNote;
            }
        }
        return bestNode;
    }

    public List<NodeEntity> findBestSolution(GraphEntity graph, String placeType, double totalBudget, double totalDuration) {
        double originalBudget = totalBudget;
        double originalDuration = totalDuration;
        List<NodeEntity> visitedNodes = new ArrayList<>();
        NodeEntity node = findBestStart(graph, placeType, originalBudget, originalDuration);
        double duration = 0.0;
        while (totalBudget > 0 && totalDuration > 0) {
            System.out.println(node.getPlace().getName());
            totalBudget = totalBudget - node.getPlace().getPrice();
            totalDuration = totalDuration - (duration + (double) 3600 /(24 * 60 * 60));;
            visitedNodes.add(node);
            NodeEntity bestNode = null;
            double bestNote = 0.0;
            double bestDuration = 0.0;
            Set<EdgeEntity> edges = graphRepository.findAllEdgesByGraphAndNode(graph, node);
            for (EdgeEntity edge : edges) {
                NodeEntity tempNode = edge.getDestination();
                double tempDuration = edge.getWeight();
                double tempNote = computeNote(tempNode, tempDuration, placeType, originalBudget, originalDuration);
                if (!visitedNodes.contains(tempNode)) {
                    if (bestNode == null || tempNote > bestNote) {
                        bestNode = tempNode;
                        bestNote = tempNote;
                        bestDuration = tempDuration;
                    }
                }
            }
            if (bestNode == null) {
                for (EdgeEntity edge : edges) {
                    NodeEntity tempNode = edge.getDestination();
                    double tempDuration = edge.getWeight();
                    double tempNote = computeNote(tempNode, tempDuration, placeType, originalBudget, originalDuration);
                    if (!visitedNodes.contains(tempNode)) {
                        if (bestNode == null || tempNote < bestNote) {
                            bestNode = tempNode;
                            bestNote = tempNote;
                            bestDuration = tempDuration;
                        }
                    }
                }
            }
            if (bestNode != null) {
                node = bestNode;
                duration = bestDuration;
            } else {
                break;
            }
        }
        return visitedNodes;
    }

    public double computeNote(NodeEntity node, double duration, String placeType, double originalBudget, double originalDuration) {
        PlaceEntity place = node.getPlace();
        double totalNote = 0.0;
        if (Objects.equals(place.getType(), placeType)) {
            totalNote += 0.9;
        }
        double budgetNote = 1.0 - Math.abs(place.getPrice() - originalBudget) / originalBudget;
        totalNote += budgetNote * 0.5;
        double durationNote = 1.0 - Math.abs(duration - originalDuration) / originalDuration;
        totalNote += durationNote * 0.7;
        return totalNote;
    }


    public EdgeEntity saveEdge(GraphEntity graph, PlaceEntity place1, PlaceEntity neighbor, double weight) {
        NodeEntity source = findNodeByPlace(place1);
        if (source == null) {
            source = saveNode(place1);
        }
        NodeEntity destination = findNodeByPlace(neighbor);
        if (destination == null) {
            destination = saveNode(neighbor);
        }
        EdgeEntity edgeEntity = new EdgeEntity();
        edgeEntity.setSource(source);
        edgeEntity.setDestination(destination);
        edgeEntity.setWeight(weight);
        edgeEntity.setGraph(graph);
        edgeRepository.save(edgeEntity);
        return edgeEntity;
    }

    public NodeEntity saveNode(PlaceEntity place) {
        NodeEntity nodeEntity = new NodeEntity();
        nodeEntity.setPlace(place);
        nodeRepository.save(nodeEntity);
        return nodeEntity;
    }

    public NodeEntity findNodeByPlace(PlaceEntity place) {
        return nodeRepository.findByPlace(place);
    }

    public GraphEntity findGraphById(Long id) {
        return graphRepository.findById(id).orElse(null);
    }

    public List<GraphEntity> findAllGraphs() {
        return graphRepository.findAll();
    }

    @Transactional
    public void deleteGraphByGraphOrId(GraphEntity graph, Long id) {
        edgeRepository.deleteAllByGraph(graph);
        graphRepository.deleteById(id);
    }


}