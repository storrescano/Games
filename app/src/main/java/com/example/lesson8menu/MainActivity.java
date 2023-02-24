package com.example.lesson8menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lesson8menu.game2048test.ScoreManagement;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView menuList = findViewById(R.id.list);
        menuList.setClickable(true);

        String[] items = {getResources().getString(R.string.menu_item_play),
                getResources().getString(R.string.menu_item_scores),
                getResources().getString(R.string.menu_item_help)};

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, R.layout.list, items);

        menuList.setAdapter(adapt);

        menuList.setOnItemClickListener((adapterView, view, position, id) -> {
            Intent intent;
            switch (position) {
                case 0:
                    intent = new Intent(MainActivity.this, SelectorActivity.class);
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(MainActivity.this, ScoreManagement.class);
                    startActivity(intent);
                    break;
                case 2:
                    Toast.makeText(MainActivity.this, "4", Toast.LENGTH_SHORT).show();
                    break;
            }
        });
    }
}