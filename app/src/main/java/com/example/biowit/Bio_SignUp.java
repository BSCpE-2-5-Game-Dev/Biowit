package com.example.biowit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Bio_SignUp extends AppCompatActivity {

    EditText txtbx_SU_FullName, txtbx_SU_Email, txtbx_SU_Uname, txtbx_SU_Pass, txtbx_SU_ConfirmPass;
    Button btn_Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); // hides the action bar.

        setContentView(R.layout.activity_bio_sign_up);

        txtbx_SU_FullName = findViewById(R.id.txtbx_SU_FullName);
        txtbx_SU_Email = findViewById(R.id.txtbx_SU_Email);
        txtbx_SU_Uname = findViewById(R.id.txtbx_SU_Uname);
        txtbx_SU_Pass = findViewById(R.id.txtbx_SU_Pass);
        txtbx_SU_ConfirmPass = findViewById(R.id.txtbx_SU_ConfirmPass);
        btn_Register = findViewById(R.id.btn_Register);

        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String FullName = txtbx_SU_FullName.getText().toString();
                String Email = txtbx_SU_Email.getText().toString();
                String Username = txtbx_SU_Uname.getText().toString();
                String Password = txtbx_SU_Pass.getText().toString();
                String ConPassword = txtbx_SU_ConfirmPass.getText().toString();

                if(FullName.isEmpty()){
                    txtbx_SU_FullName.setError("This field cannot be empty.");
                    return;
                }

                if(Email.isEmpty()){
                    txtbx_SU_Email.setError("This field cannot be empty");
                    return;
                }

                if(Username.isEmpty()){
                    txtbx_SU_Uname.setError("This field cannot be empty");
                    return;
                }

                if(Password.isEmpty()){
                    txtbx_SU_Pass.setError("This field cannot be empty");
                    return;
                }

                if (!ConPassword.equals(Password)){
                    txtbx_SU_ConfirmPass.setError("Password does not match.");
                    return;
                }

                Toast.makeText(Bio_SignUp.this, "Data Validated", Toast.LENGTH_LONG).show();
            }
        });
    }
}