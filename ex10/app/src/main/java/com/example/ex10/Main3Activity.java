package com.example.ex10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    ArrayList a;
    ArrayAdapter b;
    ListView c;
    Button btn1,btn2;
    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        text=findViewById(R.id.edit);
        btn1=findViewById(R.id.put);
        btn2=findViewById(R.id.del);
        a=new ArrayList();
        a.add("first");
        a.add("second");
        a.add("third");
        b=new ArrayAdapter(this,android.R.layout.simple_list_item_multiple_choice,a);
        c=findViewById(R.id.list);
        c.setAdapter(b);
        c.setChoiceMode(ListView.CHOICE_MODE_SINGLE);//채크박스를 만들어줌
        c.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position!=-1)
                {
                    String str= (String) a.get(position);
                    Toast.makeText(Main3Activity.this,str,Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void doit(View view) {
        switch (view.getId())
        {
            case R.id.put:
                String cc=text.getText().toString();
                if(cc.length()!=0){
                    a.add(cc);
                    text.setText("");
                    b.notifyDataSetChanged();
                }
                else{
                    Toast.makeText(Main3Activity.this,"내용을 입력하시오",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.del:
                int position=c.getCheckedItemPosition();
                if(position!=ListView.INVALID_POSITION){
                    a.remove(position);
                    c.clearChoices();
                    b.notifyDataSetChanged();
                }
                break;
        }
    }
}
