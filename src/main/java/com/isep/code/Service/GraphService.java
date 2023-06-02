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

    public void saveGraph(List<PlaceEntity> placeEntities, int numberOfNeighbors, int travelMode) {

        GraphEntity graphEntity = new GraphEntity();

        List<EdgeEntity> edges = new ArrayList<>();

        for (PlaceEntity place1 : placeEntities) {

            Coordinate coord1 = new Coordinate(place1.getLatitude(), place1.getLongitude());
            List<Distance> distances = new ArrayList<>();

            // Calculer les distances vers tous les autres lieux
            for (PlaceEntity place2 : placeEntities) {
                if (!place1.equals(place2)) {
                    Coordinate coord2 = new Coordinate(place2.getLatitude(), place2.getLongitude());
                    System.out.println(coord1);
                    double distance = Helper.calculateDistance(coord1, coord2, 2);
                    distances.add(new Distance(place2, distance));
                }
            }

            // Trier les distances par ordre croissant
            Collections.sort(distances);

            // Relier le lieu aux k plus proches voisins
            for (int i = 0; i < numberOfNeighbors && i < distances.size(); i++) {
                PlaceEntity neighbor = distances.get(i).getPlace();
                double distance = distances.get(i).getDistance();
                EdgeEntity edgeEntity = saveEdge(place1, neighbor, distance);
                edges.add(edgeEntity);
            }

        }
        graphEntity.setEdgeEntities(new HashSet<>(edges));
        graphRepository.save(graphEntity);
    }

    public EdgeEntity saveEdge(PlaceEntity place1, PlaceEntity neighbor, double weight) {

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
        edgeRepository.save(edgeEntity);
        return edgeEntity;
    }

    public NodeEntity saveNode(PlaceEntity placeEntity) {
        NodeEntity nodeEntity = new NodeEntity();
        nodeEntity.setPlace(placeEntity);
        nodeRepository.save(nodeEntity);
        return nodeEntity;
    }

    public NodeEntity findNodeByPlace(PlaceEntity placeEntity) {
        return nodeRepository.findByPlace(placeEntity);
    }

}