package com.example.biowit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Bio_LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); // hides the action bar.

        setContentView(R.layout.activity_bio_log_in);

        Button btn_Log_In = findViewById(R.id.btn_Log_In);
        Button btn_Forget_Pass = findViewById(R.id.btn_Forget_Pass);
        Button btn_Sign_Up = findViewById(R.id.btn_Sign_Up);

        btn_Log_In.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Log_In_clicked = new Intent(Bio_LogIn.this, MM_Play.class);
                startActivity(Log_In_clicked);
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
}