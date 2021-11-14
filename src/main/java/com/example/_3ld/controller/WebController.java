package com.example._3ld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RestController
public class WebController {
    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @RequestMapping(value = "")

    public String sayHello(){
        return requestMappingHandlerMapping.getHandlerMethods().keySet().toString();
    }
}
