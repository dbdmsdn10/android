package com.example.ex11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
ArrayList<Product> a;
ListView c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        a=new ArrayList<Product>();
        Product productitem=new Product(R.drawable.ic_launcher_background,1000,"배경");
        a.add(productitem);

        Product productitem2=new Product(R.drawable.ic_launcher_foreground,200,"다른것");
        a.add(productitem2);

        c=findViewById(R.id.list);
        Myadapter adapter=new Myadapter();
        c.setAdapter(adapter);
    }

    class Myadapter extends BaseAdapter{

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
            convertView = getLayoutInflater().inflate(R.layout.item, parent, false);
            ImageView img=convertView.findViewById(R.id.img);
            img.setImageResource(a.get(position).src);

            TextView text=convertView.findViewById(R.id.name);
            final String name=a.get(position).name;
            text.setText(name);

            TextView price=convertView.findViewById(R.id.price);
            price.setText(""+a.get(position).price);
            convertView.findViewById(R.id.btn).setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Main2Activity.this,name,Toast.LENGTH_SHORT).show();
                }
            });
            return convertView;
        }
    }
}
