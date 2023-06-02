package com.isep.code;

import com.isep.code.Entity.PlaceEntity;
import com.isep.code.Service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    private final PlaceService placeService;

    @Autowired
    public MainController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/places")
    public ResponseEntity<List<PlaceEntity>> getPlaces() {
        List<PlaceEntity> places = placeService.getAllPlaces();
        return new ResponseEntity<>(places, HttpStatus.OK);
    }

}