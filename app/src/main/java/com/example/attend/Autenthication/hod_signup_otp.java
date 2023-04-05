package com.example.attend.Autenthication;

import static com.example.attend.Constants.error_toast;
import static com.example.attend.Constants.success_toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.attend.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import in.aabhasjindal.otptextview.OtpTextView;

public class hod_signup_otp extends AppCompatActivity {
        OtpTextView otp ;
        Button submit ;
        private String verification_code ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hod_signup_otp);

        otp = findViewById(R.id.otp_view);
        submit = findViewById(R.id.submit_otp);

        verification_code = getIntent().getStringExtra("verification_id");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProgressDialog pd = new ProgressDialog(view.getContext());
                pd.setTitle("Verifying OTP");
                pd.setMessage("Please Wait....");
                pd.setCanceledOnTouchOutside(false);
                pd.setCancelable(false);

                if (otp.getOTP().isEmpty())
                {
                    error_toast(getApplicationContext(),"Enter the Valid OTP");
                    return;
                }

                String code = otp.getOTP().toString();
                if (verification_code!=null)
                {
                   pd.show();
                    PhoneAuthCredential authCredential = PhoneAuthProvider.getCredential(verification_code,code);
                    FirebaseAuth.getInstance().signInWithCredential(authCredential)
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    success_toast(getApplicationContext(),"Verification Successful");
                                    startActivity(new Intent(getApplicationContext(),admin_sign_up.class));
                                    finish();
                                    pd.dismiss();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    error_toast(getApplicationContext(),"Invalid OTP : "+e.getMessage());
                                    pd.dismiss();
                                }
                            });
                }
            }
        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}