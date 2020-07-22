package com.example.ex19;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.List;

public class ProductFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_product, container, false);
        // Inflate the layout for this fragment
        ListView list=view.findViewById(R.id.productlist);
        Database db=new Database(getContext());
        SQLiteDatabase sql=db.getReadableDatabase();
        Cursor cursor=sql.rawQuery("select * from product",null);
        //데이터 불러왔으니 어댑터 만들기
        SimpleCursorAdapter ad=new SimpleCursorAdapter(getActivity(),android.R.layout.simple_list_item_2,cursor,new String[]{"name","price"},new int[]{android.R.id.text1,android.R.id.text2});
        //(출력위치,학목 2개라서 item2, 출력하고 싶은것은 2개라서 name price, 데이터베이스에저 값 가져오기, 1과2의 위치 바꾸면 가격과 이름 바뀜)
        list.setAdapter(ad);
        return view;
    }
}
