package com.example.biowit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;


public class MM_Play extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); // hides the action bar.
        
        setContentView(R.layout.activity_mm_play);

        ImageButton imgbtn_Shop =  findViewById(R.id.imgbtn_Shop);
        ImageButton imgbtn_Achievements =  findViewById(R.id.imgbtn_Achievements);
        ImageButton imgbtn_Cell_Quest =  findViewById(R.id.imgbtn_Cell_Quest);
        ImageButton imgbtn_Leaderboard =  findViewById(R.id.imgbtn_Leaderboard);
        ImageButton imgbtn_Settings =  findViewById(R.id.imgbtn_Settings);
        ImageButton imgbtn_Profile = findViewById(R.id.imgbtn_Profile);
        ImageButton imgbtn_Chapter_Select = findViewById(R.id.imgbtn_Chapter_Select);

        // the "finish()" function will disable the back button to go back in previous activity.

        imgbtn_Profile.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), MM_Profile.class));
        });

        imgbtn_Settings.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), MM_Settings.class));
        });

        imgbtn_Shop.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), MM_Shop.class));
        });

        imgbtn_Achievements.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), MM_Achievements.class));
        });

        imgbtn_Cell_Quest.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), MM_CellQuest.class));
        });

        imgbtn_Leaderboard.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), MM_Leaderboard.class));
        });


    }
}