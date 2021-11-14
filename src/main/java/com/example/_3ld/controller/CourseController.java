package com.example._3ld.controller;

import com.example._3ld.Repositories.*;
import com.example._3ld.ds.*;
import com.example._3ld.jsonparsing.Json;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Optional;

@RestController
@RequestMapping(value="/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

//    @RequestMapping(value="")
//    public String getEndPointsInView( Model model ) throws JsonProcessingException {
//        System.out.println(requestMappingHandlerMapping.getHandlerMethods().keySet().);
//        requestMappingHandlerMapping.get
//        return "hello";
//    }

    @GetMapping(value="/{id}")
    @ResponseBody
    Optional<Course> get(@PathVariable Integer id){
        return courseRepository.findById(id);
    }

    @DeleteMapping(value="/{id}")
    @ResponseBody
    String delete(@PathVariable Integer id){
        courseRepository.deleteById(id);
        return "Success";
    }

    @PutMapping(value="/{id}")
    @ResponseBody
    Course update(@RequestBody String personData, @PathVariable Integer id) throws JsonProcessingException {
        Optional<Course> tempCourse = courseRepository.findById(id);
        Course currentCourse = tempCourse.get();
        JsonNode jsonNode = Json.parse(personData);

        Course course = Json.fromJson(jsonNode, Course.class);
        currentCourse.update(course);
        return courseRepository.save(currentCourse);

    }
    @PostMapping(value="/create")
    @ResponseBody
    Course create(@RequestBody String personData) throws JsonProcessingException {
        JsonNode jsonNode = Json.parse(personData);

        Course course = Json.fromJson(jsonNode, Course.class);

        return courseRepository.save(course);
    }
}
