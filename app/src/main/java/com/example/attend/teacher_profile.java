package com.example.attend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class teacher_profile extends AppCompatActivity {
        TextView name , department , email ,password , phone ,year ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile);

        name = findViewById(R.id.t_name);
        department = findViewById(R.id.t_department);
        email = findViewById(R.id.t_email);
        password = findViewById(R.id.t_password);
        phone = findViewById(R.id.t_phone);
        year = findViewById(R.id.t_year);

        Intent intent = getIntent();
        String t_name  = intent.getStringExtra("name");
        String t_department  = intent.getStringExtra("department");
        String t_year  = intent.getStringExtra("year");
        String t_phone  = intent.getStringExtra("phone");
        String t_email  = intent.getStringExtra("email");
        String t_password  = intent.getStringExtra("password");

        name.setText(t_name);
        department.setText(t_department);
        email.setText(t_email);
        password.setText(t_password);
        phone.setText(t_phone);
        year.setText(t_year);



    }
}