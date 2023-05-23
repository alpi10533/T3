package com.isep.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    public Controller() {
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

}