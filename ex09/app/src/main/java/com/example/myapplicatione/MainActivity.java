package com.example.myapplicatione;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        registerForContextMenu(btn2);
        registerForContextMenu(btn1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//매뉴 삽입
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//매뉴창내의 item클릭시
        switch (item.getItemId()) {
            case R.id.size1:
                btn1.setTextSize(TypedValue.COMPLEX_UNIT_PX,50);
                break;
            case R.id.size2:
                btn1.setTextSize(TypedValue.COMPLEX_UNIT_PX,100);
                break;
            case R.id.size3:
                btn1.setTextSize(TypedValue.COMPLEX_UNIT_PX,150);
                break;
            case R.id.color1:
                btn1.setTextColor(Color.BLACK);
                break;
            case R.id.color2:
                btn1.setTextColor(Color.RED);
                break;
            case R.id.color3:
                btn1.setTextColor(Color.BLUE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {//매뉴창 만들기전
        int size= (int) btn1.getTextSize();
        if(size==50){
            menu.findItem(R.id.size1).setChecked(true);
        }
        else if(size==100){
            menu.findItem(R.id.size2).setChecked(true);
        }
        else if(size==150){
            menu.findItem(R.id.size3).setChecked(true);
        }
        int color=btn1.getTextColors().getDefaultColor();
        if(color==Color.BLACK){
            menu.findItem(R.id.color1).setChecked(true);
        }
        else if(color==Color.RED){
            menu.findItem(R.id.color2).setChecked(true);
        }
        else if(color==Color.BLUE){
            menu.findItem(R.id.color3).setChecked(true);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {//꾹누를때
        switch (v.getId()){
            case R.id.btn1:
                menu.setHeaderTitle("크기 변경");
                menu.add(0,1,0,"50");
                menu.add(0,2,0,"100");
                menu.add(0,3,0,"150");
                break;
            case R.id.btn2:
                menu.setHeaderTitle("색깔변경");
                menu.add(0,4,0,"검정");
                menu.add(0,5,0,"빨강");
                menu.add(0,6,0,"파랑");
                break;
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case 1:
                btn1.setTextSize(TypedValue.COMPLEX_UNIT_PX,50);
                break;
            case 2:
                btn1.setTextSize(TypedValue.COMPLEX_UNIT_PX,100);
                break;
            case 3:
                btn1.setTextSize(TypedValue.COMPLEX_UNIT_PX,150);
                break;
            case 4:
                btn1.setTextColor(Color.BLACK);
                break;
            case 5:
                btn1.setTextColor(Color.RED);
                break;
            case 6:
                btn1.setTextColor(Color.BLUE);
                break;
        }
        return super.onContextItemSelected(item);
    }
}

