package com.example.biowit.ChapterPlay;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.biowit.ChapterPlay.Chapter1.Ch1LessonSelect;
import com.example.biowit.R;

public class ChapterSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapterselect);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); // hides the action bar.

        Button btn_Ch1LessonSelect = findViewById(R.id.btn_Cell);
        btn_Ch1LessonSelect.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), Ch1LessonSelect.class));
            finish();
        });
    }
}
