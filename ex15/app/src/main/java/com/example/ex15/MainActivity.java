package com.example.ex15;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView name,adress,age,tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        adress=findViewById(R.id.adress);
        age=findViewById(R.id.age);
        tel=findViewById(R.id.tel);
        findViewById(R.id.btn).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("name",name.getText().toString());
                intent.putExtra("adress",adress.getText().toString());
                int a=Integer.parseInt(age.getText().toString());
                intent.putExtra("age",a);
                intent.putExtra("tel",tel.getText().toString());
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        name.setText(data.getStringExtra("name"));
        adress.setText(data.getStringExtra("adress"));
        age.setText(data.getIntExtra("age",0)+"");
        tel.setText(data.getStringExtra("tel"));
        super.onActivityResult(requestCode, resultCode, data);
    }
}
