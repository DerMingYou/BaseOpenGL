package com.ydm.opengl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvEnterOpenGL = findViewById(R.id.tvEnterOpenGL);

        tvEnterOpenGL.setOnClickListener(v -> {
            ShowShapeActivity.launch(this);
        });
    }
}
