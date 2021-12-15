package com.example._3ld.ds;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class File extends Hib{
    private String name;
    private String path;

    @ManyToOne
    @JoinColumn(name="folder_id", referencedColumnName = "id")
    private Folder folder;

    public File() {
    }

    public File(String name, Folder folder) {
        this.name = name;
        this.folder = folder;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return path;
    }

    public void setLocation(String location) {
        this.path = location;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    @Override
    public String toString(){
        return name;
    }
}
