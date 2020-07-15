package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button plus=findViewById(R.id.plus),miner=findViewById(R.id.miner),mul=findViewById(R.id.mul),nanu=findViewById(R.id.nanu);
        plus.setOnClickListener(mclick);
        miner.setOnClickListener(mclick);
        mul.setOnClickListener(mclick);
        nanu.setOnClickListener(mclick);


    }

    Button.OnClickListener mclick= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText a=findViewById(R.id.first),b=findViewById(R.id.second);
            double aa=Double.parseDouble(a.getText().toString()),bb=Double.parseDouble(b.getText().toString());
            TextView c=findViewById(R.id.answer);
            double result=0;
            switch(v.getId()){
                case R.id.plus:
                    result=aa+bb;

                    break;

                case R.id.miner:
                    result=aa-bb;

                    break;

                case R.id.mul:
                    result=aa*bb;
                    break;

                case R.id.nanu:
                    result=aa/bb;
                    result=Math.round(result*100)/100.0;
                    break;
            }
            Toast.makeText(Main2Activity.this,""+result,Toast.LENGTH_SHORT).show();
        }

    };
}
