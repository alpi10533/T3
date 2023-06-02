package com.isep.code.Utils;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;

public class Helper {

    // Méthode pour calculer la distance entre deux coordonnées géographiques (distance euclidienne)
    public static double calculateDistance(Coordinate coord1, Coordinate coord2, int intMode) {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyBv1RNdSPkEVqTjPP6sL5y9KOKUDJLqxPg")
                .build();
        LatLng origin = new LatLng(coord1.getLatitude(), coord1.getLongitude());
        LatLng destination = new LatLng(coord2.getLatitude(), coord2.getLongitude());
        TravelMode travelMode = null;
        switch (intMode) {
            case 1 -> travelMode = TravelMode.DRIVING;
            case 2 -> travelMode = TravelMode.WALKING;
            case 3 -> travelMode = TravelMode.TRANSIT;
            case 4 -> travelMode = TravelMode.BICYCLING;
        }
        try {
            DistanceMatrix matrix = DistanceMatrixApi.newRequest(context)
                    .origins(origin)
                    .destinations(destination)
                    .mode(travelMode)
                    .await();
            double distanceInMeters = matrix.rows[0].elements[0].distance.inMeters;
            System.out.println("Distance: " + distanceInMeters + " meters");
            return distanceInMeters;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
