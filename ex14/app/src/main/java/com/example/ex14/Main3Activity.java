package com.example.ex14;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        findViewById(R.id.btn).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit=new Intent(Main3Activity.this, Main4Activity.class);
                text=findViewById(R.id.maintext);
                String str=text.getText().toString();
                edit.putExtra("text",str);
                startActivityForResult(edit,0);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String strText=data.getStringExtra("text");
        text.setText(strText);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
