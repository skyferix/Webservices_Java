package com.example._3ld.dto;

import com.example._3ld.ds.Course;
import com.example._3ld.ds.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDTO {

    private int id;
    private String title;
    private String description;
    private LocalDate createdDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private String owner;
    private List<Integer> participants;

    public List<Integer> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Person> participants) {
        List<Integer> ids = new ArrayList<>();
        for(Person person: participants){
            ids.add(person.getId());
        }
        this.participants = ids;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
