package com.ydm.opengl.db;

import android.content.Context;
import android.util.Log;

import com.ydm.opengl.db.entity.DaoMaster;
import com.ydm.opengl.db.entity.MigrationHelper;
import com.ydm.opengl.db.entity.StudentInfoData;
import com.ydm.opengl.db.entity.StudentInfoDataDao;
import com.ydm.opengl.db.entity.TeacherInfoDataDao;

import org.greenrobot.greendao.database.Database;

/**
 * Description: 数据库升级
 * Data：2019/4/2-17:56
 * Author: DerMing_You
 */
public class DbUpdateHelper extends DaoMaster.DevOpenHelper {
    public DbUpdateHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        Log.e("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
        // 升级、数据库迁移操作
        MigrationHelper.getInstance().migrate(db, StudentInfoDataDao.class, TeacherInfoDataDao.class);
    }
}
