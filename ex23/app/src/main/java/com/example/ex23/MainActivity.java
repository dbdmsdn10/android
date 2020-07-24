package com.example.ex23;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    Database db;
    SQLiteDatabase sql;
    Cursor cursor;
    Myadapter ad;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("상품관리");
        permissionCheck();
        db = new Database(this);
        sql = db.getReadableDatabase();
        cursor = sql.rawQuery("select * from product", null);
        ad = new Myadapter(this, cursor);
        list = findViewById(R.id.list);
        list.setAdapter(ad);
        registerForContextMenu(list);

        FloatingActionButton add = findViewById(R.id.fabbtn);
        add.setOnClickListener(new View.OnClickListener() {//매뉴 클릭시
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Addactivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    public class Myadapter extends CursorAdapter {//어댑터

        public Myadapter(Context context, Cursor c) {
            super(context, c);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
            View view = getLayoutInflater().inflate(R.layout.item, viewGroup, false);
            return view;
        }

        @Override
        public void bindView(View view, Context context, Cursor c) {
            TextView text = view.findViewById(R.id.nametxt);
            TextView price = view.findViewById(R.id.pricetxt);
            ImageView img = view.findViewById(R.id.productimg);
            final int id=c.getInt(0);
            String strname = c.getString(1);
            String strprice = c.getString(2);
            String strimg = c.getString(3);
            text.setText(strname);
            price.setText(strprice);
            int count=0;
            if (strimg.equals("")||strimg=="null") {//이미치 없으면 초기화값
                img.setImageResource(R.drawable.ic_add_circle_outline_black_24dp);
            }
            else{
                Bitmap img2 = BitmapFactory.decodeFile(strimg);//있으면 bitmap사용하여 저장
                img.setImageBitmap(img2);
            }

            view.findViewById(R.id.delbtn).setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder box=new AlertDialog.Builder(MainActivity.this);
                    box.setTitle("확인");
                    box.setMessage("정말 삭제하시겠습니까?");
                    box.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            sql.execSQL("delete from product where _id="+id);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//엑티비티바
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        MenuItem search = menu.findItem(R.id.searchbtn);
        SearchView searchview = (SearchView) search.getActionView();
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {//검색 누를때
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {//타이핑 할때마다
                String str = "select * from product where name like'%" + s + "%' ";
                cursor = sql.rawQuery(str, null);
                ad.changeCursor(cursor);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {//롱클릭시 나오는 설정
        menu.setHeaderTitle("정렬방식");
        menu.add(0, 1, 0, "이름정렬(오름차순)");
        menu.add(0, 2, 0, "이름정렬(내림차순)");
        menu.add(0, 3, 0, "가격정렬(오름차순)");
        menu.add(0, 4, 0, "가격정렬(내림차순)");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {//롱클릭시 나오거 클릭 이벤트
        switch (item.getItemId()) {
            case 1:
                cursor = sql.rawQuery("select * from product order by name", null);
                break;
            case 2:
                cursor = sql.rawQuery("select * from product order by name desc", null);
                break;
            case 3:
                cursor = sql.rawQuery("select * from product order by price", null);
                break;
            case 4:
                cursor = sql.rawQuery("select * from product order by price desc", null);
                break;
        }
        ad.changeCursor(cursor);
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {//intent끝날때 행동할것
        if (resultCode == RESULT_OK) {
            cursor = sql.rawQuery("select * from product", null);
            ad.changeCursor(cursor);
        } else {
            Toast.makeText(MainActivity.this, "취소", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void permissionCheck() {//권한 가져오기
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
        }
    }

}
