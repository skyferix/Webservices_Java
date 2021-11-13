package com.example._3ld.controller;

import com.example._3ld.Repositories.*;
import com.example._3ld.ds.*;
import com.example._3ld.jsonparsing.Json;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value="/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping(value="/{id}")
    @ResponseBody
    Optional<Course> get(@PathVariable Integer id){
        return courseRepository.findById(id);
    }

    @DeleteMapping(value="/delete/{id}")
    @ResponseBody
    String delete(@PathVariable Integer id){
        courseRepository.deleteById(id);
        return "Success";
    }

//    @PutMapping(value="/update/{id}")
//    @ResponseBody
//    Course update(@RequestBody String personData, @PathVariable Integer id) throws JsonProcessingException {
//        Optional<Course> tempUser = courseRepository.findById(id);
//        Course currentCourse = tempUser.get();
//        JsonNode jsonNode = Json.parse(personData);
//        Course course = Json.fromJson(jsonNode, Course.class);
//        currentCourse.update(course);
//        return courseRepository.save(currentCourse);
//    }
}
