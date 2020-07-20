package com.example.ex15;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    Intent intent;
    EditText name,adress,age,tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        intent=getIntent();
        String strname=intent.getStringExtra("name");
        String stradress=intent.getStringExtra("adress");
        int intage=intent.getIntExtra("age",0);
        String strtel=intent.getStringExtra("tel");
        name=findViewById(R.id.name);
        name.setText(strname);
        adress=findViewById(R.id.adress);
        adress.setText(stradress);
        age=findViewById(R.id.age);
        age.setText(intage+"");
        tel=findViewById(R.id.tel);
        tel.setText(strtel);
    }

    public void mclick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                AlertDialog.Builder alert=new AlertDialog.Builder(Main2Activity.this);
                alert.setTitle("질의");
                alert.setMessage("저장하시겠습니까");
                alert.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intent=new Intent();
                        intent.putExtra("name",name.getText().toString());
                        intent.putExtra("adress",adress.getText().toString());
                        intent.putExtra("age",Integer.parseInt(age.getText().toString()));
                        intent.putExtra("tel",tel.getText().toString());
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                });
                alert.setNegativeButton("아니요",null);
                alert.show();
                break;
            case R.id.btn2:
                setResult(RESULT_CANCELED,intent);
                finish();
                break;
        }
    }
}
