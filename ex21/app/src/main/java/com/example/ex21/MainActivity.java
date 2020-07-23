package com.example.ex21;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.sql.SQLInput;

public class MainActivity extends AppCompatActivity {
Database db;
SQLiteDatabase sql;
Cursor cursor;
    Myadapter ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list=findViewById(R.id.list);
        db=new Database(this);
        sql=db.getReadableDatabase();
        cursor=sql.rawQuery("select * from address",null);
//        SimpleCursorAdapter ad=new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2,cursor,new String[]{"name","address"},new int[]{android.R.id.text1,android.R.id.text2});
        ad=new Myadapter(this,cursor);
        list.setAdapter(ad);

        findViewById(R.id.insertbtn).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LinearLayout layout=(LinearLayout)getLayoutInflater().inflate(R.layout.layout,null);
                AlertDialog.Builder box=new AlertDialog.Builder(MainActivity.this);
                box.setTitle("정보입력");
                box.setView(layout);
                box.setPositiveButton("저장", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        EditText name=layout.findViewById(R.id.name);
                        EditText address=layout.findViewById(R.id.address);
                        String strname=name.getText().toString();
                        String straddress=address.getText().toString();
                        String str="insert into address(name,address) values('"+strname+"','"+straddress+"')";
                        sql.execSQL(str);
                        cursor=sql.rawQuery("select * from address",null);
                        ad.changeCursor(cursor);
                    }
                });
                box.setNegativeButton("취소",null);
                box.show();
            }
        });
    }
    class Myadapter extends CursorAdapter {
        public Myadapter(Context context, Cursor c) {
            super(context, c);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            View view=getLayoutInflater().inflate(R.layout.item,parent,false);
            return view;
        }

        @Override
        public void bindView(View view, Context context, Cursor c) {
            TextView name=view.findViewById(R.id.name);
            TextView address=view.findViewById(R.id.address);
            name.setText(c.getString(1));
            address.setText(c.getString(2));
            final int id=c.getInt(0);
            Button btn=view.findViewById(R.id.delbtn);//삭제 버튼
            btn.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder box=new AlertDialog.Builder(MainActivity.this);
                    box.setTitle("확인: "+id);
                    box.setMessage("정말 삭제하시겠습니까? 복구는 불가능합니다");
                    box.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            sql.execSQL("delete from address where _id="+id);
                            cursor=sql.rawQuery("select * from address",null);
                            ad.changeCursor(cursor);
                        }
                    });
                    box.setNegativeButton("아니요",null);
                    box.show();
                }
            });
        }
    }


}
