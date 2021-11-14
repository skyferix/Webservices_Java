package com.example._3ld.ds;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Folder extends Hib {
    private String title;

    @ManyToOne
    @JoinColumn(name="parent_course_id", referencedColumnName = "id")
    private Course parentCourse;

    @OneToMany(mappedBy = "parentFolder",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @OrderBy("id ASC")
    private List<Folder> subFolders;

    @ManyToOne
    @JoinColumn(name="parent_folder_id", referencedColumnName = "id")
    private Folder parentFolder;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="folder_id")
    @OrderBy("id ASC")
    private List<File> folderFiles;

    @ManyToMany(mappedBy = "folders", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @OrderBy("id ASC")
    private List<User> moderators = new ArrayList<>();

    public Folder() {
    }

    public void update(Folder folder){
        if(folder.getTitle()!=null) {this.title = folder.getTitle();}
        if(folder.getParentCourse()!=null) {this.parentCourse = folder.getParentCourse();}
        if(folder.getSubFolders()!=null) {this.subFolders = folder.getSubFolders();}
        if(folder.getParentFolder()!=null) {this.parentFolder = folder.getParentFolder();}
        if(folder.getFolderFiles()!=null) {this.folderFiles = folder.getFolderFiles();}
        if(folder.getModerators()!=null) {this.moderators = folder.getModerators();}
    }

    public List<User> getModerators() {
        return moderators;
    }

    public void setModerators(List<User> moderators) {
        this.moderators = moderators;
    }

    public Folder(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Course getParentCourse() {
        return parentCourse;
    }

    public void setParentCourse(Course parentCourse) {
        this.parentCourse = parentCourse;
    }

    public List<Folder> getSubFolders() {
        return subFolders;
    }

    public void setSubFolders(List<Folder> subFolders) {
        this.subFolders = subFolders;
    }

    public Folder getParentFolder() {
        return parentFolder;
    }

    public void setParentFolder(Folder parentFolder) {
        this.parentFolder = parentFolder;
    }

    public List<File> getFolderFiles() {
        return folderFiles;
    }

    public void setFolderFiles(List<File> folderFiles) {
        this.folderFiles = folderFiles;
    }

    public List<User> getEditors() {
        return moderators;
    }

    public void setEditors(List<User> moderators) {
        this.moderators = moderators;
    }
}
