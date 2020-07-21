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


public class FoodFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food, container, false);

        final ArrayList foodlist = new ArrayList();
        foodlist.add("짜장");
        foodlist.add("짬뽕");
        foodlist.add("우동");
        foodlist.add("군만두");
        foodlist.add("탕수육");
        ArrayAdapter ad=new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,foodlist);
        ListView list=view.findViewById(R.id.list);
        list.setAdapter(ad);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getActivity(), (String)foodlist.get(position),Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
