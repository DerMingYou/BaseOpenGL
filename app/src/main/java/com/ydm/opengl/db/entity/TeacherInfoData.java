package com.ydm.opengl.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Description:
 * Data：2019/4/2-17:46
 * Author: DerMing_You
 */
@Entity
public class TeacherInfoData {

    @Id(autoincrement = true)  //id设置为自增长
    private Long teacherId;  //学院id

    @Index(unique = true)   //唯一性
    private String teacherNumber;  //教师编号

    private String teacherName;  //姓名

    private String teacherSex;  //性别

    @Generated(hash = 460560285)
    public TeacherInfoData(Long teacherId, String teacherNumber, String teacherName,
            String teacherSex) {
        this.teacherId = teacherId;
        this.teacherNumber = teacherNumber;
        this.teacherName = teacherName;
        this.teacherSex = teacherSex;
    }

    @Generated(hash = 634509327)
    public TeacherInfoData() {
    }

    public Long getTeacherId() {
        return this.teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherNumber() {
        return this.teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSex() {
        return this.teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }
}
