package com.example.ex22;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context) {

        super(context, "project.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table addresses(_id integer primary key autoincrement,name text,phone text,address text)");
        db.execSQL("insert into addresses values(null,'이름','전화번호','주소')");
        db.execSQL("insert into addresses values(null,'첫째','111-1111-1111','1시1동1길')");
        db.execSQL("insert into addresses values(null,'둘째','222-2222-2222','2시2동2길')");
        db.execSQL("insert into addresses values(null,'세째','333-3333-3333','3시3동3길')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
