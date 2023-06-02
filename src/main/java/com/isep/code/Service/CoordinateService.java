package com.isep.code.Service;

import com.isep.code.Entity.CoordinateEntity;
import com.isep.code.Repository.CoordinateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordinateService {

    private final CoordinateRepository coordinateRepository;

    @Autowired
    public CoordinateService(CoordinateRepository coordinateRepository) {
        this.coordinateRepository = coordinateRepository;
    }

    public CoordinateEntity saveCoordinate(double latitude, double longitude) {
        CoordinateEntity coordinateEntity = new CoordinateEntity();
        coordinateEntity.setLatitude(latitude);
        coordinateEntity.setLongitude(longitude);
        coordinateRepository.save(coordinateEntity);
        return coordinateEntity;
    }

}