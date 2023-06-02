package com.isep.code.Utils;

import com.isep.code.Entity.PlaceEntity;

public record Distance(PlaceEntity place, double distance) implements Comparable<Distance> {

    @Override
    public int compareTo(Distance other) {
        return Double.compare(distance, other.distance);
    }

}