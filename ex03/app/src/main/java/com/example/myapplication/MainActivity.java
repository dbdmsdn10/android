package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button average=findViewById(R.id.averageb);
        average.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText language=findViewById(R.id.language);
                EditText math=findViewById(R.id.math);
                EditText english=findViewById(R.id.english);

                double average2=Integer.parseInt(english.getText().toString());
                average2+=Integer.parseInt(math.getText().toString());
                average2+=Integer.parseInt(language.getText().toString());
                TextView total=findViewById(R.id.total);
                TextView average=findViewById(R.id.average);
                total.setText(""+average2);
                average2=average2/3;

                average.setText( String.format("%.3f",average2));
            }
        });

    }
}
