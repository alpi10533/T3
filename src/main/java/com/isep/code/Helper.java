package com.isep.code;

public class Helper {

    // Méthode pour calculer la distance entre deux coordonnées géographiques (distance euclidienne)
    public static double calculateDistance(Coordinate coord1, Coordinate coord2) {
        double latDiff = coord1.getLatitude() - coord2.getLatitude();
        double lonDiff = coord1.getLongitude() - coord2.getLongitude();
        return Math.sqrt(latDiff * latDiff + lonDiff * lonDiff);
    }

}
