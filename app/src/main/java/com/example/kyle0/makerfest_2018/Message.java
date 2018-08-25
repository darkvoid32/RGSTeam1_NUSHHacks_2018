package com.example.kyle0.makerfest_2018;

import java.io.Serializable;

public class Message implements Serializable {

    private String name;
    private String time;
    private String date;
    private String message;
    private String color;

    public Message() {
    }

    public Message(String name, String time, String date, String message, String color) {
        this.name = name;
        this.time = time;
        this.date = date;
        this.message = message;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String message) {
        this.color = color;
    }
}
