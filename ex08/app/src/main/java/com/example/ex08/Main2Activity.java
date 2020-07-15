package com.example.ex08;

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

public class Main2Activity extends AppCompatActivity {
    Button btn,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn = findViewById(R.id.btn);
        btn.setTextColor(Color.BLACK);
        btn2=findViewById(R.id.btn2);
        registerForContextMenu(btn);//버튼클릭 이벤트삽입
        registerForContextMenu(btn2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//메뉴삽입
        getMenuInflater().inflate(R.menu.sub, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//메뉴 ITEM클릭시
        switch (item.getItemId()) {
            case R.id.bigfont:
                if (item.isChecked()) {
                    btn.setTextSize(TypedValue.COMPLEX_UNIT_PX,50);
                } else {
                    btn.setTextSize(TypedValue.COMPLEX_UNIT_PX,100);
                }
                break;
            case R.id.blue:
                btn.setTextColor(Color.BLUE);
                break;
            case R.id.red:
                btn.setTextColor(Color.RED);
                break;
            case R.id.green:
                btn.setTextColor(Color.GREEN);
                break;
            case R.id.BLACK:
                btn.setTextColor(Color.BLACK);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {// 버튼 꾹누를시 나오는 메뉴
        if(v==btn){
        menu.setHeaderTitle("글자색 변경");
        menu.add(0,1,0,"빨강");
        menu.add(0,2,0,"파랑");
        menu.add(0,3,0,"초록");
        menu.add(0,4,0,"하양");}
        if(v==btn2){
            menu.setHeaderTitle("배경색 변경");
            menu.add(0,5,0,"빨강");
            menu.add(0,6,0,"파랑");
            menu.add(0,7,0,"초록");
            menu.add(0,8,0,"회색");
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {//버틑 꾹누를시 나오는 메튜 ITEM클릭시
        switch (item.getItemId())
        {
            case 1:
                btn.setTextColor(Color.RED);
                break;
            case 2:
                btn.setTextColor(Color.BLUE);
                break;
            case 3:
                btn.setTextColor(Color.GREEN);
                break;
            case 4:
                btn.setTextColor(Color.WHITE);
                break;
            case 5:
                btn2.setBackgroundColor(Color.RED);
                break;
            case 6:
                btn2.setBackgroundColor(Color.BLUE);
                break;
            case 7:
                btn2.setBackgroundColor(Color.GREEN);
                break;
            case 8:
                btn2.setBackgroundColor(Color.GRAY);
                break;

        }
        return super.onContextItemSelected(item);
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {//메뉴버튼 누를시
        if (btn.getTextSize() == 100) {
            menu.findItem(R.id.bigfont).setChecked(true);
        } else {
            menu.findItem(R.id.bigfont).setChecked(false);
        }
        int color = btn.getTextColors().getDefaultColor();
        switch (color) {
            case Color.RED:
                menu.findItem(R.id.red).setChecked(true);
                break;
            case Color.BLUE:
                menu.findItem(R.id.blue).setChecked(true);
                break;
            case Color.GREEN:
                menu.findItem(R.id.green).setChecked(true);
                break;
            case Color.BLACK:
                menu.findItem(R.id.BLACK).setChecked(true);
                break;
        }


        return true;
    }
}
