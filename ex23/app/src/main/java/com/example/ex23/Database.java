package com.example.ex23;

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
        db.execSQL("create table product(_id integer primary key, name text, price integer, img text)");
        db.execSQL("insert into product(name, price, img) values('lg',10000,'')");
        db.execSQL("insert into product(name, price, img) values('samsung',1000,'')");
        db.execSQL("insert into product(name, price, img) values('babo',100,'')");
        db.execSQL("insert into product(name, price, img) values('doit!',2500,'')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
