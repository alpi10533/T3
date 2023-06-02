package com.isep.code.Utils;

import com.isep.code.Entity.PlaceEntity;

public class Distance implements Comparable<Distance> {

    private PlaceEntity place;
    private double distance;

    public Distance(PlaceEntity place, double distance) {
        this.place = place;
        this.distance = distance;
    }

    @Override
    public int compareTo(Distance other) {
        return Double.compare(distance, other.distance);
    }
    public PlaceEntity getPlace() {
        return place;
    }
    public double getDistance() {
        return distance;
    }

}