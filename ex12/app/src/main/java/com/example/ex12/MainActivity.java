package com.example.ex12;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ArrayList<Adress> adress;
    Myadapter c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adress=new ArrayList<Adress>();
        adress.add(new Adress("이름1","///-////-////"));
        adress.add(new Adress("이름2","***-****-****"));
        adress.add(new Adress("이름3","+++-++++-++++"));

        ListView list=findViewById(R.id.list);
        c=new Myadapter();
        list.setAdapter(c);
    }
    class Myadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return adress.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            convertView=getLayoutInflater().inflate(R.layout.item,parent,false);
            TextView name=convertView.findViewById(R.id.name);
            name.setText(adress.get(position).name);
            TextView adress2=convertView.findViewById(R.id.phone);
            adress2.setText(adress.get(position).adress);

            Button btn2=convertView.findViewById(R.id.btn);
            btn2.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("정말 삭제하시겠습니까?");
                    alert.setMessage("복구되지않습니다");
                    alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            adress.remove(position);
                            c.notifyDataSetChanged();//이거 안하면 새로고침 안됨
                        }
                    });//버튼삽입
                    alert.setNegativeButton("취소",null);
                    alert.show();
                }
            });
            return convertView;
        }
    }
}
