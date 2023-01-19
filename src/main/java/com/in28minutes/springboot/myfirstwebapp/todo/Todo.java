package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


public class Todo {

    private int id;
    private String name;
    @Size(min = 10, message = "Enter at least 10 characters")
    private String description;
    private LocalDate targetDate;
    private Boolean done;

    public Todo(int id, String name, String description, LocalDate targetDate, Boolean done) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public Boolean getDone() {
        return done;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", localDate=" + targetDate +
                ", done=" + done +
                '}';
    }
}
