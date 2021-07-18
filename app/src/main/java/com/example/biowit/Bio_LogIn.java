package com.example.biowit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Bio_LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TextInputEditText txtbx_Username, txtbx_Password; //Edit text declarations
        FirebaseAuth FbaseAuth_LI; // Firebase class declaration
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); // hides the action bar.

        setContentView(R.layout.activity_bio_log_in);

        FbaseAuth_LI = FirebaseAuth.getInstance();
        txtbx_Username = findViewById(R.id.txtbx_Username);
        txtbx_Password = findViewById(R.id.txtbx_Password);
        Button btn_Log_In = findViewById(R.id.btn_Log_In);
        Button btn_Forget_Pass = findViewById(R.id.btn_Forget_Pass);
        Button btn_Sign_Up = findViewById(R.id.btn_Sign_Up);

        btn_Log_In.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // data extraction and validation
                if(txtbx_Username.getText().toString().isEmpty()){ // gives error message when no username or email address input
                    txtbx_Username.setError("Username / Email Address is missing."); // error message
                    return;
                }
                if(txtbx_Password.getText().toString().isEmpty()){ // gives error message when no password input
                    txtbx_Password.setError("Password is missing."); // error message
                    return;
                }
                // successful account log in
                FbaseAuth_LI.signInWithEmailAndPassword(txtbx_Username.getText().toString(),txtbx_Password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        startActivity(new Intent(getApplicationContext(), MM_Play.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() { //
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Bio_LogIn.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btn_Forget_Pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Forget_Pass_open = new Intent(Bio_LogIn.this, Bio_ForgetPass.class);
                startActivity(Forget_Pass_open);
            }
        });

        btn_Sign_Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Sign_Up_open = new Intent(Bio_LogIn.this, Bio_SignUp.class);
                startActivity(Sign_Up_open);
            }
        });
    }

    // when the user already logged in in the app, they will go directly to the game.
    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MM_Play.class));
            finish();
        }
    }
}