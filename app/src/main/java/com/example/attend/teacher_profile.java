
package com.example.attend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.attend.databinding.ActivityTeacherProfileBinding;

public class teacher_profile extends AppCompatActivity {

    ActivityTeacherProfileBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTeacherProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        Intent intent = getIntent();
        String t_name  = intent.getStringExtra("name");
        String t_department  = intent.getStringExtra("department");
        String t_year  = intent.getStringExtra("year");
        String t_phone  = intent.getStringExtra("phone");
        String t_email  = intent.getStringExtra("email");
        String t_qua  = intent.getStringExtra("qua");

        binding.teacherName.setText(t_name);
        binding.teacherDepartment.setText(t_department);
        binding.teacherYear.setText(t_year);
        binding.teacherPhone.setText(t_phone);
        binding.teacherMail.setText(t_email);
        binding.teacherQualification.setText(t_qua);

        binding.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Intent.ACTION_CALL);
                intent1.setData(Uri.parse("tel:"+t_phone));
                startActivity(intent1);
            }
        });



    }
}