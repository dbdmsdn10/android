package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void doit(View view) {
        switch (view.getId()){
            case R.id.btn1:
                break;
            case R.id.btn2:
                LinearLayout linear2=(LinearLayout)View.inflate(Main3Activity.this, R.layout.custom1,null);
                Toast toas2=new Toast(Main3Activity.this);
                toas2.setView(linear2);
                toas2.show();
                break;

            case R.id.btn3:
                count++;
                Toast.makeText(Main3Activity.this,"현재 카운트"+count,Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn4:
                LinearLayout linear=(LinearLayout)View.inflate(Main3Activity.this, R.layout.custom,null);
                Toast toas=new Toast(Main3Activity.this);
                toas.setView(linear);
                toas.show();
                break;
        }
    }
}
