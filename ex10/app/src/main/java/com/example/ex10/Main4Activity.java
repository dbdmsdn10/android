package com.example.ex10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {
    ArrayList<item3> a;
    ListView c;
    Myadapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        a = new ArrayList();
        a.add(new item3(R.drawable.factory, "공장",1000000000));
        a.add(new item3(R.drawable.guunmanduu, "군만두",2000));
        a.add(new item3(R.drawable.likedie, "죽을것같아요",0));
        a.add(new item3(R.drawable.zzazng, "짜장",4000));
        ad=new Myadapter();
        c=findViewById(R.id.list4);
        c.setAdapter(ad);
    }

    class item3 {
        int img;
        String name;
        int price;
        public item3(int img, String name,int price) {
            this.img = img;
            this.name = name;
            this.price=price;
        }
    }

    class Myadapter extends BaseAdapter {
        @Override
        public int getCount() {//사이즈 가져오고
            return a.size();
        }

        @Override
        public Object getItem(int position) {
            return a.get(position).name;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {//사이즈 갯수만큼 반목
            convertView = getLayoutInflater().inflate(R.layout.item2, parent, false);
            ImageView img=convertView.findViewById(R.id.img2);
            img.setImageResource(a.get(position).img);
            TextView name=convertView.findViewById(R.id.productName);

            name.setText(a.get(position).name);
            final String productname2=a.get(position).name;

            TextView price=convertView.findViewById(R.id.price);
            price.setText(""+a.get(position).price);

            convertView.findViewById(R.id.order).setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Main4Activity.this,productname2,Toast.LENGTH_SHORT).show();
                }
            });
            return convertView;
        }
    }
}
