package com.example._3ld.ds;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Course extends Hib {
    @Column(unique = true)
    private String title;
    private String description;
    private LocalDate createdDate;
    private LocalDate startDate;
    private LocalDate endDate;

    public void update(Course course){
        if(course.getTitle()!=null) {this.title = course.getTitle();}
        if(course.getDescription()!=null) {this.description = course.getDescription();}
        if(course.getCreatedDate()!=null) {this.createdDate = course.getCreatedDate();}
        if(course.getStartDate()!=null) {this.startDate = course.getStartDate();}
        if(course.getEndDate()!=null) {this.endDate = course.getEndDate();}
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="course_moderator",
            joinColumns = @JoinColumn(name="Course_id"),
            inverseJoinColumns = @JoinColumn(name="Moderator_id")
    )
    private List<User> courseModerators;

    @ManyToMany(mappedBy = "enrolledCourses", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @OrderBy("id ASC")
    private List<Person> participants;

    @OneToMany(mappedBy = "parentCourse",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @OrderBy("id ASC")
    private List<Folder> courseFolders;

    @ManyToOne
    @JoinColumn(name="owner_id", referencedColumnName = "id")
    private Person owner;

    public Course(String title, String description, LocalDate createdDate, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Course(String title, String description, LocalDate createdDate, LocalDate startDate, LocalDate endDate, Person owner) {
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.owner = owner;
    }

    public Course() {
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public void setParticipants(List<Person> participants) {
        this.participants = participants;
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

    public List<User> getCourseModerator() {
        return courseModerators;
    }

    public void setCourseModerator(List<User> courseModerators) {
        this.courseModerators = courseModerators;
    }

    public List<Person> getParticipants() {
        return participants;
    }

    public void setStudents(List<Person> participants) {
        this.participants= participants;
    }

    public List<Folder> getCourseFolders() {
        return courseFolders;
    }

    public void setCourseFolders(List<Folder> courseFolders) {
        this.courseFolders = courseFolders;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public List<User> getCourseModerators() {
        return courseModerators;
    }

    public void setCourseModerators(List<User> courseModerators) {
        this.courseModerators = courseModerators;
    }

    public void addParticipant(Person person){
        this.participants.add(person);
    }
}
