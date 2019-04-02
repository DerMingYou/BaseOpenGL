package com.ydm.opengl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ydm.opengl.db.entity.DaoMaster;
import com.ydm.opengl.db.entity.DaoSession;
import com.ydm.opengl.db.entity.StudentInfoData;
import com.ydm.opengl.db.entity.StudentInfoDataDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Data：2019/4/2-15:46
 * Author: DerMing_You
 */
public class HandleGreenDaoActivity  extends AppCompatActivity {

    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private StudentInfoDataDao studentInfoDataDao;

    private EditText etStuNum;
    private EditText etName;
    private EditText etSex;
    private EditText etScore;

    public static void launch(Context context){
        Intent intent = new Intent(context, HandleGreenDaoActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_handle_green_dao);

        etStuNum = findViewById(R.id.etStuNum);
        etName = findViewById(R.id.etName);
        etSex = findViewById(R.id.etSex);
        etScore = findViewById(R.id.etScore);

        TextView tvInputInfo = findViewById(R.id.tvInputInfo);
        TextView tvCheckInfo = findViewById(R.id.tvCheckInfo);

        getStudentDao();

        tvInputInfo.setOnClickListener(v -> {
            try {
                StudentInfoData studentInfoData = new StudentInfoData(null, etStuNum.getText().toString(),
                        etName.getText().toString(), etSex.getText().toString(), etScore.getText().toString());
                long end = studentInfoDataDao.insert(studentInfoData);
                if (end > 0){
                    Toast.makeText(this, "录入成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "录入失败", Toast.LENGTH_SHORT).show();
                }

            } catch (Exception e){
                e.printStackTrace();
                Toast.makeText(this, "学号是唯一的", Toast.LENGTH_SHORT).show();
            }
        });

        tvCheckInfo.setOnClickListener(v -> {
            ShowGreenDaoActivity.launch(this);
        });
    }

    private void getStudentDao(){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this,"student.db");
        daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();
        studentInfoDataDao = daoSession.getStudentInfoDataDao();
    }
}
