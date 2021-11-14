package com.example._3ld.ds;

import javax.persistence.*;

@Entity
public class File extends Hib{
    private String name;
    private String path;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="folder_id", referencedColumnName = "id")
    private Folder folder;

    public void update(File file){
        if(file.getName()!=null) {this.name = file.getName();}
        if(file.getPath()!=null) {this.path = file.getPath();}
    }

    public File() {
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
}
