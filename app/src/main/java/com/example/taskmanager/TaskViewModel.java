package com.example.taskmanager;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.LinkedList;

public class TaskViewModel extends ViewModel {
    private MutableLiveData<LinkedList<String>> taskLL;

    public TaskViewModel(MutableLiveData<LinkedList<String>> taskLL){
        this.taskLL = taskLL;
        LinkedList<String> l = new LinkedList<>();
        taskLL.setValue(l);
    }

    public MutableLiveData<LinkedList<String>> getTask(){
        return taskLL;
    }
    public void addTask(String task){
        LinkedList<String> l = getTask().getValue();
        l.add(task);
        Log.i("TASKS", l.toString());
        taskLL.setValue(l);
    }
    public void setTask(LinkedList<String> tasks){
        taskLL.setValue(tasks);
    }



}
