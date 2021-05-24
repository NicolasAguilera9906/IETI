package com.eci.cosw.springbootsecureapi.model;

import java.util.Date;
public class Task {

    private int id;
    private String description;
    private Date date;
    private User responsible;
    private String state;

    public Task() { }

    public Task(int id, String description, Date date, User responsible , String state) {
        this.state = state;
        this.id = id;
        this.description = description;
        this.date = date;
        this.responsible = responsible;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getResponsible() {
        return responsible;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
    }
}
