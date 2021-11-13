package com.example._3ld.ds;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person extends User {
    private String name;
    private String surname;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name="course_participants",
            joinColumns = @JoinColumn(name="Course_id"),
            inverseJoinColumns = @JoinColumn(name="Participant_id")
    )
    private List<Course> enrolledCourses;

    @OneToMany(mappedBy ="owner",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Course> ownedCourses;

    public Person() {

    }

    public Person(String login, String password, UserType type, String name, String surname, List<Course> enrolledCourses, List<Course> ownedCourses) {
        super(login, password, type);
        this.name = name;
        this.surname = surname;
        this.enrolledCourses = enrolledCourses;
        this.ownedCourses = ownedCourses;
    }

    public Person(String name, String surname, List<Course> enrolledCourses, List<Course> ownedCourses) {
        this.name = name;
        this.surname = surname;
        this.enrolledCourses = enrolledCourses;
        this.ownedCourses = ownedCourses;
    }

    public void update(Person person){
        if(person.getId()!=0){this.setId(person.getId());}
        if(person.getLogin()!=null){this.setLogin(person.getLogin());}
        if(person.getPassword()!=null){this.setPassword(person.getPassword());}
        if(person.getName()!=null) {this.name = person.getName();}
        if(person.getSurname()!=null) {this.surname = person.getSurname();}
        if(person.getEnrolledCourses()!=null) {this.enrolledCourses = person.getEnrolledCourses();}
        if(person.getOwnedCourses()!=null) {this.ownedCourses = person.ownedCourses;}
    }

    @Override
    public String toString(){
        return getUserType() + " " +
                name + ' ' +
                surname + ' ' +
                getLogin() + " " +
                getPassword();
    }

    public Person(String login, String password, String name, String surname, UserType type) {
        super(login, password, type);
        this.name = name;
        this.surname = surname;
    }

    public Person(String login, String password, String name, String surname) {
        super(login, password, UserType.Person);
        this.name = name;
        this.surname = surname;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Course> getOwnedCourses() {
        return ownedCourses;
    }

    public void setOwnedCourses(List<Course> ownedCourses) {
        this.ownedCourses = ownedCourses;
    }

    public void addEnrolledCourse(Course course){
        this.getEnrolledCourses().add(course);
    }
    public void removeEnrolledCourse(Course course){
        this.getEnrolledCourses().removeIf(item -> item.getTitle().equals(course.getTitle()));
    }
}
