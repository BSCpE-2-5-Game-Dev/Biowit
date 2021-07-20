package com.example.biowit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class Bio_LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); // hides the action bar.

        setContentView(R.layout.activity_bio_log_in);

        //Firebase class, texbox/es and button/s declaration
        FirebaseAuth FbaseAuth_LI = FirebaseAuth.getInstance();
        TextInputEditText txtbx_Username = findViewById(R.id.txtbx_Username);
        TextInputEditText txtbx_Password = findViewById(R.id.txtbx_SU_ConfirmPass);
        Button btn_Log_In = findViewById(R.id.btn_Log_In);
        Button btn_Forget_Pass = findViewById(R.id.btn_Forget_Pass);
        Button btn_Sign_Up = findViewById(R.id.btn_Sign_Up);
        AlertDialog.Builder alert_forget_pass = new AlertDialog.Builder(this);
        LayoutInflater inflater_alert = this.getLayoutInflater();

        btn_Log_In.setOnClickListener(v -> {
            // data extraction and validation
            if(txtbx_Username.getText().toString().isEmpty()){ // condition when email address textbox is not filled,
                txtbx_Username.setError("Email Address is missing."); // error message shows
                return;
            }
            if(txtbx_Password.getText().toString().isEmpty()){ // gives error message when no password textbox is not filled,
                txtbx_Password.setError("Password is missing."); // error message shows
                return;
            }

            // successful account log in
            FbaseAuth_LI.signInWithEmailAndPassword(txtbx_Username.getText().toString(),txtbx_Password.getText().toString())
                    .addOnSuccessListener(authResult -> { startActivity(new Intent(getApplicationContext(), MM_Play.class));
                finish();
            }).addOnFailureListener(e -> Toast.makeText(Bio_LogIn.this, e.getMessage(), Toast.LENGTH_LONG).show()); // error message shows when log-in fails.
        });

        // When "Forget Password" is clicked, an alert dialog will appear.
        btn_Forget_Pass.setOnClickListener(v -> {

            View view = inflater_alert.inflate(R.layout.alert_forget_pass, null);
            alert_forget_pass.setTitle("Forget Password ?")
                    .setMessage("Enter your Email Address to get a Password Reset link.")
                    .setPositiveButton("Reset", (dialog, which) -> {

                        TextInputEditText txtbx_FP_Email = view.findViewById(R.id.txtbx_FP_Email);
                        if (txtbx_FP_Email.getText().toString().isEmpty()) { // when the email address textbox is not filled, an error message shows.
                            txtbx_FP_Email.setError("Required Field");
                            return;
                        }

                        FbaseAuth_LI.sendPasswordResetEmail(txtbx_FP_Email.getText().toString())
                                // When email address is valid, a successful message shows.
                                .addOnSuccessListener(aVoid -> Toast.makeText(Bio_LogIn.this, "Password Reset Link Sent", Toast.LENGTH_LONG).show())
                                // When email address is invalid, an error message shows.
                                .addOnFailureListener(e -> Toast.makeText(Bio_LogIn.this, e.getMessage(), Toast.LENGTH_LONG).show());
                    }).setNegativeButton("Cancel", null) // will cancel the password reset
                    .setView(view)
                    .create().show();
        });

        btn_Sign_Up.setOnClickListener(v -> startActivity(new Intent(Bio_LogIn.this, Bio_SignUp.class)));
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