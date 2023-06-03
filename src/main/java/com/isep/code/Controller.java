package com.isep.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/gmaps")
    public void gmapsCall() {
        GmapsCall gmapsCall = new GmapsCall();
        gmapsCall.gmapsCallMethod();
    }
}