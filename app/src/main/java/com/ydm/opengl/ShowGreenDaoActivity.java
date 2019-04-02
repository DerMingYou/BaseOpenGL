package com.ydm.opengl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.ydm.opengl.db.entity.DaoMaster;
import com.ydm.opengl.db.entity.DaoSession;
import com.ydm.opengl.db.entity.StudentInfoData;
import com.ydm.opengl.db.entity.StudentInfoDataDao;

import org.json.JSONArray;

import java.util.List;

/**
 * Description:
 * Data：2019/4/2-16:34
 * Author: DerMing_You
 */
public class ShowGreenDaoActivity extends AppCompatActivity {

    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private StudentInfoDataDao studentInfoDataDao;

    private EditText etStuNum;
    private EditText etName;
    private EditText etSex;
    private EditText etScore;
    private EditText etSearchStuNum;

    public static void launch(Context context){
        Intent intent = new Intent(context, ShowGreenDaoActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_green_dao);

        etStuNum = findViewById(R.id.etStuNum);
        etName = findViewById(R.id.etName);
        etSex = findViewById(R.id.etSex);
        etScore = findViewById(R.id.etScore);
        etSearchStuNum = findViewById(R.id.etSearchStuNum);

        TextView tvEditInfo = findViewById(R.id.tvEditInfo);
        TextView tvSearch = findViewById(R.id.tvSearch);
        tvEditInfo.setOnClickListener(v -> {
            finish();
        });

        tvSearch.setOnClickListener(v -> {
            doSearch();
        });

        getStudentDao();
    }
    private void getStudentDao(){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this,"student.db");
        daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();
        studentInfoDataDao = daoSession.getStudentInfoDataDao();

    }

    private void doSearch(){
        List<StudentInfoData> dataArrayList = studentInfoDataDao.queryBuilder()
                .where(StudentInfoDataDao.Properties.StudentNumber.notEq(etSearchStuNum.getText().toString()))  //where 条件判断
                .orderAsc(StudentInfoDataDao.Properties.StudentNumber)  //orderAsc 排序
                .limit(5)  //limit 查询条数
                .build().list();  //查询结果为一个集合

        String dataString = dataArrayList.toString();
        Log.d("dataString = ", dataString);
        for (StudentInfoData infoData : dataArrayList){
            etStuNum.setText(infoData.getStudentNumber());
            etName.setText(infoData.getStudentName());
            etSex.setText(infoData.getStudentSex());
            etScore.setText(infoData.getStudentScore());
        }
    }

}
