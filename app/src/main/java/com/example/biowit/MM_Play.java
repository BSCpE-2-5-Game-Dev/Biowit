package com.example.biowit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

        imgbtn_Shop.setOnClickListener(v -> {
            Intent Shop_open = new Intent(MM_Play.this, MM_Shop.class);
            startActivity(Shop_open);
        });

        imgbtn_Achievements.setOnClickListener(v -> {
            Intent Achievements_open = new Intent(MM_Play.this, MM_Achievements.class);
            startActivity(Achievements_open);
        });

        imgbtn_Cell_Quest.setOnClickListener(v -> {
            Intent Cell_Quest_open = new Intent(MM_Play.this, MM_CellQuest.class);
            startActivity(Cell_Quest_open);
        });

        imgbtn_Leaderboard.setOnClickListener(v -> {
            Intent Leaderboard_open = new Intent(MM_Play.this, MM_Leaderboard.class);
            startActivity(Leaderboard_open);
        });
    }
}