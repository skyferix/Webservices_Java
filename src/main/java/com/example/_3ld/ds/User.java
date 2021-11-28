package com.example._3ld.ds;

import com.example._3ld.helpers.Helper;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public abstract class User extends Hib {
    @Column(unique = true, name="login")
    private String login;
    @Column(name="password")
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private UserType userType;

    @ManyToMany(mappedBy = "courseModerators", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @OrderBy("id ASC")
    private List<Course> moderatedCourses;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="folder_user",
            joinColumns = @JoinColumn(name="folder_id"),
            inverseJoinColumns = @JoinColumn(name="user_id")
    )
    private List<Folder> folders;

    public User(String login, String password, UserType type) {
        this.login = login;
        this.password = Helper.hashPwd(password);
        this.userType = type;
        this.moderatedCourses = new ArrayList<>();
    }

    public User() {
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<Course> getModeratedCourses() {
        return moderatedCourses;
    }

    public void setModeratedCourses(List<Course> moderatedCourses) {
        this.moderatedCourses =moderatedCourses;
    }
}
