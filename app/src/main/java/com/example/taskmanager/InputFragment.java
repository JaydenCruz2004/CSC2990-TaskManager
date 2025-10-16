package com.example.taskmanager;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class InputFragment extends Fragment {

    private EditText editTextTask, editTextWho;
    private Button buttonAdd;
    private TaskViewModel taskViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);

        editTextTask = view.findViewById(R.id.editTextTask);
        editTextWho = view.findViewById(R.id.editTextWho);
        buttonAdd = view.findViewById(R.id.buttonAdd);

        // Get shared ViewModel (scoped to Activity)
        taskViewModel = new ViewModelProvider(requireActivity()).get(TaskViewModel.class);

        buttonAdd.setOnClickListener(v -> {
            String task = editTextTask.getText().toString().trim();
            String who = editTextWho.getText().toString().trim();

            if (!task.isEmpty() && !who.isEmpty()) {
                taskViewModel.addTask(task + " by " + who);
                editTextTask.setText("");
                editTextWho.setText("");
            }
        });

        return view;
    }
}
