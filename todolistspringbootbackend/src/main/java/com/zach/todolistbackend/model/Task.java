package com.zach.todolistbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "completion")
    private String completion;

    @Column(name = "description")
    private String description;

    public Task(){
        this.description = null;
        this.completion = null;
    }
    public Task(String description, String completion) {
        super();
        this.description = description;
        this.completion = completion;
    }

    public String getCompletion() {
        return completion;
    }

    public void setCompletion(String isCompleted) {
        this.completion = isCompleted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
