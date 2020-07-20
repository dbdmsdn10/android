package com.example.ex13;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mclick(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("알립니다");

        switch (view.getId()) {

            case R.id.btn1:
                alert.setMessage("경고드립니다");
                alert.setPositiveButton("확인", null);

                break;
            case R.id.btn2:
                alert.setMessage("저장하시겠습니까?");
                alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "저장되었습니다", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "취소되었습니다", Toast.LENGTH_SHORT).show();
                    }
                });

                break;
            case R.id.btn3:
                final String[] textlist= {"짜장", "짬뽕", "우동", "탕수육"};

                alert.setTitle("음식을 선택하세요");
                alert = alert.setItems(textlist, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        TextView showtext=findViewById(R.id.showtext);
                        showtext.setText(textlist[which]);
                    }
                });
                alert.setNegativeButton("닫기", null);

                break;
            case R.id.btn4:
                final LinearLayout order= (LinearLayout) view.inflate(MainActivity.this,R.layout.order,null);
                alert.setTitle("주문정보");
                alert.setView(order);
                alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText name=order.findViewById(R.id.productname);
                        String strname=name.getText().toString();
                        EditText num=order.findViewById(R.id.productnumber);
                        String strnum=name.getText().toString();
                        CheckBox chk=order.findViewById(R.id.checkbox);
                        String strchk=chk.isChecked() ? "유" : "무";
                        Toast.makeText(MainActivity.this,
                                "상품명: "+strname+"\n상품수량: "+strnum+"\n착불결제: "+strchk,Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"주문 취소",Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
        alert.show();

    }
}
