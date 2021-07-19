package com.example.biowit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MM_Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); // hides the action bar.

        setContentView(R.layout.activity_mm_settings);

        ImageButton imgbtn_About_Us = findViewById(R.id.imgbtn_About_Us);
        ImageButton imgbtn_ST_Back = findViewById(R.id.imgbtn_ST_Back);

        imgbtn_About_Us.setOnClickListener(new View.OnClickListener() { // "About Us" screen will be shown when the image button is clicked.
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MM_AboutUs.class));
            }
        });

        imgbtn_ST_Back.setOnClickListener(v -> finish()); // when the "Back" button is clicked, you will return to the previous activity / screen.

    }
}