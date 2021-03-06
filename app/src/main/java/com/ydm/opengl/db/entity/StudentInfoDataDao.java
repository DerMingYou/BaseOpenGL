package com.ydm.opengl.db.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "STUDENT_INFO_DATA".
*/
public class StudentInfoDataDao extends AbstractDao<StudentInfoData, Long> {

    public static final String TABLENAME = "STUDENT_INFO_DATA";

    /**
     * Properties of entity StudentInfoData.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property StudentId = new Property(0, Long.class, "studentId", true, "_id");
        public final static Property StudentNumber = new Property(1, String.class, "studentNumber", false, "STUDENT_NUMBER");
        public final static Property StudentName = new Property(2, String.class, "studentName", false, "STUDENT_NAME");
        public final static Property StudentSex = new Property(3, String.class, "studentSex", false, "STUDENT_SEX");
        public final static Property StudentScore = new Property(4, String.class, "studentScore", false, "STUDENT_SCORE");
    }


    public StudentInfoDataDao(DaoConfig config) {
        super(config);
    }
    
    public StudentInfoDataDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"STUDENT_INFO_DATA\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: studentId
                "\"STUDENT_NUMBER\" TEXT," + // 1: studentNumber
                "\"STUDENT_NAME\" TEXT," + // 2: studentName
                "\"STUDENT_SEX\" TEXT," + // 3: studentSex
                "\"STUDENT_SCORE\" TEXT);"); // 4: studentScore
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_STUDENT_INFO_DATA_STUDENT_NUMBER ON \"STUDENT_INFO_DATA\"" +
                " (\"STUDENT_NUMBER\" ASC);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"STUDENT_INFO_DATA\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, StudentInfoData entity) {
        stmt.clearBindings();
 
        Long studentId = entity.getStudentId();
        if (studentId != null) {
            stmt.bindLong(1, studentId);
        }
 
        String studentNumber = entity.getStudentNumber();
        if (studentNumber != null) {
            stmt.bindString(2, studentNumber);
        }
 
        String studentName = entity.getStudentName();
        if (studentName != null) {
            stmt.bindString(3, studentName);
        }
 
        String studentSex = entity.getStudentSex();
        if (studentSex != null) {
            stmt.bindString(4, studentSex);
        }
 
        String studentScore = entity.getStudentScore();
        if (studentScore != null) {
            stmt.bindString(5, studentScore);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, StudentInfoData entity) {
        stmt.clearBindings();
 
        Long studentId = entity.getStudentId();
        if (studentId != null) {
            stmt.bindLong(1, studentId);
        }
 
        String studentNumber = entity.getStudentNumber();
        if (studentNumber != null) {
            stmt.bindString(2, studentNumber);
        }
 
        String studentName = entity.getStudentName();
        if (studentName != null) {
            stmt.bindString(3, studentName);
        }
 
        String studentSex = entity.getStudentSex();
        if (studentSex != null) {
            stmt.bindString(4, studentSex);
        }
 
        String studentScore = entity.getStudentScore();
        if (studentScore != null) {
            stmt.bindString(5, studentScore);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public StudentInfoData readEntity(Cursor cursor, int offset) {
        StudentInfoData entity = new StudentInfoData( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // studentId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // studentNumber
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // studentName
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // studentSex
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // studentScore
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, StudentInfoData entity, int offset) {
        entity.setStudentId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setStudentNumber(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setStudentName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setStudentSex(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setStudentScore(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(StudentInfoData entity, long rowId) {
        entity.setStudentId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(StudentInfoData entity) {
        if(entity != null) {
            return entity.getStudentId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(StudentInfoData entity) {
        return entity.getStudentId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
