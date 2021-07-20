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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Bio_SignUp extends AppCompatActivity {


    EditText txtbx_SU_FullName, txtbx_SU_CPNum, txtbx_SU_Email, txtbx_SU_Pass, txtbx_SU_ConfirmPass; // edit text declarations
    Button btn_Register; // button/s declaration/s
    ImageButton btn_SU_Back;
    FirebaseAuth FbaseAuth_SU; //for authentication
    FirebaseDatabase rootNode; // for realtime database
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); // hides the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); // hides the action bar

        setContentView(R.layout.activity_bio_sign_up);

        txtbx_SU_FullName = findViewById(R.id.txtbx_SU_FullName);
        txtbx_SU_Email = findViewById(R.id.txtbx_SU_Email);
        txtbx_SU_CPNum = findViewById(R.id.txtbx_SU_CPNum);
        txtbx_SU_Pass = findViewById(R.id.txtbx_SU_Pass);
        txtbx_SU_ConfirmPass = findViewById(R.id.txtbx_SU_ConfirmPass);
        btn_Register = findViewById(R.id.btn_Register);
        btn_SU_Back = findViewById(R.id.btn_SU_Back);

        FbaseAuth_SU = FirebaseAuth.getInstance();
        rootNode = FirebaseDatabase.getInstance("https://biowit-log-in-default-rtdb.asia-southeast1.firebasedatabase.app/");
        reference = rootNode.getReference("users");

        btn_Register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                String fullname = txtbx_SU_FullName.getText().toString();
                String email = txtbx_SU_Email.getText().toString();
                String cpnum = txtbx_SU_CPNum.getText().toString();
                String password = txtbx_SU_Pass.getText().toString();
                String ConPassword = txtbx_SU_ConfirmPass.getText().toString();
                String UserID = FbaseAuth_SU.getUid();
                UserHelper UHelper = new UserHelper(fullname, cpnum, email, password);

                if(fullname.isEmpty()){ // condition if full name field is empty,
                    txtbx_SU_FullName.setError("This field cannot be empty."); // this error message will be shown.
                    return;
                }

                if(cpnum.isEmpty()){ // condition if full name field is empty,
                    txtbx_SU_CPNum.setError("This field cannot be empty."); // this error message will be shown.
                    return;
                }

                if(email.isEmpty()){ // condition if full name field is empty,
                    txtbx_SU_Email.setError("This field cannot be empty."); // this error message will be shown.
                    return;
                }

                if(password.isEmpty()){ // condition if full name field is empty,
                    txtbx_SU_Pass.setError("This field cannot be empty."); // this error message will be shown.
                    return;
                }

                if(ConPassword.isEmpty()){ // condition if full name field is empty,
                    txtbx_SU_ConfirmPass.setError("This field cannot be empty."); // this error message will be shown.
                    return;
                }

                if (!ConPassword.equals(password)){ // condition if the confirm password is not equals to password,
                    txtbx_SU_ConfirmPass.setError("Password does not match."); // this error message will be shown.
                    return;
                }

                // notification that says the data is validated.
                Toast.makeText(Bio_SignUp.this, "Data Validated", Toast.LENGTH_LONG).show();

                //Email address and password authentication in the database.
                FbaseAuth_SU.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {

                    @Override
                    public void onSuccess(AuthResult authResult) { // send the user to the log - in screen.

                        reference.child(UserID).setValue(UHelper).addOnSuccessListener(new OnSuccessListener<Void>() {

                            @Override
                            public void onSuccess(Void unused) { // notification that the user was successfully registered.
                                Toast.makeText(Bio_SignUp.this, "Sign - up Successfully!", Toast.LENGTH_LONG).show();
                            }

                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {  // when user failed to sign up, an error message shows.
                                Toast.makeText(Bio_SignUp.this, e.getMessage(), Toast.LENGTH_LONG).show();

                            }
                        });

                        startActivity(new Intent(Bio_SignUp.this, Bio_LogIn.class));
                    }

                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) { // an error when email and pass is wrong or invalid.
                        Toast.makeText(Bio_SignUp.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btn_SU_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}