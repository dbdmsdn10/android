package com.example.ex02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub1);

        //아래로 이벤트처리
        Button confirm=findViewById(R.id.confirmb);
        Button cancle=findViewById(R.id.cancleb);
        Button outbu=findViewById(R.id.outb);
        Button change=findViewById(R.id.change);
        confirm.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText a=findViewById(R.id.name);
                System.out.println(a.getText());
                String namet=a.getText().toString();
                Toast.makeText(MainActivity.this,namet,Toast.LENGTH_LONG).show();
                justdo(namet);
            }
        });
        cancle.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText a=findViewById(R.id.name);
                a.setText("");
            }
        });

        outbu.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText out=findViewById(R.id.out);
                String what=out.getText().toString();
                Toast.makeText(MainActivity.this,what,Toast.LENGTH_LONG).show();
                justdo(what);
            }
        });
        change.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });
    }


    public void justdo(String what){
        int len=what.length();
        if(len>2){
            String st=what.substring(0,2);
            for(int i=2;i<len;i++){
                st+="*";
            }
            Toast.makeText(MainActivity.this,st,Toast.LENGTH_LONG).show();
        }

        ImageView ima=findViewById(R.id.image1);
        if(len==1) {
            ima.setImageResource(R.drawable.ic_launcher_background);
        }
        else if(len==2) {
            ima.setImageResource(R.drawable.ic_launcher_foreground);
        }
        else if(len==3) {
            ima.setImageResource(R.drawable.likedie);
        }
    }
}
