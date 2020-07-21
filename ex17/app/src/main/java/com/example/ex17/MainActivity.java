package com.example.ex17;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    FragmentManager fmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        fmanager= getSupportFragmentManager();
    }


    public void mclick(View view) {
        switch (view.getId()) {
            case R.id.menubtn1:
                FragmentTransaction trfragment=fmanager.beginTransaction();

                BlankFragment bf=new BlankFragment();
                trfragment.replace(R.id.frame,bf,"counter");
                trfragment.commit();
                break;
            case R.id.menubtn2:
                trfragment=fmanager.beginTransaction();
                TextFragment tf=new TextFragment();
                trfragment.replace(R.id.frame,tf,"counter");
                trfragment.commit();
                break;

        }
    }
}
