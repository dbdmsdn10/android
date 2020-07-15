package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class sub2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
        Button oneb=findViewById(R.id.oneb);
        Button twob=findViewById(R.id.twob);
        Button threeb=findViewById(R.id.threeb);

        oneb.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout one=findViewById(R.id.one);
                LinearLayout two=findViewById(R.id.two);
                LinearLayout three=findViewById(R.id.three);

                one.setVisibility(View.VISIBLE);
                two.setVisibility(View.INVISIBLE);
                three.setVisibility(View.INVISIBLE);
            }
        });

        twob.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout one=findViewById(R.id.one);
                LinearLayout two=findViewById(R.id.two);
                LinearLayout three=findViewById(R.id.three);

                one.setVisibility(View.INVISIBLE);
                two.setVisibility(View.VISIBLE);
                three.setVisibility(View.INVISIBLE);
            }
        });
        threeb.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout one=findViewById(R.id.one);
                LinearLayout two=findViewById(R.id.two);
                LinearLayout three=findViewById(R.id.three);

                one.setVisibility(View.INVISIBLE);
                two.setVisibility(View.INVISIBLE);
                three.setVisibility(View.VISIBLE);
            }
        });
    }
}
