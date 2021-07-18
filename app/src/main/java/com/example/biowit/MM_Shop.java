package com.example.biowit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MM_Shop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); // hides the action bar.
        
        setContentView(R.layout.activity_mm_shop);
        
        ImageButton imgbtn_Achievements = findViewById(R.id.imgbtn_Achievements);
        ImageButton imgbtn_Play = findViewById(R.id.imgbtn_Play);
        ImageButton imgbtn_Cell_Quest = findViewById(R.id.imgbtn_Cell_Quest);
        ImageButton imgbtn_Leaderboard = findViewById(R.id.imgbtn_Leaderboard);
        ImageButton imgbtn_Settings =  findViewById(R.id.imgbtn_Settings);

        imgbtn_Achievements.setOnClickListener(v -> {
            Intent Achievements_open = new Intent(MM_Shop.this, MM_Achievements.class);
            startActivity(Achievements_open);
        });

        imgbtn_Play.setOnClickListener(v -> {
            Intent Play_open = new Intent(MM_Shop.this, MM_Play.class);
            startActivity(Play_open);
        });

        imgbtn_Cell_Quest.setOnClickListener(v -> {
            Intent Cell_Quest_open = new Intent(MM_Shop.this, MM_CellQuest.class);
            startActivity(Cell_Quest_open);
        });

        imgbtn_Leaderboard.setOnClickListener(v -> {
            Intent Leaderboard_open = new Intent(MM_Shop.this, MM_Leaderboard.class);
            startActivity(Leaderboard_open);
        });
    }
}