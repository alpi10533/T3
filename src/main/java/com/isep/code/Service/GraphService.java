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

    public void initGraph(GraphEntity graph, List<PlaceEntity> places, int numberOfNeighbors, int travelMode) {
        List<EdgeEntity> edges = new ArrayList<>();
        for (PlaceEntity place1 : places) {
            Coordinate coord1 = new Coordinate(place1.getLatitude(), place1.getLongitude());
            List<Distance> distances = new ArrayList<>();
            for (PlaceEntity place2 : places) {
                if (!place1.equals(place2)) {
                    Coordinate coord2 = new Coordinate(place2.getLatitude(), place2.getLongitude());
                    System.out.println(coord1);
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
        graph.setEdges(new HashSet<>(edges));
        graphRepository.save(graph);
    }

    public GraphEntity saveGraph() {
        GraphEntity graphEntity = new GraphEntity();
        graphRepository.save(graphEntity);
        return graphEntity;
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

}