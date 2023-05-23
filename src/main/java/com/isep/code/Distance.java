package com.isep.code;

public class Distance implements Comparable<Distance> {

    private String place;
    private double distance;

    public Distance(String place, double distance) {
        this.place = place;
        this.distance = distance;
    }

    @Override
    public int compareTo(Distance other) {
        return Double.compare(distance, other.distance);
    }
    public String getPlace() {
        return place;
    }
    public double getDistance() {
        return distance;
    }

}