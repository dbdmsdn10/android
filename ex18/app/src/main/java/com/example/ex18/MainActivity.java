package com.example.ex18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm=getSupportFragmentManager();

    }

    public void mclick(View view) {
        switch(view.getId()){
            case R.id.foodbtn:
                FoodFragment ff=new FoodFragment();
                FragmentTransaction trfragment= fm.beginTransaction();
                trfragment.replace(R.id.frame,ff,"food");
                trfragment.commit();
                break;
            case R.id.fruitbtn:
                FruitFragment ff2=new FruitFragment();
                trfragment= fm.beginTransaction();
                trfragment.replace(R.id.frame,ff2,"food");
                trfragment.commit();
                break;
        }
    }
}
