package com.example._3ld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping(value="")
    @ResponseBody
    public String sayHello(){
        return "Welcome to main controller";
    }
}
