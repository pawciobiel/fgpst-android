package com.pawciobiel.fgpst;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import org.json.JSONObject;

public class FgpstStorageService {
    private SQLiteDatabase dbHelper;

    public FgpstStorageService(){
        FgpstDbHelper dbHelper = new FgpstDbHelper(getContext());
    }

    public static addPosition(JSONObject position, timestamp){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FgpstPositionModel.TIMESTAMP, timestamp);
        values.put(FgpstPositionModel.POSITION_JSON, position
                .toString());

        long newRowId;
        newRowId = db.insert("positions", null, values);
    }
}
