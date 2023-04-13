package com.example.attend.Department;

import static com.example.attend.Constants.error_toast;
import static com.example.attend.Constants.info_toast;
import static com.example.attend.R.array.choice;
import static com.example.attend.R.array.department_type;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.attend.R;
import com.example.attend.adapter.student_adapter;
import com.example.attend.adapter.teacher_adapter;
import com.example.attend.databinding.ActivityComputerBinding;
import com.example.attend.model.student_model;
import com.example.attend.model.teacher_model;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.FirebaseDatabase;

public class computer extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ActivityComputerBinding binding ;
    student_adapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityComputerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ArrayAdapter<CharSequence> year = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_item);
        year.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
        binding.yearSpinner.setAdapter(year);
        binding.yearSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.division, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
        binding.divSpinner.setAdapter(adapter2);
        binding.divSpinner.setOnItemSelectedListener(this);


        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info_toast(getApplicationContext(),"Please Wait Fetching Data");

                String year = binding.yearSpinner.getSelectedItem().toString();
                String division = binding.divSpinner.getSelectedItem().toString();

                binding.compRec.setLayoutManager(new LinearLayoutManager(computer.this));
                FirebaseRecyclerOptions<student_model> options = new FirebaseRecyclerOptions.Builder<student_model>().setQuery(FirebaseDatabase.getInstance().
                        getReference("Students").child("Computer").child(year).child(division), student_model.class).build();
                adapter = new student_adapter(options);
                adapter.startListening();
                binding.compRec.setAdapter(adapter);



            }
        });



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}