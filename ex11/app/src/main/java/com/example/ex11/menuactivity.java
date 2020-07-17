package com.example.ex11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class menuactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuactivity);
    }

    public void mClick(View view) {
        Intent intent=null;
        switch (view.getId()){
            case R.id.btn:
                intent=new Intent(menuactivity.this,MainActivity.class);
                break;
            case R.id.btn1:
                intent=new Intent(menuactivity.this,Main2Activity.class);
                break;
            case R.id.btn2:
                intent=new Intent(menuactivity.this,Main3Activity.class);
                break;
            case R.id.btn3:
                intent=new Intent(menuactivity.this,Main4Activity.class);
                break;
            case R.id.btn4:
                intent=new Intent(menuactivity.this,Main5Activity.class);
                break;
        }
        startActivity(intent);
    }
}
