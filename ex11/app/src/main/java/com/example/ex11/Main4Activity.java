package com.example.ex11;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main4Activity extends AppCompatActivity {
ProgressBar first,second;
int yeari,monthi,dayi,houri,minutei;
TextView text,time2;
    Calendar cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        time2=findViewById(R.id.timeb);
        first=findViewById(R.id.progbar);
        second=findViewById(R.id.progbar2);
        text=findViewById(R.id.textb);
        cal=new GregorianCalendar();

        yeari=cal.get(Calendar.YEAR);
        monthi=cal.get(Calendar.MONTH);
        dayi=cal.get(Calendar.DAY_OF_MONTH);
        houri=cal.get(Calendar.HOUR_OF_DAY);
        minutei=cal.get(Calendar.MINUTE);
        updatedate();

    }
    public void updatedate(){
        text.setText(String.format("%d/%d/%d",yeari,monthi+1,dayi));
        time2.setText(String.format("%d:%d",houri,minutei));
    }

    public void mClick(View view) {

        switch (view.getId()){
            case R.id.up:
                first.incrementProgressBy(+10);//진행 +시켜주기
                break;
            case R.id.down:
                first.incrementProgressBy(-10);
                break;
            case R.id.sup:
                second.setVisibility(View.VISIBLE);
                break;
            case R.id.sdown:
                second.setVisibility(View.INVISIBLE);
                break;
            case R.id.textb:
                new DatePickerDialog(Main4Activity.this,dateset,yeari,monthi,dayi).show();//달력 띄우기
                break;
            case R.id.timeb:
                new TimePickerDialog(Main4Activity.this,timeset,houri,minutei,false).show();//시계띄우기
                break;
        }
    }
    DatePickerDialog.OnDateSetListener dateset=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {//달력이벤트처리
            yeari=year;
            monthi=month;
            dayi=dayOfMonth;
            updatedate();
        }
    };
    TimePickerDialog.OnTimeSetListener timeset=new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {//시간 이벤트처리
            houri=hourOfDay;
            minutei=minute;
            updatedate();
        }
    };
}
