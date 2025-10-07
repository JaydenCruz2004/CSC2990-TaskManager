package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements InputFragment.OnTaskAddedListener {

    private ListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
