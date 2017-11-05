package com.example.fpapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;

/**
 * Created by chenxiaojie on 2017-10-29.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "CarInfo.db";
    public static final String Table_NAME = "car_table";
    public static final String COL_1 = "id";
    public static final String COL_2 = "status";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase db = this.getWritableDatabase(); // for checking
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Table_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT, status TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_NAME);
        onCreate(db);
    }

    public boolean insertData(String status){
        SQLiteDatabase db = this.getWritableDatabase(); //connect database
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, status);

        long result;
        result = db.insert(Table_NAME, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + Table_NAME, null); //output data from database
        // this Cursor provide random read-write access to the result set returned
        return res;
    }

    public boolean updateData(Editable statu, Editable id){
        SQLiteDatabase db = this.getWritableDatabase(); //connect database
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id.toString());
        contentValues.put(COL_2, String.valueOf(statu));

        db.update(Table_NAME, contentValues, "id = ?", new String[] {String.valueOf(id)});

        return true;

    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase(); //connect database
        return db.delete(Table_NAME, "id = ?", new String[] {id});
    }

}
