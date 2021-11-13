package com.example._3ld.controller;

import com.example._3ld.Repositories.AdminRepository;
import com.example._3ld.Repositories.CompanyRepository;
import com.example._3ld.Repositories.PersonRepository;
import com.example._3ld.Repositories.UserRepository;
import com.example._3ld.ds.*;
import com.example._3ld.jsonparsing.Json;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping(value="/{id}")
    @ResponseBody
    Optional<User> get(@PathVariable Integer id){
        return userRepository.findById(id);
    }

    @DeleteMapping(value="/delete/{id}")
    @ResponseBody
    String delete(@PathVariable Integer id){
        userRepository.deleteById(id);
        return "Success";
    }

    @PutMapping(value="/update/{id}")
    @ResponseBody
    User update(@RequestBody String personData, @PathVariable Integer id) throws JsonProcessingException {
        Optional<User> tempUser = userRepository.findById(id);
        User user = tempUser.get();
        JsonNode jsonNode = Json.parse(personData);

        if(user.getUserType() == UserType.Admin){
            Person currentPerson = (Person) user;
            Person person = Json.fromJson(jsonNode, Person.class);
            currentPerson.update(person);
            return personRepository.save(currentPerson);
        }
        else if(user.getUserType() == UserType.Person){
            Admin currentAdmin = (Admin) user;
            Admin admin = Json.fromJson(jsonNode, Admin.class);
            currentAdmin.update(admin);
            return adminRepository.save(currentAdmin);
        }
        else if(user.getUserType() == UserType.Company){
            Company currentCompany = (Company) user;
            Company company = Json.fromJson(jsonNode, Company.class);
            currentCompany.update(company);
            return companyRepository.save(currentCompany);
        }
        return null;
    }
    @PostMapping(value="/create")
    @ResponseBody
    User create(@RequestBody String personData) throws JsonProcessingException {
        JsonNode jsonNode = Json.parse(personData);

        if(jsonNode.get("userType").toString().equals('\"' + UserType.Admin.toString() + '\"')){
            Admin admin = Json.fromJson(jsonNode, Admin.class);
            return adminRepository.save(admin);
        }
        else if(jsonNode.get("userType").toString().equals('\"' + UserType.Person.toString() + '\"')){
            Person person = Json.fromJson(jsonNode, Person.class);
            return personRepository.save(person);
        }
        else if(jsonNode.get("userType").toString().equals('\"' + UserType.Company.toString() + '\"')){
            Company company = Json.fromJson(jsonNode, Company.class);
            return companyRepository.save(company);
        }
        return null;
    }
}
