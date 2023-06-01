package com.isep.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;

    @Autowired
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public void savePlace(String name, String type, double latitude, double longitude, DayOfWeek startDay, DayOfWeek endDay, LocalTime startHour, LocalTime endHour, double price) {
        PlaceEntity placeEntity = new PlaceEntity();
        placeEntity.setName(name);
        placeEntity.setType(type);
        placeEntity.setLatitude(latitude);
        placeEntity.setLongitude(longitude);
        placeEntity.setStartDay(startDay);
        placeEntity.setEndDay(endDay);
        placeEntity.setStartHour(startHour);
        placeEntity.setEndHour(endHour);
        placeEntity.setPrice(price);
    }

}