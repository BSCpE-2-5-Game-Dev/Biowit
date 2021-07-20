package com.example.biowit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MM_CellQuest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); // hides the action bar.
        
        setContentView(R.layout.activity_mm_cell_quest);

        ImageButton imgbtn_Shop = findViewById(R.id.imgbtn_Shop);
        ImageButton imgbtn_Achievements = findViewById(R.id.imgbtn_Achievements);
        ImageButton imgbtn_Play = findViewById(R.id.imgbtn_Play);
        ImageButton imgbtn_Leaderboard = findViewById(R.id.imgbtn_Leaderboard);

        // the "finish()" function will disable the back button to go back in previous activity.

        imgbtn_Shop.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), MM_Shop.class));
            finish();
        });

        imgbtn_Achievements.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), MM_Achievements.class));
            finish();
        });

        imgbtn_Play.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), MM_Play.class));
            finish();
        });

        imgbtn_Leaderboard.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), MM_Leaderboard.class));
            finish();
        });
    }
}