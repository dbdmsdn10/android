package com.example.ex20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Database db;
    SQLiteDatabase sql;
    Cursor cursor;
    myAdapter ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("상품관리");
        ListView list = findViewById(R.id.list);
        db = new Database(this);
        sql = db.getReadableDatabase();
        cursor = sql.rawQuery("select * from product", null);
//        //데이터 불러왔으니 어댑터 만들기
//        SimpleCursorAdapter ad=new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,cursor,new String[]{"name","price"},new int[]{android.R.id.text1,android.R.id.text2});
//        //(출력위치,학목 2개라서 item2, 출력하고 싶은것은 2개라서 name price, 데이터베이스에저 값 가져오기, 1과2의 위치 바꾸면 가격과 이름 바뀜)
//        //값이 1개면 item1이면 됨, 단 배열로 해줘야하는건 마찬가지
//        list.setAdapter(ad);

        ad = new myAdapter(this, cursor);
        list.setAdapter(ad);
    }

    class myAdapter extends CursorAdapter {

        public myAdapter(Context context, Cursor c) {
            super(context, c);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.item_main, parent, false);
            return view;
        }

        @Override
        public void bindView(View view, Context context, final Cursor c) {
            TextView name = view.findViewById(R.id.name);
            name.setText(c.getString(1));
            TextView price = view.findViewById(R.id.price);
            price.setText(c.getString(2)+"원");
            final int id=c.getInt(0);//번호 가져오기
            Button delbtn=view.findViewById(R.id.delbtn);
            delbtn.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder box=new AlertDialog.Builder(MainActivity.this);
                    box.setTitle("확인: "+id);
                    box.setMessage("정말 삭제하시겠습니까? 복구되지 않습니다");
                    box.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String str="delete from product where _id="+id;//삭제
                            sql.execSQL(str);
                            cursor=sql.rawQuery("select * from product",null);
                            ad.changeCursor(cursor);
                        }
                    });
                    box.setNegativeButton("아니요",null);
                    box.show();
                }
            });
        }
    }

    //여기 아래로 매뉴
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        final LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.addxml, null);
        switch (item.getItemId()) {
            case R.id.insert:
                AlertDialog.Builder box = new AlertDialog.Builder(this);
                box.setTitle("상품정보입력");
                box.setView(layout);
                box.setNegativeButton("취소", null);
                box.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText name=layout.findViewById(R.id.name);
                        String strname=name.getText().toString();
                        EditText price=layout.findViewById(R.id.price);
                        int intprice=Integer.parseInt(price.getText().toString());
//                        System.out.println("상품명: "+strname);
//                        System.out.println("가격: "+intprice);
                        String str="insert into product(name,price) values('"+strname+"',"+intprice+")";
                        sql.execSQL(str);
                        cursor=sql.rawQuery("select * from product",null);
                        ad.changeCursor(cursor);
                    }
                });
                box.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
