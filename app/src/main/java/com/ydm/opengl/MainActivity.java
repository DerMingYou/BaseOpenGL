package com.ydm.opengl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvOnePart = findViewById(R.id.tvOnePart);
        TextView tvTwoPart = findViewById(R.id.tvTwoPart);
        TextView tvThreePart = findViewById(R.id.tvThreePart);
        TextView tvFourPart = findViewById(R.id.tvFourPart);
        TextView tvFivePart = findViewById(R.id.tvFivePart);
        TextView tvSixPart = findViewById(R.id.tvSixPart);

        tvOnePart.setOnClickListener(v -> {
            ShowShapeActivity.launch(this);
        });

        tvTwoPart.setOnClickListener(v -> {
            HandleGreenDaoActivity.launch(this);
        });
        tvThreePart.setOnClickListener(v -> {

        });
        tvFourPart.setOnClickListener(v -> {

        });
        tvFivePart.setOnClickListener(v -> {

        });
        tvSixPart.setOnClickListener(v -> {

        });
    }
}
