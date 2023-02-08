package com.example.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {

    public database(@Nullable Context context)
    {

        super(context, "Register", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String q="create table student(id integer primary key,name text,Contact text,Password text,Email text)";
        db.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String q="alter table student add column Email text default ''";
        db.execSQL(q);
    }

    void insertdata(String name, String contact, String pass, String email)
    {
        String q = "insert into student values(null,'"+name+"','"+contact+"','"+pass+"','"+email+"')";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(q);
    }

    Cursor getdata()
    {
        String q = "select * from student";
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor c=database.rawQuery(q,null);
        return c;
    }

     public void deletedata(String uid)
    {
        String q="delete from student where id='"+uid+"'";
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL(q);
    }

    public void updatedata(String id,String name, String contact, String pass, String email) {

        String q="update student set name ='"+name+"',  Contact='"+contact+"',Password='"+pass+"',Email='"+email+"' where id ='"+id+"'";
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL(q);
    }
}
