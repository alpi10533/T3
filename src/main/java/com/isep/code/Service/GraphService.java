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

    public NodeEntity addStartToGraph(GraphEntity graph, PlaceEntity start, List<PlaceEntity> places) {
        int numberOfNeighbors = graph.getNumberOfNeighbors();
        int travelMode = graph.getTravelMode();
        List<EdgeEntity> newEdges = new ArrayList<>();
        Coordinate coord1 = new Coordinate(start.getLatitude(), start.getLongitude());
        List<Distance> distances = new ArrayList<>();
        for (PlaceEntity place2 : places) {
            System.out.println(place2.getName());
            if (!start.equals(place2)) {
                Coordinate coord2 = new Coordinate(place2.getLatitude(), place2.getLongitude());
                double distance = Helper.calculateDistance(coord1, coord2, travelMode);
                distances.add(new Distance(place2, distance));
            }
        }
        Collections.sort(distances);
        for (int i = 0; i < numberOfNeighbors && i < distances.size(); i++) {
            PlaceEntity neighbor = distances.get(i).place();
            double distance = distances.get(i).distance();
            EdgeEntity edgeEntity = saveEdge(graph, start, neighbor, distance);
            newEdges.add(edgeEntity);
        }

        Set<EdgeEntity> edges = graph.getEdges();
        edges.addAll(new HashSet<>(newEdges));
        graph.setEdges(edges);
        graphRepository.save(graph);
        return findNodeByPlace(start);
    }

    public void findBestSolution(GraphEntity graph, NodeEntity start, String placeType, double budget, int duration) {
        double originalBudget = budget;
        int originalDuration = duration;
        NodeEntity nextNode = start;
        double lastNote = 0.0;
        while(budget > 0 && duration > 0) {
            System.out.println(nextNode);
            budget = budget - nextNode.getPlace().getPrice();
            Set<EdgeEntity> edges = graphRepository.findAllEdgesByGraphAndNode(graph, nextNode);
            for (EdgeEntity edge : edges) {
                NodeEntity node = edge.getDestination();
                double note = computeNote(node.getPlace(), placeType);
                if (note > lastNote) {
                    nextNode = node;
                    lastNote = note;
                }
            }
        }

    }

    public double computeNote(PlaceEntity place, String placeType) {
        if (Objects.equals(place.getType(), placeType)) {
            return 2.0;
        } else {
            return 1.0;
        }
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