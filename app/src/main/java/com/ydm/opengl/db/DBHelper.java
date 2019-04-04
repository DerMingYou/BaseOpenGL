package com.ydm.opengl.db;

import android.content.Context;

import com.ydm.opengl.db.entity.DaoMaster;
import com.ydm.opengl.db.entity.DaoSession;

/**
 * Description: 数据库的增删改查
 * Data：2019/4/2-15:10
 * Author: DerMing_You
 */
public class DBHelper {
    private static DBHelper instance;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;

    /**
     * 取得DaoMaster
     *
     * @param context
     * @return
     */
    private static DaoMaster getDaoMaster(Context context) {
        if (daoMaster == null) {
            //更新适配
            DaoMaster.DevOpenHelper helper = new DbUpdateHelper(context, "sample.db");
            daoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return daoMaster;
    }

    /**
     * 取得DaoSession
     *
     * @param context
     * @return
     */
    public static DaoSession getDaoSession(Context context) {
        if (daoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster(context);
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }

    private DBHelper() {
    }

    public static void init() {
        instance = new DBHelper();
    }

    public static DBHelper getInstance() {
        return instance;
    }

}
