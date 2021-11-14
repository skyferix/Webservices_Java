package com.example._3ld.controller;

import com.example._3ld.Repositories.CourseRepository;
import com.example._3ld.Repositories.FileRepository;
import com.example._3ld.ds.Course;
import com.example._3ld.ds.File;
import com.example._3ld.jsonparsing.Json;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value="/file")
public class FileController {

    @Autowired
    private FileRepository fileRepository;

    @RequestMapping(value="")
    String index(){
        return "File controller";
    }

    @GetMapping(value="/{id}")
    @ResponseBody
    Optional<File> get(@PathVariable Integer id){
        return fileRepository.findById(id);
    }

    @DeleteMapping(value="/{id}")
    @ResponseBody
    String delete(@PathVariable Integer id){
        fileRepository.deleteById(id);
        return "Success";
    }

    @PutMapping(value="/{id}")
    @ResponseBody
    File update(@RequestBody String personData, @PathVariable Integer id) throws JsonProcessingException {
        Optional<File> tempFile = fileRepository.findById(id);
        File currentFile = tempFile.get();
        JsonNode jsonNode = Json.parse(personData);

        File file = Json.fromJson(jsonNode, File.class);
        currentFile.update(file);
        return fileRepository.save(currentFile);

    }
    @PostMapping(value="/create")
    @ResponseBody
    File create(@RequestBody String personData) throws JsonProcessingException {
        JsonNode jsonNode = Json.parse(personData);

        File file = Json.fromJson(jsonNode, File.class);

        return fileRepository.save(file);
    }
}
