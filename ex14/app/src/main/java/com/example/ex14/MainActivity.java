package com.example.ex14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.activitybtn).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sub=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(sub);
            }
        });
    }
}