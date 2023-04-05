package com.example.attend.Autenthication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.attend.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class admin_sign_up extends AppCompatActivity {

        EditText email , password , first_name , last_name ;
        Button sign_up , login ;
        FirebaseAuth auth ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_up);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

                email = findViewById(R.id.email);
                password = findViewById(R.id.password);
                first_name = findViewById(R.id.first_name);
                last_name = findViewById(R.id.last_name);
                sign_up = findViewById(R.id.sign_up);
                login = findViewById(R.id.login_text);

                auth = FirebaseAuth.getInstance();

                sign_up.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        ProgressDialog pd = new ProgressDialog(view.getContext());
                        pd.setTitle("Signup");
                        pd.setMessage("Creating Account......");
                        pd.setCancelable(false);
                        pd.setCanceledOnTouchOutside(false);

                        String mail = email.getText().toString();
                        String pass = password.getText().toString();
                        String lastname = last_name.getText().toString();
                        String firstname = first_name.getText().toString();

                        if (TextUtils.isEmpty(mail))
                        {
                            email.setError("Please Enter the Email ");
                            return;
                        }
                        if (TextUtils.isEmpty(pass))
                        {
                            password.setError("Please Enter the Password");
                            return;
                        }
                        if (TextUtils.isEmpty(lastname))
                        {
                            last_name.setError("Please Enter the Last Name ");
                            return;
                        }
                        if (TextUtils.isEmpty(firstname))
                        {
                            first_name.setError("Please Enter the First Name ");
                            return;
                        }

                        pd.show();
                        auth.createUserWithEmailAndPassword(mail,pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(admin_sign_up.this, "Account Successfully Created ", Toast.LENGTH_SHORT).show();
                                pd.dismiss();
                                email.setText(null);
                                password.setText(null);
                                last_name.setText(null);
                                first_name.setText(null);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(admin_sign_up.this, "Error :"+e.toString(), Toast.LENGTH_SHORT).show();
                                pd.dismiss();
                            }
                        });
                    }
                });

                login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getApplicationContext(),Admin_login.class));
                    }
                });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),Admin_login.class));
    }
}