package com.ydm.opengl.db.entity;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.ydm.opengl.db.entity.StudentInfoData;
import com.ydm.opengl.db.entity.TeacherInfoData;

import com.ydm.opengl.db.entity.StudentInfoDataDao;
import com.ydm.opengl.db.entity.TeacherInfoDataDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig studentInfoDataDaoConfig;
    private final DaoConfig teacherInfoDataDaoConfig;

    private final StudentInfoDataDao studentInfoDataDao;
    private final TeacherInfoDataDao teacherInfoDataDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        studentInfoDataDaoConfig = daoConfigMap.get(StudentInfoDataDao.class).clone();
        studentInfoDataDaoConfig.initIdentityScope(type);

        teacherInfoDataDaoConfig = daoConfigMap.get(TeacherInfoDataDao.class).clone();
        teacherInfoDataDaoConfig.initIdentityScope(type);

        studentInfoDataDao = new StudentInfoDataDao(studentInfoDataDaoConfig, this);
        teacherInfoDataDao = new TeacherInfoDataDao(teacherInfoDataDaoConfig, this);

        registerDao(StudentInfoData.class, studentInfoDataDao);
        registerDao(TeacherInfoData.class, teacherInfoDataDao);
    }
    
    public void clear() {
        studentInfoDataDaoConfig.clearIdentityScope();
        teacherInfoDataDaoConfig.clearIdentityScope();
    }

    public StudentInfoDataDao getStudentInfoDataDao() {
        return studentInfoDataDao;
    }

    public TeacherInfoDataDao getTeacherInfoDataDao() {
        return teacherInfoDataDao;
    }

}
