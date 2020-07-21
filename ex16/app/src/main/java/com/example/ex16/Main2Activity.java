package com.example.ex16;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    EditText edittext,editnum;
    Intent mainintent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edittext=findViewById(R.id.edittext);
        mainintent=getIntent();
        edittext.setText(mainintent.getStringExtra("maintext"));
        editnum=findViewById(R.id.editnumber);
        editnum.setText(mainintent.getIntExtra("mainnumber",0)+"");
    }

    public void onclick(View view) {
        switch (view.getId())
        {
            case R.id.btn1:
                AlertDialog.Builder alert=new AlertDialog.Builder(Main2Activity.this);
                alert.setTitle("알림");
                alert.setMessage("수정하시겠습니까");
                alert.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mainintent=new Intent();
                        mainintent.putExtra("maintext2",edittext.getText().toString());
                        mainintent.putExtra("mainnumber2",editnum.getText().toString());
                        setResult(RESULT_OK,mainintent);
                        finish();
                    }
                });
                alert.setNegativeButton("아니요", null);

                alert.show();
                break;
            case R.id.btn2:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}
