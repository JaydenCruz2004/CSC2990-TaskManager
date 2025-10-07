package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements InputFragment.OnTaskAddedListener {

    FragmentManager fg;

    private TaskViewModel taksModel;

    private ListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            taksModel = new ViewModelProvider(this).get(TaskViewModel.class);
            fg = getSupportFragmentManager();
            FragmentTransaction trans = fg.beginTransaction();

        }
        listFragment = (ListFragment) getSupportFragmentManager()
                .findFragmentById(R.id.listFragment);
    }

    @Override
    public void onTaskAdded(String task) {
        if (listFragment != null) {
            listFragment.addTask(task);
        }
    }
}
