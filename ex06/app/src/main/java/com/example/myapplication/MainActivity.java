package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a=findViewById(R.id.img);
        findViewById(R.id.one).setOnLongClickListener(mlong);
        findViewById(R.id.two).setOnLongClickListener(mlong);
        findViewById(R.id.three).setOnLongClickListener(mlong);
        findViewById(R.id.four).setOnLongClickListener(mlong);
        int o=0;
        for(int i=0;i<101;i++)
        {
            o+=i;
        }
        Toast.makeText(MainActivity.this,""+o,Toast.LENGTH_LONG);
        System.out.println("확인"+o);
    }
    Button.OnLongClickListener mlong= new View.OnLongClickListener() {
        String str;
        @Override
        public boolean onLongClick(View v) {
            switch(v.getId()){
                case R.id.one:
                    str="첫번째";
                    break;
                case R.id.two:
                    str="두번째";
                    break;
                case R.id.three:
                    str="세번째";
                    break;
                case R.id.four:
                    str="네번째";
                    break;
            }
            Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
            return false;
        }
    };

    public void doit(View view) {

        switch(view.getId())
        {
            case R.id.one:
                a.setImageResource(R.drawable.factory);
                break;
            case R.id.two:
                a.setImageResource(R.drawable.likedie);
                break;
            case R.id.three:
                a.setImageResource(R.drawable.stop);
                break;
            case R.id.four:
                a.setImageResource(R.drawable.stop2);
                break;
        }
    }
}
