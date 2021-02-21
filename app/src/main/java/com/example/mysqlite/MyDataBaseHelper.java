package com.example.mysqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Cutomer.db";
    public static final String TABLE_NAME="customer_table";
    public static final String ID="ID";
    public static final String NAME="Name";
    public static final String AGE="Age";
    public static final String GENDER="Gender";


    public MyDataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+" ("+ID+" integer primary key autoincrement ,"+NAME+" varchar(20),"+AGE+" integer,"+GENDER+" varchar(20));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }
    public boolean InsertData(String Name,String Age, String Gender)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME,Name);
        contentValues.put(AGE,Age);
        contentValues.put(GENDER,Gender);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
    public boolean UpdateData(String ID,String Name,String Age, String Gender)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(ID,ID);
        contentValues.put(NAME,Name);
        contentValues.put(AGE,Age);
        contentValues.put(GENDER,Gender);
        db.update(TABLE_NAME,contentValues,"ID=?",new String [] {ID});
        return true;
    }
    public int DeleteData(String id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.delete(TABLE_NAME,"ID=?",new String[]{ID});
    }
}
