package com.example.ex19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("NO.19");//이름바꾸기
        getSupportActionBar().setSubtitle("sub");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.btnone:
                Toast.makeText(MainActivity.this,"one",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btntwo:
                Toast.makeText(MainActivity.this,"two",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnthree:
                Toast.makeText(MainActivity.this,"three",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnfour:
                Toast.makeText(MainActivity.this,"four",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnfive:
                Toast.makeText(MainActivity.this,"five",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void radioclick(View view) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        switch (view.getId()){
            case R.id.productbtn:
                System.out.println("확인용1");
                ProductFragment pf=new ProductFragment();
                ft.replace(R.id.frmae,pf,"product");
                ft.commit();
                break;
            case R.id.adressbtn:
                System.out.println("확인용2");
                AdressFragment af=new AdressFragment();
                ft.replace(R.id.frmae,af,"adress");
                ft.commit();
                break;
            case R.id.homebtn:
                break;
        }
    }
}
