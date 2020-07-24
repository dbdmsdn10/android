package com.example.ex23;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class Addactivity extends AppCompatActivity {
    Database db;
    SQLiteDatabase sql;
    ImageView img;
    String strFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addactivity);
        getSupportActionBar().setTitle("상품등록");
        db=new Database(this);
        sql=db.getWritableDatabase();
        img=findViewById(R.id.editimg);
        img.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,1);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//뒤로가기 버튼
        findViewById(R.id.savebtn).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder box=new AlertDialog.Builder(Addactivity.this);
                box.setTitle("확인");
                box.setMessage("저장하시겠습니까?");
                box.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText name=findViewById(R.id.editname);
                        EditText price=findViewById(R.id.editprice);
                        ImageView img=findViewById(R.id.editimg);

                        String strname=name.getText().toString();
                        String strprice=price.getText().toString();
                        sql.execSQL("insert into product(name, price, img) values('"+strname+"',"+strprice+",'"+strFile+"')");

                        setResult(RESULT_OK);
                        finish();
                    }
                });
                box.setNegativeButton("아니요",null);
                box.show();
            }
        });
        findViewById(R.id.canclebtn).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {//사진값 가져오기
        if(requestCode==1&&resultCode==RESULT_OK){
            String[] projection={MediaStore.Images.Media.DATA};
            Cursor cursor=getContentResolver().query(data.getData(),projection,null,null,null);
            cursor.moveToFirst();
            strFile=cursor.getString(cursor.getColumnIndex(projection[0]));
            cursor.close();
            Bitmap img2= BitmapFactory.decodeFile(strFile);
            img.setImageBitmap(img2);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
