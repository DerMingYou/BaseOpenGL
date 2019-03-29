package com.ydm.opengl;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ydm.opengl.shape.Square;
import com.ydm.opengl.shape.Triangle;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Description:
 * Data：2019/3/29-10:10
 * Author: DerMing_You
 */
public class OpenGLActivity extends AppCompatActivity {

    private final static String FROM_TYPE = "from_type";
    public final static int FROM_TYPE_ONE = 1;
    public final static int FROM_TYPE_TWO = 2;
    public final static int FROM_TYPE_THREE = 3;

    private GLSurfaceView glSurfaceView;
    private OriginalGLRenderer originalGLRenderer;
    private ColorGLRenderer colorGLRenderer;
    private OneGlRenderer oneGlRenderer;

    private Triangle mTriangle;
    private Square mSquare;

    private boolean rendererSet = false;  //渲染器

    private int type = FROM_TYPE_ONE;

    public static void launch(Context context, int type){
        Intent intent = new Intent(context, OpenGLActivity.class);
        intent.putExtra(FROM_TYPE, type);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glSurfaceView = new GLSurfaceView(this);

        setContentView(glSurfaceView);

        type = getIntent().getIntExtra(FROM_TYPE, 0);

        oneGlRenderer = new OneGlRenderer();
        originalGLRenderer = new OriginalGLRenderer();
        colorGLRenderer = new ColorGLRenderer();

        ActivityManager activityManager =
                (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        ConfigurationInfo configurationInfo = activityManager
                .getDeviceConfigurationInfo();

        //检查系统是否支持OpenGL ES 2.0
        final boolean supportsEs2 =
                configurationInfo.reqGlEsVersion >= 0x20000
                        || (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1
                        && (Build.FINGERPRINT.startsWith("generic")
                        || Build.FINGERPRINT.startsWith("unknown")
                        || Build.MODEL.contains("google_sdk")
                        || Build.MODEL.contains("Emulator")
                        || Build.MODEL.contains("Android SDK built for x86")));

        if (supportsEs2) {
            glSurfaceView.setEGLContextClientVersion(2);
            switch (type){
                case FROM_TYPE_ONE:
                    glSurfaceView.setRenderer(oneGlRenderer);
                    break;
                case FROM_TYPE_TWO:
                    glSurfaceView.setRenderer(originalGLRenderer);
                    break;
                case FROM_TYPE_THREE:
                    glSurfaceView.setRenderer(colorGLRenderer);
                    break;
            }

            rendererSet = true;
        } else {
            Toast.makeText(this, "This device does not support OpenGL ES 2.0.",
                    Toast.LENGTH_LONG).show();
            return;
        }
    }

}
