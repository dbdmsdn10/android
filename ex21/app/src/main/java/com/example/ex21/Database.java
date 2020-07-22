package com.example.ex21;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context) {
        super(context, "project.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table address(_id integer primary key autoincrement, name text, address text)");
        db.execSQL("insert into address(name, address) values('홍길동','인천')");
        db.execSQL("insert into address(name, address) values('주확진','천안')");
        db.execSQL("insert into address(name, address) values('삼영국','서울')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
