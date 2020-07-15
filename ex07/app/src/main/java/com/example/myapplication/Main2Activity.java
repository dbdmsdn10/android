package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {
LinearLayout page1,page2,page3;
ImageView img;
TextView sumt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        page1=findViewById(R.id.page1);
        page2=findViewById(R.id.page2);
        page3=findViewById(R.id.page3);
        sumt=findViewById(R.id.sumt);
        findViewById(R.id.nameb).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name=findViewById(R.id.name);
                Toast.makeText(Main2Activity.this,name.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        img=findViewById(R.id.imgfirst);
        findViewById(R.id.sumb).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                int answer=0;
                for(int i=0;i<101;i++){
                    answer+=i;
                }
                sumt.setText(""+answer);
            }
        });
    }

    public void doit(View view) {
        page1.setVisibility(View.INVISIBLE);
        page2.setVisibility(View.INVISIBLE);
        page3.setVisibility(View.INVISIBLE);
        switch(view.getId()){
            case R.id.one:
                page1.setVisibility(View.VISIBLE);
                break;
            case R.id.two:
                page2.setVisibility(View.VISIBLE);
                break;
            case R.id.three:
                page3.setVisibility(View.VISIBLE);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }

    public void doit2(View view) {
        switch (view.getId()){
            case R.id.firstb:
                img.setImageResource(R.drawable.factory);
                break;
            case R.id.secondb:
                img.setImageResource(R.drawable.ic_launcher_background);
                break;
            case R.id.thirdb:
                img.setImageResource(R.drawable.ic_launcher_foreground);
                break;
        }
    }
}
