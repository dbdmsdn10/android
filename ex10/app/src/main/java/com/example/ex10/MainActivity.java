package com.example.ex10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img1, img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = findViewById(R.id.imageView);
        img2 = findViewById(R.id.imageView2);
        registerForContextMenu(img1);
        registerForContextMenu(img2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()) {
            case R.id.imageView:
                menu.setHeaderTitle("자동차");
                menu.add(0, 0, 0, "중고");
                menu.add(0, 1, 0, "신상");
                menu.add(0, 2, 0, "외제");
                break;
            case R.id.imageView2:
                menu.setHeaderTitle("오토바이");
                menu.add(0, 3, 0, "중고");
                menu.add(0, 4, 0, "신상");
                menu.add(0, 5, 0, "외제");
                break;
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                img1.setImageResource(R.drawable.factory);
                break;
            case 1:
                img1.setImageResource(R.drawable.likedie);
                break;
            case 2:
                img1.setImageResource(R.drawable.guunmanduu);
                break;
            case 3:
                img2.setImageResource(R.drawable.udong);
                break;
            case 4:
                img2.setImageResource(R.drawable.zzamppong);
                break;
            case 5:
                img2.setImageResource(R.drawable.zzazng);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
