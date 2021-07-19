package com.example.biowit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class PL_ChapSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); // hides the action bar.

        setContentView(R.layout.activity_pl_chap_select);

        Button btn_Cell = findViewById(R.id.btn_Cell);
        Button btn_Bio_Mole = findViewById(R.id.btn_Bio_Mole);
        Button btn_Energy = findViewById(R.id.btn_Energy);

        btn_Cell.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), CS_Cell.class)));

        //btn_Cell.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), CS_Cell.class)));

        //btn_Cell.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), CS_Cell.class)));
    }
}