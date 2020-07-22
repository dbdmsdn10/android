package com.example.ex20;

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
        db.execSQL("create table product(_id integer primary key autoincrement,name text,price integer)");
        db.execSQL("insert into product(name,price) values('상품이름',0)");
        db.execSQL("insert into product(name,price) values('땅콩',900)");
        db.execSQL("insert into product(name,price) values('감자칩',1500)");
        db.execSQL("insert into product(name,price) values('장난감',9000)");
        db.execSQL("insert into product values(null,'시험',1000);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
