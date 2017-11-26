package com.example.fpapp.SQLdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;

import com.example.fpapp.Model.User;

/**
 * Created by chenxiaojie on 2017-10-29.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "UserManage.db";
    //first table
    private static final String TABLE_USER = "user";
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";
    //second table
    private static final String Table_NAME_devicestatus = "devicestatus";
    private static final String COL_1_devicestatus = "id";
    private static final String COL_2_devicestatus = "devicename";
    private static final String COL_3_devicestatus = "status";
    //valuable for create two table
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";
    private String CreateTable2 = "CREATE TABLE " + Table_NAME_devicestatus + " (id INTEGER PRIMARY KEY AUTOINCREMENT, devicename TEXT, status INTEGER)";
    //valuable for drop table
    private String DropTable_user = "DROP TABLE IF EXISTS " + TABLE_USER;
    private String DropTable_devicestatus = "DROP TABLE IF EXISTS " + Table_NAME_devicestatus;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase(); // for checking
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CreateTable2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DropTable_user);
        db.execSQL(DropTable_devicestatus);
        onCreate(db);
    }

    //User table functions

    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public boolean checkUser(String email){
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_EMAIL + " = ?";
        String[] selectionArgs = { email };

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0){
            return true;
        }
        return false;
    }

    public boolean checkUser(String email, String password){
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " =?";
        String[] selectionArgs = { email, password };

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0){
            return true;
        }
        return false;
    }


    //device table functions
    public boolean insertData(String status){
        SQLiteDatabase db = this.getWritableDatabase(); //connect database
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_3_devicestatus, status);

        long result;
        result = db.insert(Table_NAME_devicestatus, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + Table_NAME_devicestatus, null); //output data from database
        // this Cursor provide random read-write access to the result set returned
        return res;
    }

    public boolean updateData(Editable statu, Editable id){
        SQLiteDatabase db = this.getWritableDatabase(); //connect database
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1_devicestatus, id.toString());
        contentValues.put(COL_3_devicestatus, String.valueOf(statu));

        db.update(Table_NAME_devicestatus, contentValues, "id = ?", new String[] {String.valueOf(id)});

        return true;

    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase(); //connect database
        return db.delete(Table_NAME_devicestatus, "id = ?", new String[] {id});
    }

}
