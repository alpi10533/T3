package com.isep.code;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class ControllerHTML {

    @GetMapping("/")
    public String index() {
        return "index";
    }

}