package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        final Button up = findViewById(R.id.plus);
        final Button down = findViewById(R.id.miners);
        final Button reset = findViewById(R.id.reset);
        final TextView result = findViewById(R.id.result);
        up.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                result.setText("" + count);
            }
        });

        up.setOnLongClickListener(new Button.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                count += 100;
                result.setText("" + count);

                return true;
            }
        });

        down.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                result.setText("" + count);
            }
        });

        down.setOnLongClickListener(new Button.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                count -= 100;
                result.setText("" + count);

                return true;
            }
        });
        reset.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                result.setText("" + count);

            }
        });
    }
}
