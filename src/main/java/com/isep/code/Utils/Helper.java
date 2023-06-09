package com.isep.code.Utils;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;

public class Helper {

    public static double calculateDistance(Coordinate coord1, Coordinate coord2, int k) {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyC3Forn3c3rD19FAI3ER_pqzCoSu5ZCftE")
                .build();
        LatLng origin = new LatLng(coord1.latitude(), coord1.longitude());
        LatLng destination = new LatLng(coord2.latitude(), coord2.longitude());
        TravelMode travelMode = null;
        switch (k) {
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

            double durationInSeconds = matrix.rows[0].elements[0].duration.inSeconds;
            return durationInSeconds/(24 * 60 * 60);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
