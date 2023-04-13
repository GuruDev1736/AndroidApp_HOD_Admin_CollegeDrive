package com.example.attend.teacher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.attend.Department.computer;
import com.example.attend.R;
import com.example.attend.adapter.student_adapter;
import com.example.attend.adapter.teacher_adapter;
import com.example.attend.databinding.ActivityComputerTeacherBinding;
import com.example.attend.model.student_model;
import com.example.attend.model.teacher_model;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ComputerTeacherActivity extends AppCompatActivity  {

    ActivityComputerTeacherBinding binding ;
    teacher_adapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityComputerTeacherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

                binding.compRec.setLayoutManager(new LinearLayoutManager(ComputerTeacherActivity.this));
                FirebaseRecyclerOptions<teacher_model> options = new FirebaseRecyclerOptions.Builder<teacher_model>().setQuery(FirebaseDatabase.getInstance().
                        getReference("Teachers").child("Computer"), teacher_model.class).build();
                adapter = new teacher_adapter(options);
                adapter.startListening();
                binding.compRec.setAdapter(adapter);




    }

}