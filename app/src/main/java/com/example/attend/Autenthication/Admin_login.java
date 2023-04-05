package com.example.attend.Autenthication;

import static com.example.attend.Constants.error_toast;
import static com.example.attend.Constants.success_toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.attend.R;
import com.example.attend.dashboard.admin_dashboard;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import es.dmoral.toasty.Toasty;

public class Admin_login extends AppCompatActivity {
        EditText email , password ;
        Button login , signup ;
        FirebaseAuth auth ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);

        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        login = findViewById(R.id.login_btn);
        signup = findViewById(R.id.login_signup);
        auth = FirebaseAuth.getInstance();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

//       FirebaseUser user = auth.getCurrentUser();
//        if (user!=null)
//        {
//            startActivity(new Intent(getApplicationContext(), admin_dashboard.class));
//            finish();
//        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mail = email.getText().toString();
                String pass = password.getText().toString();

                if (TextUtils.isEmpty(mail))
                {
                    email.setError("Enter the mail ");
                    return;
                }
                if (TextUtils.isEmpty(pass))
                {
                    password.setError("Enter the password ");
                    return;
                }
                if (pass.length()<6)
                {
                    password.setError("min 6 Characters");
                    return;
                }

                ProgressDialog pd = new ProgressDialog(view.getContext());
                pd.setTitle("Login");
                pd.setMessage("Please Wait ....");
                pd.setCancelable(false);
                pd.setCanceledOnTouchOutside(false);
                pd.show();

                auth.signInWithEmailAndPassword(mail,pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {

                                startActivity(new Intent(getApplicationContext(), admin_dashboard.class));
                                finish();
                                pd.dismiss();
                                Toasty.success(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG, true).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                             //   Toasty.error(getApplicationContext(), "Error : "+e.getMessage(), Toast.LENGTH_LONG, true).show();
                                error_toast(getApplicationContext(),"Error : "+e.getMessage());
                                pd.dismiss();
                            }
                        });

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog pd = new ProgressDialog(view.getContext());
                pd.setTitle("Sending OTP ");
                pd.setMessage("Please Wait...");
                pd.setCancelable(false);
                pd.setCanceledOnTouchOutside(false);
                pd.show();
                PhoneAuthProvider.getInstance().verifyPhoneNumber("+919697981736",60, TimeUnit.SECONDS,Admin_login.this
                ,new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                pd.dismiss();
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                error_toast(getApplicationContext(),"Failed To send OTP : "+e.getMessage());
                                pd.dismiss();
                            }

                            @Override
                            public void onCodeSent(@NonNull String verification_ID, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                super.onCodeSent(verification_ID, forceResendingToken);
                                    pd.dismiss();
                                    Intent intent = new Intent(getApplicationContext(),hod_signup_otp.class);
                                    intent.putExtra("verification_id",verification_ID);
                                    startActivity(intent);
                                    finish();
                            }
                        });

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}