package com.ydm.opengl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Description:
 * Data：2019/3/29-10:12
 * Author: DerMing_You
 */
public class ShowShapeActivity extends AppCompatActivity {

    public static void launch(Context context){
        Intent intent = new Intent(context, ShowShapeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_shape);

        TextView tvStretch = findViewById(R.id.tvStretch);
        TextView tvNormal = findViewById(R.id.tvNormal);
        TextView tvColor = findViewById(R.id.tvColor);

        tvStretch.setOnClickListener(v -> {
            OpenGLActivity.launch(this, OpenGLActivity.FROM_TYPE_ONE);
        });

        tvNormal.setOnClickListener(v -> {
            OpenGLActivity.launch(this, OpenGLActivity.FROM_TYPE_TWO);
        });

        tvColor.setOnClickListener(v -> {
            OpenGLActivity.launch(this, OpenGLActivity.FROM_TYPE_THREE);
        });
    }
}
