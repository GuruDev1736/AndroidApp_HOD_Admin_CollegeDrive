package com.example.attend.Department;

import static com.example.attend.Constants.error_toast;
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
import com.example.attend.adapter.teacher_adapter;
import com.example.attend.model.teacher_model;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.FirebaseDatabase;

public class computer extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner ;
    RecyclerView recyclerView ;
    teacher_adapter teacher_adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);

        spinner = findViewById(R.id.computer_spinner);
        recyclerView = findViewById(R.id.comp_rec);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, choice, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);



    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String choice = spinner.getSelectedItem().toString();

        switch (choice)
        {
            case "Teacher":
                recyclerView.setLayoutManager(new LinearLayoutManager(computer.this));
                FirebaseRecyclerOptions<teacher_model> options = new FirebaseRecyclerOptions.Builder<teacher_model>().setQuery(FirebaseDatabase.getInstance().
                        getReference("Teachers").child("Computer"), teacher_model.class).build();

                teacher_adapter = new teacher_adapter(options);
                teacher_adapter.startListening();
                recyclerView.setAdapter(teacher_adapter);
                break;

            case "Student" :

                break;
            default:
                error_toast(computer.this,"Invalid Input");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}