package com.example.ex22;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Database db;
    SQLiteDatabase sql;
    Cursor cursor;
    Myadater ad;
    String str = "select *from addresses order by name";
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("주소관리");
        setContentView(R.layout.activity_main);
        db = new Database(this);
        sql = db.getReadableDatabase();
        cursor = sql.rawQuery("select * from addresses", null);
        ad = new Myadater(this, cursor);
        list = findViewById(R.id.list);
        list.setAdapter(ad);
        registerForContextMenu(list);
    }

    class Myadater extends CursorAdapter {
        public Myadater(Context context, Cursor c) {
            super(context, c);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.item_layout, parent, false);
            return view;
        }

        @Override
        public void bindView(final View view, Context context, final Cursor c) {//XML의 버튼눌렀을때
            TextView name = view.findViewById(R.id.nametxt);
            TextView address = view.findViewById(R.id.addresstxt);
            TextView phone = view.findViewById(R.id.phonetxt);
            final String strname = c.getString(1);
            name.setText(strname);
            final String strcall = c.getString(2);
            phone.setText(strcall);
            final String straddress = c.getString(3);
            address.setText(straddress);
            final int id = c.getInt(0);
            view.findViewById(R.id.delbtn).setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder box = new AlertDialog.Builder(MainActivity.this);
                    box.setTitle("확인");
                    box.setMessage("정말 삭제하시겠습니까?");
                    box.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            sql.execSQL("delete from addresses where _id=" + id);
                            cursor = sql.rawQuery("select * from addresses", null);
                            ad.changeCursor(cursor);
                        }
                    });
                    box.setNegativeButton("아니요", null);
                    box.show();
                }
            });

            view.findViewById(R.id.callbtn).setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + strcall));
                    //Intent intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+strcall));
                    startActivity(intent);
                }
            });
            view.findViewById(R.id.updatebtn).setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AlertDialog.Builder box = new AlertDialog.Builder(MainActivity.this);
                    box.setTitle("개인정보");
                    final View layout = getLayoutInflater().inflate(R.layout.addxml, null);
                    final EditText name = layout.findViewById(R.id.name);
                    final EditText address = layout.findViewById(R.id.address);
                    final EditText phone = layout.findViewById(R.id.phone);
                    name.setText(strname);
                    phone.setText(strcall);
                    address.setText(straddress);
                    box.setView(layout);


                    box.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String newname = name.getText().toString();
                            String newphone = phone.getText().toString();
                            String newaddress = address.getText().toString();
                            sql.execSQL("update addresses set name='" + newname + "' , phone='" + newphone + "',address='" + newaddress + "' where _id=" + id);

                            cursor = sql.rawQuery("select * from addresses", null);
                            ad.changeCursor(cursor);
                        }
                    });
                    box.setNegativeButton("아니요", null);
                    box.show();
                }
            });
        }
    }

    //------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem search = menu.findItem(R.id.searchbtn);//아래로 문자 입력시 자동검색 기능
        SearchView searchView = (SearchView) search.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {//엔터를 눌렀을때
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {//입력할때마다
                String str = "select * from addresses where name like '%" + newText + "%' or phone like '%" + newText + "%' or address like '%" + newText + "%'";
                cursor = sql.rawQuery(str, null);
                ad.changeCursor(cursor);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addbtn:
                AlertDialog.Builder box = new AlertDialog.Builder(MainActivity.this);
                box.setTitle("개인정보");
                final View layout = getLayoutInflater().inflate(R.layout.addxml, null);
                box.setView(layout);
                final EditText name = layout.findViewById(R.id.name);
                final EditText phone = layout.findViewById(R.id.phone);
                final EditText address = layout.findViewById(R.id.address);
                box.setPositiveButton("확인", new DialogInterface.OnClickListener() {//확인 누르면 삽입
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sql.execSQL("insert into addresses values(null,'" + name.getText().toString() + "','" + phone.getText().toString() + "','" + address.getText().toString() + "')");
                        cursor = sql.rawQuery("select * from addresses", null);
                        ad.changeCursor(cursor);
                    }
                });
                box.setNegativeButton("취소", null);
                box.show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    //------------------

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {//
        menu.setHeaderTitle("정렬방식");
        menu.add(0, 1, 0, "이름순");
        menu.add(0, 2, 0, "전화번호순");
        menu.add(0, 3, 0, "주소순");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {//오래 눌렀을때 나오는것 눌렀을때 정렬을 담당함
        String str = "";
        switch (item.getItemId()) {
            case 1:
                str = "select * from addresses order by name";
                break;
            case 2:
                str = "select * from addresses order by phone";
                break;
            case 3:
                str = "select * from addresses order by address";
                break;
        }
        cursor = sql.rawQuery(str, null);
        ad.changeCursor(cursor);

        return super.onContextItemSelected(item);
    }
}
