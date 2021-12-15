package com.example._3ld.controller;

import com.example._3ld.Repositories.FolderRepository;
import com.example._3ld.ds.Folder;
import com.example._3ld.jsonparsing.Json;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value="/folder")
public class FolderController {

    @Autowired
    private FolderRepository folderRepository;

    @RequestMapping(value="")
    String index(){
        return "Folder controller";
    }

    @GetMapping(value="/{id}")
    @ResponseBody
    Optional<Folder> get(@PathVariable Integer id){
        return folderRepository.findById(id);
    }

    @DeleteMapping(value="/{id}")
    @ResponseBody
    String delete(@PathVariable Integer id){
        folderRepository.deleteById(id);
        return "Success";
    }

//    @PutMapping(value="/{id}")
//    @ResponseBody
//    Folder update(@RequestBody String personData, @PathVariable Integer id) throws JsonProcessingException {
//        Optional<Folder> tempFolder = folderRepository.findById(id);
//        Folder currentFolder = tempFolder.get();
//        JsonNode jsonNode = Json.parse(personData);
//
//        Folder folder = Json.fromJson(jsonNode, Folder.class);
//        currentFolder.update(folder);
//        return folderRepository.save(currentFolder);
//
//    }
    @PostMapping(value="/create")
    @ResponseBody
    Folder create(@RequestBody String personData) throws JsonProcessingException {
        JsonNode jsonNode = Json.parse(personData);

        Folder folder = Json.fromJson(jsonNode, Folder.class);

        return folderRepository.save(folder);
    }
}
