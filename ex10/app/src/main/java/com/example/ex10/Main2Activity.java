package com.example.ex10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ArrayList a=new ArrayList();
        a.add("cpu");
        a.add("그래픽 카드");
        a.add("메모리(램)");
        //ArrayAdapter b=new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,a);//어뎁터만들어 arraylist 삽입하기
        ArrayAdapter b=new ArrayAdapter(this,R.layout.item,a);
        ListView list=findViewById(R.id.list);
        list.setAdapter(b);//list에 어뎁터 넣기
        ArrayList q=new ArrayList();
        q.add("사과");
        q.add("배");
        q.add("대추");
        b=new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,q);
        ListView list2=findViewById(R.id.list2);
        list2.setAdapter(b);//list에 어뎁터 넣기
    }
}
