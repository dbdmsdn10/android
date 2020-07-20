package com.example.ex14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuactivity);
    }

    public void mclick(View view) {
        switch (view.getId())
        {
            case R.id.btn1:
                Intent main=new Intent(MenuActivity.this,MainActivity.class);
                startActivity(main);
                break;
            case R.id.btn2:
                Intent sub=new Intent(MenuActivity.this,Main3Activity.class);
                startActivity(sub);
                break;

        }
    }
}
