package com.ydm.opengl.db.entity;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.ydm.opengl.db.entity.StudentInfoData;

import com.ydm.opengl.db.entity.StudentInfoDataDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig studentInfoDataDaoConfig;

    private final StudentInfoDataDao studentInfoDataDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        studentInfoDataDaoConfig = daoConfigMap.get(StudentInfoDataDao.class).clone();
        studentInfoDataDaoConfig.initIdentityScope(type);

        studentInfoDataDao = new StudentInfoDataDao(studentInfoDataDaoConfig, this);

        registerDao(StudentInfoData.class, studentInfoDataDao);
    }
    
    public void clear() {
        studentInfoDataDaoConfig.clearIdentityScope();
    }

    public StudentInfoDataDao getStudentInfoDataDao() {
        return studentInfoDataDao;
    }

}
