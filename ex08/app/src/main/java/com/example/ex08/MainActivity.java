package com.example.ex08;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {



    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.img);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                img.setImageResource(R.drawable.zzazng);
                break;
            case R.id.item2:
                img.setImageResource(R.drawable.zzamppong);
                break;
            case R.id.item3:
                break;
            case R.id.item4:
                img.setImageResource(R.drawable.udong);
                break;
            case R.id.item5:
                img.setImageResource(R.drawable.guunmanduu);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
