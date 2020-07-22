package com.example.ex19;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context) {
        super(context, "project.db", null, 1);//project는 이름
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table product(_id integer primary key autoincrement ,name text, price integer);");
        //execSQL은 데이터베이스 언어 쓰겠다는 의미, 주요키 오른쪽이 어떤 내용이 들어갈지 말해주고 있음
        db.execSQL("insert into product(name, price) values('땅콩',900)");
        db.execSQL("insert into product(name, price) values('감자 칩',2000)");
        db.execSQL("insert into product(name, price) values('장난감',10000)");
        db.execSQL("insert into product(name, price) values('api책',32000)");
        db.execSQL("insert into product(name, price) values('아파트',100000000)");
        db.execSQL("insert into product(name, price) values('전구',1500)");

        db.execSQL("create table adress(_id integer primary key autoincrement ,wheread text);");
        db.execSQL("insert into adress(wheread) values('천안시')");
        db.execSQL("insert into adress(wheread) values('아산시')");
        db.execSQL("insert into adress(wheread) values('서산')");
        db.execSQL("insert into adress(wheread) values('서울')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
