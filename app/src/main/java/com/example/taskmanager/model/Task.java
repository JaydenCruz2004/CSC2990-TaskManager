package com.example.taskmanager.model;

import android.content.ContentProvider;

public class Task {
    String task;
    String owner;


    public Task(String task, String owner){
        this.task = task;
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Task{" +
                "task='" + task + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
