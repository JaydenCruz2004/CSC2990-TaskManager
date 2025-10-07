package com.example.taskmanager;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class InputFragment extends Fragment {

    private EditText editTextTask, editTextWho;
    private Button buttonAdd;
    private OnTaskAddedListener callback;

    public interface OnTaskAddedListener {
        void onTaskAdded(String task);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnTaskAddedListener) {
            callback = (OnTaskAddedListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnTaskAddedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);

        editTextTask = view.findViewById(R.id.editTextTask);
        editTextWho = view.findViewById(R.id.editTextWho);
        buttonAdd = view.findViewById(R.id.buttonAdd);

        buttonAdd.setOnClickListener(v -> {
            String task = editTextTask.getText().toString().trim();
            String who = editTextWho.getText().toString().trim();

            if (!task.isEmpty() && !who.isEmpty()) {
                callback.onTaskAdded(task + " by " + who);
                editTextTask.setText("");
                editTextWho.setText("");
            }
        });

        return view;
    }
}
