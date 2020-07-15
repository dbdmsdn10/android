package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void doit(View view) {
        EditText a = findViewById(R.id.first), b = findViewById(R.id.second);
        if (!(a.getText().toString().equals("") || b.getText().toString().equals(""))) {
            double aa = Double.parseDouble(a.getText().toString()), bb = Double.parseDouble(b.getText().toString());
            TextView answer = findViewById(R.id.answer);

            switch (view.getId()) {
                case R.id.plus:
                    answer.setText("" + (aa + bb));
                    break;

                case R.id.miner:
                    answer.setText("" + (aa - bb));
                    break;
                case R.id.mul:
                    answer.setText("" + (aa * bb));
                    break;

                case R.id.nanu:
                    answer.setText(String.format("%.3f", aa / bb));
                    break;
            }

        }
    }
}


