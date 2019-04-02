package com.ydm.opengl.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Description:
 * Data：2019/4/2-15:11
 * Author: DerMing_You
 */
@Entity
public class StudentInfoData {
    @Id(autoincrement = true)  //id设置为自增长
    private Long studentId;  //学院id

    @Index(unique = true)   //唯一性
    private String studentNumber;  //学号

    private String studentName;  //姓名

    private String studentSex;  //性别

    private String studentScore;  //成绩

    @Generated(hash = 112611198)
    public StudentInfoData(Long studentId, String studentNumber, String studentName,
            String studentSex, String studentScore) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.studentName = studentName;
        this.studentSex = studentSex;
        this.studentScore = studentScore;
    }

    @Generated(hash = 1698171545)
    public StudentInfoData() {
    }

    public Long getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return this.studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSex() {
        return this.studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public String getStudentScore() {
        return this.studentScore;
    }

    public void setStudentScore(String studentScore) {
        this.studentScore = studentScore;
    }
}
