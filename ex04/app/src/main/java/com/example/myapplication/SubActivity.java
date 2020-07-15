package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative);
        Button a=findViewById(R.id.btn3);
        a.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView name=findViewById(R.id.name);
                ImageView img=findViewById(R.id.img);
                if(img.getVisibility()==View.VISIBLE){
                    name.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                }else{
                    name.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}
