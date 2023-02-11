package com.example.attend;

import static android.content.ContentValues.TAG;
import static com.example.attend.Constants.error_toast;
import static com.example.attend.Constants.success_toast;
import static com.example.attend.R.array.department_type;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.attend.databinding.ActivityAddTeacherBinding;
import com.example.attend.model.teacher_model;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.List;

public class add_teacher extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private ActivityAddTeacherBinding binding ;
    RadioGroup radioGroup ;
    RadioButton radioButton ;
    Spinner spinner ;
    DatabaseReference databaseReference ;
    FirebaseDatabase database ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddTeacherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        radioGroup = findViewById(R.id.radio_layout);


        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Teachers");


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, department_type , android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
        binding.department.setAdapter(adapter);
        binding.department.setOnItemSelectedListener(this);

        binding.submitTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=  binding.radioLayout.getCheckedRadioButtonId();
                radioButton = findViewById(id);

                String teacher_name = binding.teacherName.getText().toString();
                String teacher_qual = binding.teacherQualification.getText().toString();
                String department  = binding.department.getSelectedItem().toString();
                String year = radioButton.getText().toString();
                String email  = binding.teacherEmail.getText().toString();
                String password = binding.teacherPassword.getText().toString();
                String phone = binding.teacherPhoneNo.getText().toString();
                String message = "Hello ! "+teacher_name+" Our Institute JSPM Polytechnic Has Been Added You In Our Database You Have Been Added To "
                        +department+"And Your Email is : "+email+" And Your Password is : "+password+" Now You Can Log in our Teachers Application ";

                if (TextUtils.isEmpty(teacher_name) && TextUtils.isEmpty(teacher_qual) && TextUtils.isEmpty(email) )
                {
                    error_toast(getApplicationContext(),"Please Enter All The Fields");
                    return;
                }

                if (department.length()<1)
                {
                    error_toast(getApplicationContext(),"Please Select the Department ");
                    return;
                }

                if (password.length() !=6)
                {
                    error_toast(getApplicationContext() , "Password Must be 6 Characters");
                    return;
                }

                if (phone.length()!=10)
                {
                    error_toast(getApplicationContext(),"Phone No is not valid");
                    return;
                }

                ProgressDialog pd = new ProgressDialog(view.getContext());
                pd.setMessage("Please Wait...");
                pd.setTitle("Adding Teacher");
                pd.setCancelable(false);
                pd.setCanceledOnTouchOutside(false);
                pd.show();

                teacher_model model = new teacher_model(teacher_name,teacher_qual,department,year,email,password,phone);
                databaseReference.child(department).child(databaseReference.push().getKey()).setValue(model)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                success_toast(getApplicationContext(),"Teacher Added Successfully");
                                pd.dismiss();

                                // setting the edittext null after the get stored in database
                                binding.teacherName.setText(null);
                                binding.teacherQualification.setText(null);
                                binding.teacherEmail.setText(null);
                                binding.teacherPassword.setText(null);
                                binding.teacherPhoneNo.setText(null);

                                // granting the permissions using Dexter lib
                                //sending sms using intent

                                Dexter.withContext(getApplicationContext()).withPermissions(Manifest.permission.SEND_SMS, Manifest.permission.RECEIVE_SMS
                                        , Manifest.permission.READ_SMS).withListener(new MultiplePermissionsListener() {
                                    @Override
                                    public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {

                                        SmsManager smsManager = SmsManager.getDefault();
                                        smsManager.sendTextMessage(phone, null, message, null, null);

                                    }
                                    @Override
                                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                                    }
                                }).check();


                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                pd.dismiss();
                                error_toast(getApplicationContext(),"Error : "+e.getMessage() );
                            }
                        });



            }
        });
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}