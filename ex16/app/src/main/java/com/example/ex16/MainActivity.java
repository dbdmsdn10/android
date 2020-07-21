package com.example.ex16;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView maintext, mainnum;
    Intent sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        maintext = findViewById(R.id.maintext);
        mainnum = findViewById(R.id.mainnumber);
        
        findViewById(R.id.btn).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                sub = new Intent(MainActivity.this, Main2Activity.class);
                sub.putExtra("maintext", maintext.getText().toString());
                sub.putExtra("mainnumber", Integer.parseInt(mainnum.getText().toString()));
                startActivityForResult(sub, 1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            maintext.setText(data.getStringExtra("maintext2"));
            mainnum.setText(data.getStringExtra("mainnumber2"));
            System.out.println("확인용");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
