package com.example.biowit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MM_Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); // hides the action bar.

        setContentView(R.layout.activity_mm_profile);

        //label/s, textbox/es and buttons declarations

        TextView lbl_Verify_Email = findViewById(R.id.lbl_Verify_Email);
        Button btn_Verify_Email = findViewById(R.id.btn_Verify_Email);
        Button btn_Log_Out = findViewById(R.id.btn_Log_Out);
        Button btn_PR_Back = findViewById(R.id.btn_PR_Back);
        FirebaseAuth FbAuth_PR = FirebaseAuth.getInstance(); // database class declaration

        //When email is not verified, a message and button will appear.
        if(!FbAuth_PR.getCurrentUser().isEmailVerified()){
            lbl_Verify_Email.setVisibility(View.VISIBLE);
            btn_Verify_Email.setVisibility(View.VISIBLE);
        }

        //When the "Verify Now" button is clicked, an verification email will be sent to email address of the user.
        btn_Verify_Email.setOnClickListener(v -> FbAuth_PR.getCurrentUser().sendEmailVerification().addOnSuccessListener(unused -> {
            Toast.makeText(MM_Profile.this, "Verification Email Sent", Toast.LENGTH_LONG).show();
            lbl_Verify_Email.setVisibility(View.GONE);
            btn_Verify_Email.setVisibility(View.GONE);
        }));

        //Logs out the account when the "Logout" button is clicked.
        btn_Log_Out.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), Bio_LogIn.class));
            finish();
        });

        //returns to the Home Screen.
        btn_PR_Back.setOnClickListener(v -> finish());
    }
}
