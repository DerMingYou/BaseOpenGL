package com.ydm.opengl;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.SystemClock;

import com.ydm.opengl.shape.ColorTriangle;
import com.ydm.opengl.shape.NormalTriangle;
import com.ydm.opengl.shape.OriginalTriangle;
import com.ydm.opengl.shape.Triangle;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Description:
 * Data：2019/3/29-14:51
 * Author: DerMing_You
 */
public class ColorGLRenderer implements GLSurfaceView.Renderer {

    private NormalTriangle mTriangle;
    private ColorTriangle mTriangleColor;

    public void onSurfaceCreated(GL10 unused, EGLConfig config) {
        // Set the background frame color
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        // initialize a triangle
        mTriangle = new NormalTriangle();
        mTriangleColor = new ColorTriangle();
    }
    private float[] mRotationMatrix = new float[16];
    public volatile float mAngle;

    public float getAngle() {
        return mAngle;
    }

    public void setAngle(float angle) {
        mAngle = angle;
    }
    public void onDrawFrame(GL10 unused) {
        // 设置相机位置（查看矩阵）
        Matrix.setLookAtM(mViewMatrix, 0, 0, 0, -3, 0f, 0f, 0f, 0f, 1.0f, 0.0f);

        // 计算投影和视图变换
        Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);

        float[] scratch = new float[16];

//        long time = SystemClock.uptimeMillis() % 4000L;
//        //控制旋转速度
//        float angle = 0.09f * ((int) time);
//        Matrix.setRotateM(mRotationMatrix, 0, angle, 0, 0, -1.0f);
        Matrix.setRotateM(mRotationMatrix, 0, mAngle, 0, 0, -1.0f);
        Matrix.multiplyMM(scratch, 0, mMVPMatrix, 0, mRotationMatrix, 0);

        mTriangle.draw(scratch);
    }

    // mMVPMatrix is an abbreviation for "Model View Projection Matrix"
    private final float[] mMVPMatrix = new float[16];
    private final float[] mProjectionMatrix = new float[16];
    private final float[] mViewMatrix = new float[16];
    public void onSurfaceChanged(GL10 unused, int width, int height) {
        GLES20.glViewport(0, 0, width, height);

        float ratio = (float) width / height;

        // 这个投影矩阵被应用于对象坐标在onDrawFrame（）方法中
        Matrix.frustumM(mProjectionMatrix, 0, -ratio, ratio, -1, 1, 3, 7);
    }

    public static int loadShader(int type, String shaderCode){

        // create a vertex shader type (GLES20.GL_VERTEX_SHADER)
        // or a fragment shader type (GLES20.GL_FRAGMENT_SHADER)
        int shader = GLES20.glCreateShader(type);


        // add the source code to the shader and compile it
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);

        return shader;
    }

}
