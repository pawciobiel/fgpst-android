package com.pawciobiel.fgpst;

import android.database.sqlite.SQLiteOpenHelper;


public class FgpstDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "fgpst.db";
    private static final String TABLE_NAME = "positions";
    private static final String SQL_TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    "timestamp TEXT, " +
                    "position_json TEXT);";
    private static final String SQL_DELETE_ENTRIES =
            "DELETE FROM " + TABLE_NAME + ";";
    private static final String TABLE_DROP =
            "DROP TABLE " + TABLE_NAME + ";";

    FgpstPositionStorageOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_TABLE_CREATE);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}