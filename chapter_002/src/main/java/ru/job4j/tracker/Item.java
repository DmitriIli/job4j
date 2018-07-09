package ru.job4j.tracker;

import java.util.Date;
import java.util.Random;

public class Item {
    String id;
    String name;
    String description;
    Long date;
    String[] comments;
    public Item(){
        this.name = " ";
        this.description = " ";
        this.date = new Date().getTime();
        this.comments = new String[0];
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.date = new Date().getTime();
        this.comments = new String[0];
        this.id = this.generateID();
    }
    public Item(String name, String description, String id){
        this.name = name;
        this.description = description;
        this.id = id;
        this.comments = new String[0];
    }
    public String generateID(){
        return this.id = String.valueOf(date);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String comment) {
       String[] strings = new String[this.comments.length+1];
       strings[strings.length-1] = comment;
       this.comments = strings;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
