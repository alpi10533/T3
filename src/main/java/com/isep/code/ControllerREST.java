package com.isep.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.isep.code.Entity.PlaceEntity;
import com.isep.code.Service.PlaceService;

@org.springframework.stereotype.Controller
public class ControllerREST {
    @Autowired
    public PlaceService placeService;

    @GetMapping("/all-places")
    public ResponseEntity<List<PlaceEntity>> getAllPlaces() {
        List<PlaceEntity> places = placeService.getAllPlaces();
        return ResponseEntity.ok(places);
    }

}