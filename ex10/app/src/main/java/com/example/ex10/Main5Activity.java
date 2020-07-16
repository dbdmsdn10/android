package com.example.ex10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        final ArrayAdapter ad = ArrayAdapter.createFromResource(this, R.array.fruit, android.R.layout.simple_spinner_dropdown_item);
        ad.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);

        final ArrayAdapter ad2 = ArrayAdapter.createFromResource(this, R.array.car, android.R.layout.simple_spinner_item);
        ad2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(ad);
        final int[] aa = {spinner.getSelectedItemPosition()};

        final Spinner spinner2 = findViewById(R.id.spinner2);
        spinner2.setAdapter(ad2);
        final int[] bb = {spinner2.getSelectedItemPosition()};

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (aa[0] != position) {
                    Toast.makeText(Main5Activity.this, ad.getItem(position) + " 는맛있다", Toast.LENGTH_SHORT).show();
                }
                aa[0] = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (bb[0] != position) {
                    Toast.makeText(Main5Activity.this, ad2.getItem(position) + " 하고싶다", Toast.LENGTH_SHORT).show();
                }
                bb[0] = position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
