package com.example.biowit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Bio_SignUp extends AppCompatActivity {


    EditText txtbx_SU_FullName, txtbx_SU_Email, txtbx_SU_Pass, txtbx_SU_ConfirmPass; // edit text declarations.
    Button btn_Register; // button/s declaration/s.
    FirebaseAuth FbaseAuth_SU; //database declaration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); // hides the action bar.

        setContentView(R.layout.activity_bio_sign_up);

        txtbx_SU_FullName = findViewById(R.id.txtbx_SU_FullName);
        txtbx_SU_Email = findViewById(R.id.txtbx_SU_Email);
        txtbx_SU_Pass = findViewById(R.id.txtbx_SU_Pass);
        txtbx_SU_ConfirmPass = findViewById(R.id.txtbx_SU_ConfirmPass);
        btn_Register = findViewById(R.id.btn_Register);
        ImageButton btn_SU_Back = findViewById(R.id.btn_SU_Back);

        FbaseAuth_SU = FirebaseAuth.getInstance();

        btn_SU_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String FullName = txtbx_SU_FullName.getText().toString();
                String Email = txtbx_SU_Email.getText().toString();
                String Password = txtbx_SU_Pass.getText().toString();
                String ConPassword = txtbx_SU_ConfirmPass.getText().toString();

                if(FullName.isEmpty()){ // condition if full name field is empty,
                    txtbx_SU_FullName.setError("This field cannot be empty."); // this error message will be shown.
                    if(!FullName.matches("^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$")){
                        txtbx_SU_FullName.setError("Your Full Name is invalid."); // this error message will be shown.
                        return;
                    }
                    return;
                }

                if(Email.isEmpty()){ // condition if Email address field is empty,
                    txtbx_SU_Email.setError("This field cannot be empty"); // this error message will be shown.
                    if(!Email.matches(" ^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+(?:\\\\.[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\\\.[a-zA-Z0-9-]+)*$")){
                        txtbx_SU_Email.setError("Your Email Address is invalid."); // this error message will be shown.
                        return;
                    }
                    return;
                }

                if(Password.isEmpty()){ // condition if password field is empty,
                    txtbx_SU_Pass.setError("This field cannot be empty"); // this error message will be shown.
                    return;
                }

                if (!ConPassword.equals(Password)){ // condition if the confirm password is not equals to password,
                    txtbx_SU_ConfirmPass.setError("Password does not match."); // this error message will be shown.
                    return;
                }

                Toast.makeText(Bio_SignUp.this, "Data Validated", Toast.LENGTH_LONG).show(); // notification that data is validated.

                FbaseAuth_SU.createUserWithEmailAndPassword(Email,Password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) { // send the user to the log - in screen.
                        startActivity(new Intent(getApplicationContext(), Bio_LogIn.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) { // an error when email and pass is wrong or invalid.
                        Toast.makeText(Bio_SignUp.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}