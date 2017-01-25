package com.example.bijan.projectminiuniversity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Bijan on 1/4/2017.
 */

public class DetailsDatabase {

    MyHelper myHelper;
    SQLiteDatabase sqLiteDatabase;

    public  DetailsDatabase(Context context){
        myHelper = new MyHelper(context, "wbut.db", null, 1);
    }

    public void open(){
        sqLiteDatabase = myHelper.getWritableDatabase();
    }

    public void insertDetails(String no, String name, String mobile,
                              String emailid, String subject,
                              String description, String date){
        ContentValues contentValues = new ContentValues();
        contentValues.put("no", no);
        contentValues.put("name", name);
        contentValues.put("mobile", mobile);
        contentValues.put("emailid", emailid);
        contentValues.put("subject", subject);
        contentValues.put("description", description);
        contentValues.put("date", date);

        sqLiteDatabase.insert("details", null, contentValues);
    }

    public Cursor quaryDetails(){
        Cursor cursor = null;

        cursor = sqLiteDatabase.query("details", null, null, null, null, null, null);
        return cursor;
    }

    public Cursor quaryDetailss(String name){
        Cursor cursor = null;

        cursor = sqLiteDatabase.query("details", null, "name =?", new String[]{name}, null, null, null);
        return cursor;
    }

    public Cursor quaryDetailsss(String mobile){
        Cursor cursor = null;

        cursor = sqLiteDatabase.query("details", null, "mobile =?", new String[]{mobile}, null, null, null);
        return cursor;
    }

    public void close(){
        sqLiteDatabase.close();
    }

    public class MyHelper extends SQLiteOpenHelper{

        public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("create table details(_id integer primary key, no text, name text, mobile text, emailid text, subject text, description text, date text);");

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
