package com.example.ex18;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class wordlist extends ListFragment {
    String[] words={"남","여","학교","안녕","잘가"};
    String[] desc={"어쩌구","저쩌구","그래서","잘가","그래"};
    ArrayList<String> words2,desc2;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        words2=new ArrayList<String>();
        words2.add("남");
        words2.add("여");
        words2.add("학교");
        words2.add("안녕");

        words2.add("잘가");
        desc2=new ArrayList<String>();
        desc2.add("어쩌구");
        desc2.add("저쩌구");
        desc2.add("그래서");
        desc2.add("잘가");
        desc2.add("그래");


        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,words2));
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        TextView text=getActivity().findViewById(R.id.text);
        text.setText(desc2.get(position));
    }
}
