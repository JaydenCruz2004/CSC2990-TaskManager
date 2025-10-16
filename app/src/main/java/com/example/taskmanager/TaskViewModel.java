package com.example.taskmanager;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class TaskViewModel extends ViewModel {
    private final MutableLiveData<List<String>> tasks = new MutableLiveData<>(new ArrayList<>());

    public LiveData<List<String>> getTasks() {
        return tasks;
    }

    public void addTask(String task) {
        List<String> current = new ArrayList<>(tasks.getValue());
        current.add(task);
        tasks.setValue(current);
    }
}
