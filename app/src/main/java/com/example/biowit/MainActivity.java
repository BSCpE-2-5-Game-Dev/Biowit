package com.example.biowit;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.Window;
        import android.view.WindowManager;
        import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); // hides the action bar.

        setContentView(R.layout.activity_main);

        Button btn_SignIn = findViewById(R.id.btn_Log_In);

        btn_SignIn.setOnClickListener(v -> {
            Intent log_in_success = new Intent(MainActivity.this, MM_Play.class);
            startActivity(log_in_success);
        });
    }
}