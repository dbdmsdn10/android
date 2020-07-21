package com.example.ex18;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FruitFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_fruit, container, false);
        final ArrayList fruitlist = new ArrayList();
        fruitlist.add("조");
        fruitlist.add("율");
        fruitlist.add("이");
        fruitlist.add("시");
        fruitlist.add("제사");
        ArrayAdapter ad=new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,fruitlist);
        ListView list=view.findViewById(R.id.list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getActivity(), (String)fruitlist.get(position),Toast.LENGTH_SHORT).show();
            }
        });
        list.setAdapter(ad);
        return view;
    }
}
