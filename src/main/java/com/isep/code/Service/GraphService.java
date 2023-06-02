package com.isep.code.Service;

import com.isep.code.Entity.CoordinateEntity;
import com.isep.code.Entity.EdgeEntity;
import com.isep.code.Entity.GraphEntity;
import com.isep.code.Entity.PlaceEntity;
import com.isep.code.Helper;
import com.isep.code.OLD.Distance;
import com.isep.code.Repository.GraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GraphService {

    private final GraphRepository graphRepository;

    @Autowired
    public GraphService(GraphRepository graphRepository) {
        this.graphRepository = graphRepository;
    }

    public void saveGraph(List<PlaceEntity> placeEntities, int numberOfNeighbors, int travelMode) {

        GraphEntity graphEntity = new GraphEntity();

        List<EdgeEntity> edges = new ArrayList<>();

        for (PlaceEntity place1 : placeEntities) {

            CoordinateEntity coord1 = place1.getCoordinate();
            List<Distance> distances = new ArrayList<>();

            // Calculer les distances vers tous les autres lieux
            for (PlaceEntity place2 : placeEntities) {
                if (!place1.equals(place2)) {
                    CoordinateEntity coord2 = place2.getCoordinate();
                    double distance = Helper.calculateDistance(coord1, coord2, 2);
                    distances.add(new Distance(place2, distance));
                }
            }

            // Trier les distances par ordre croissant
            Collections.sort(distances);

            // Relier le lieu aux k plus proches voisins
            for (int i = 0; i < numberOfNeighbors && i < distances.size(); i++) {
                String neighbor = distances.get(i).getPlace();
                double distance = distances.get(i).getDistance();
                EdgeEntity edgeEntity = new EdgeEntity();
                edgeEntity.setSource(place1);
                edgeEntity.setDestination(neighbor);
                edgeEntity.setWeight(distance);
                edges.add(edgeEntity);
            }

        }
        graphEntity.setEdgeEntities(new HashSet<>(edges));
        graphRepository.save(graphEntity);
    }

}