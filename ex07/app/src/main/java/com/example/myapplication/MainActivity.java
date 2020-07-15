package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a=findViewById(R.id.textt);
        findViewById(R.id.white).setOnLongClickListener(mlong);
        findViewById(R.id.red).setOnLongClickListener(mlong);
        findViewById(R.id.blue).setOnLongClickListener(mlong);
    }

    Button.OnLongClickListener mlong= new Button.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            String str;
            switch (view.getId()){
                case R.id.white:
                    str="첫번째";
                    break;
                case R.id.red:
                    str="두번째";
                    break;
                case R.id.blue:
                    str="세번째";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + view.getId());
            }
            Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
            return true;
        }
    };
    public void doit(View view) {
        switch (view.getId()){
            case R.id.white:
                a.setTextColor(Color.WHITE);
                break;
            case R.id.red:
                a.setTextColor(Color.RED);
                break;
            case R.id.blue:
                a.setTextColor(Color.BLUE);
                break;
        }
    }
}
