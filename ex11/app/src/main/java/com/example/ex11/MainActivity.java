package com.example.ex11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ArrayList a;
ArrayAdapter b;
ListView c,d;
    Spinner E,F;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a=new ArrayList();
        a.add("바나나");
        a.add("포도");
        a.add("수박");
        b=new ArrayAdapter(this,android.R.layout.simple_list_item_multiple_choice,a);
        c=findViewById(R.id.list);
        c.setAdapter(b);
        c.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        d=findViewById(R.id.list2);


        ArrayAdapter bb=new ArrayAdapter(this,android.R.layout.simple_list_item_single_choice,a);
        d.setAdapter(bb);
        d.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        E=findViewById(R.id.spinner);
        ArrayAdapter bbb=new ArrayAdapter(this,android.R.layout.simple_list_item_1,a);
        E.setAdapter(bbb);

        F=findViewById(R.id.spinner2);
        ArrayAdapter bbbb=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,a);
        bbbb.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        F.setAdapter(bbbb);
    }
}
