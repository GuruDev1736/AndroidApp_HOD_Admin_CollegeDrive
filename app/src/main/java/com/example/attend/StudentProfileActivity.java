package com.example.attend;

import static com.example.attend.Constants.info_toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.attend.databinding.ActivityStudentProfileBinding;

public class StudentProfileActivity extends AppCompatActivity {

    ActivityStudentProfileBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


//        Intent intent = new Intent(view.getContext(), StudentProfileActivity.class);
//        intent.putExtra("name",model.getStud_name());
//        intent.putExtra("department",model.getDepartment());
//        intent.putExtra("year",model.getYear());
//        intent.putExtra("stud_no",model.getStud_no());
//        intent.putExtra("email",model.getStud_email());
//        intent.putExtra("parent_no",model.getParent_no());
//        intent.putExtra("div",model.getDivision());
//        view.getContext().startActivity(intent);

        Intent intent = getIntent();


        binding.sYear.setText(intent.getStringExtra("year"));
        binding.sName.setText(intent.getStringExtra("name"));
        binding.sDiv.setText(intent.getStringExtra("div"));
        binding.sEmail.setText(intent.getStringExtra("email"));
        binding.sPNo.setText(intent.getStringExtra("parent_no"));
        binding.sSNo.setText(intent.getStringExtra("stud_no"));

        binding.studentNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info_toast(getApplicationContext(),"Calling Student Please Wait");
                Intent intent1 = new Intent(Intent.ACTION_CALL);
                intent1.setData(Uri.parse("tel:"+intent.getStringExtra("stud_no")));
                startActivity(intent1);

            }
        });

        binding.parentNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info_toast(getApplicationContext(),"Calling Parent Please Wait");
                Intent intent1 = new Intent(Intent.ACTION_CALL);
                intent1.setData(Uri.parse("tel:"+intent.getStringExtra("parent_no")));
                startActivity(intent1);
            }
        });



    }
}