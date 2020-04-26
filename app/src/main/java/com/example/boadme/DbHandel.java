package com.example.boadme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHandel extends SQLiteOpenHelper {
    public DbHandel(@Nullable Context context) {
        super(context, "login_db", null, 11);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("Create table user(name text primary key,email text,password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists user");

    }

    public boolean add_user(String name, String email, String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("password",password);

        long ins = sqLiteDatabase.insert("user",null,contentValues);
        if (ins == -1)
            return false;
        else
            return true;
    }

    public Boolean chkemail(String email){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from user where email=?",new String[]{email});

        if (cursor.getCount() > 0)
            return false;
        else
            return true;
    }

    //checking the email and password

    public Boolean emaillpassword(String email,String password){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from user where email=? and password=?",new String[]{email,password});

        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
}
