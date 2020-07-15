package com.example.ex02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub2);

        Button a=findViewById(R.id.phonb);
        Button change=findViewById(R.id.change2);
        a.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText b=findViewById(R.id.phonenum);
                String c=b.getText().toString();
                Toast.makeText(MainActivity2.this,c,Toast.LENGTH_LONG).show();
                if(c.length()==11) {
                    String first = c.substring(0, 3), second = c.substring(3, 7), third = c.substring(7, c.length());
                    String finaly = first + "-" + second + "-" + third;
                    Toast.makeText(MainActivity2.this,finaly,Toast.LENGTH_LONG).show();
                }
                else if(c.length()==10) {
                    String first = c.substring(0, 3), second = c.substring(3, 6), third = c.substring(6, c.length());
                    String finaly = first + "-" + second + "-" + third;
                    Toast.makeText(MainActivity2.this,finaly,Toast.LENGTH_LONG).show();
                }
            }
        });
        change.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
