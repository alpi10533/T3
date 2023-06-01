package com.isep.code;

import java.util.*;

public class GraphFactory {

    public static Graph createGraph() {

        Graph graph = new Graph();

        Map<String, Coordinate> coordinates = new HashMap<>();

        coordinates.put("La tour Eiffel", new Coordinate(48.85856768770539, 2.2944813100320407));
        coordinates.put("Musée du Louvre", new Coordinate(48.86074515198898, 2.337686922353146));
        coordinates.put("Conciergerie", new Coordinate(48.85672575971245, 2.3458212625352495));
        coordinates.put("Centre Pompidou", new Coordinate(48.86075487756134, 2.3522450056486073));
        coordinates.put("Sainte-Chapelle", new Coordinate(48.85545259381476, 2.344950174936974));
        coordinates.put("Musée d Orsay", new Coordinate(48.86006016298918, 2.3265184893450637));
        coordinates.put("Fondation Louis Vuitton", new Coordinate(48.87673697222163, 2.2635560912352983));
        coordinates.put("Panthéon", new Coordinate(48.84628528613142, 2.3464459897583825));
        coordinates.put("Arc de Triomphe", new Coordinate(48.87393983078349, 2.2950275074751576));
        coordinates.put("Musée du quai Branly", new Coordinate(48.86091001832707, 2.2978725431611453));
        coordinates.put("Institut du monde arabe", new Coordinate(48.84896094211493, 2.357274217166676));
        coordinates.put("Musée Rodin", new Coordinate(48.85543420797071, 2.315835406378667));
        coordinates.put("Musée de Cluny", new Coordinate(48.85063855966835, 2.344080807837426));
        coordinates.put("Grand Palais", new Coordinate(48.85344579098905, 2.302410265281665));
        coordinates.put("Petit Palais", new Coordinate(48.866118418876425, 2.314611061238636));
        coordinates.put("Hotel de Béthune-Sully", new Coordinate(48.85532458336893, 2.364427008194676));
        coordinates.put("Basilique du Sacré-Coeur de Montmartre", new Coordinate(48.88685974869238, 2.3430399344103514));
        coordinates.put("Avenue des Champs-Élysées", new Coordinate(48.87306599448159, 2.297788231917454));
        coordinates.put("Tour Saint-Jacques", new Coordinate(48.85818844193142, 2.3489179349124143));
        coordinates.put("Île de la Cité", new Coordinate(48.85525355220592, 2.3468695876488757));
        coordinates.put("Cathédrale de la Sainte-Trinité", new Coordinate(48.86212267391677, 2.300997881117963));
        coordinates.put("Place de la Concorde", new Coordinate(48.86569656101774, 2.321289347534348));
        coordinates.put("Tour Jean-sans-Peur", new Coordinate(48.86435037479113, 2.348041643521805));
        coordinates.put("Arènes de Lutèce", new Coordinate(48.84524303335598, 2.3528580641779517));
        coordinates.put("Palais de Tokyo", new Coordinate(48.86461592834268, 2.2966407453267044));
        coordinates.put("Passage Brady", new Coordinate(48.871540502219624, 2.355119694411343));
        coordinates.put("Opéra national de Paris", new Coordinate(48.8723068631308, 2.3316018265859415));
        coordinates.put("Cimetière du Père Lachaise", new Coordinate(48.861521349900606, 2.393515417905678));
        coordinates.put("Observatoire Paris Montparnasse", new Coordinate(48.84220928620018, 2.321961579713815));

        // Relier les lieux les plus proches
        int k = 5; // Nombre de plus proches voisins à considérer

        for (String place1 : coordinates.keySet()) {

            Coordinate coord1 = coordinates.get(place1);
            List<Distance> distances = new ArrayList<>();

            // Calculer les distances vers tous les autres lieux
            for (String place2 : coordinates.keySet()) {
                if (!place1.equals(place2)) {
                    Coordinate coord2 = coordinates.get(place2);
                    double distance = Helper.calculateDistance(coord1, coord2, 2);
                    distances.add(new Distance(place2, distance));
                }
            }

            // Trier les distances par ordre croissant
            Collections.sort(distances);

            // Relier le lieu aux k plus proches voisins
            for (int i = 0; i < k && i < distances.size(); i++) {
                String neighbor = distances.get(i).getPlace();
                double distance = distances.get(i).getDistance();
                graph.addEdge(place1, neighbor, distance);
            }

        }

        return graph;

    }

}
