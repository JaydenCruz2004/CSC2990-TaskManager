package com.example.taskmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ListFragment extends Fragment {

    private ListView listView;
    private ArrayList<String> tasks;
    private ArrayAdapter<String> adapter;
    private SharedPreferences prefs;
    private TaskViewModel taskModel;

    ListView listViewWidget;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        listView = view.findViewById(R.id.listViewTasks);
        prefs = getActivity().getSharedPreferences("TaskPrefs", Context.MODE_PRIVATE);

        // Load saved tasks
        Set<String> savedTasks = prefs.getStringSet("tasks", new HashSet<>());
        tasks = new ArrayList<>(savedTasks);

        adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, tasks);
        listView.setAdapter(adapter);

        return view;
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        taskModel = new ViewModelProvider(getActivity()).get(TaskViewModel.class);
        taskModel.getTask().observe(getViewLifecycleOwner(), new Observer<LinkedList<String>>() {
            @Override
            public void onChanged(LinkedList<String> strings) {

            }
        });
    }
    public void addTask(String task) {
        tasks.add(task);
        adapter.notifyDataSetChanged();

        // Save tasks persistently
        SharedPreferences.Editor editor = prefs.edit();
        editor.putStringSet("tasks", new HashSet<>(tasks));
        editor.apply();
    }
}
