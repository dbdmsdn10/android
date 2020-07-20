package com.example.ex14;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main4Activity extends AppCompatActivity {
    EditText edit;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        intent= getIntent();
        String strText = intent.getStringExtra("text");
        edit = findViewById(R.id.edit);
        edit.setText(strText);
    }

    public void mclick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                intent=new Intent();
                String stredit = edit.getText().toString();
                intent.putExtra("text", stredit);
                setResult(RESULT_OK,intent);
                finish();
                break;
            case R.id.btn2:
                setResult(RESULT_CANCELED,intent);
                finish();
                break;
        }
    }


}
