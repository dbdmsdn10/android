package com.example.ex11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {
ArrayList<Adrress> a;//adrress클래스 가져와 생성
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        a=new ArrayList<Adrress>();
        a.add(new Adrress("마린","코랄","010-****-****",R.drawable.marin,R.drawable.medic));
        a.add(new Adrress("스페이스 마린","황제","***-***-***",R.drawable.spacemarine,R.drawable.inquisitor));
        ListView b=findViewById(R.id.list);
        Doadapter c=new Doadapter();//아래 클래스대로 adapter생성
        b.setAdapter(c);
    }
    class Doadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return a.size();
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
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.item_add, parent, false);
            ImageView img=convertView.findViewById(R.id.img);
            img.setImageResource(a.get(position).img);

            ImageView img2=convertView.findViewById(R.id.img2);
            img2.setImageResource(a.get(position).img2);

            TextView name=convertView.findViewById(R.id.name);
            name.setText(a.get(position).name);

            TextView adress=convertView.findViewById(R.id.adress);
            adress.setText(a.get(position).adress);

            TextView phone=convertView.findViewById(R.id.phone);
            phone.setText(a.get(position).phone);

            return convertView;
        }
    }
}
