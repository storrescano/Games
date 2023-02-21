package com.example.lesson8menu;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson8menu.game2048test.SplashScreen;
import com.example.lesson8menu.lightout.StartLightOut;

public class SelectorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectgame);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Select:
                Toast.makeText(this, "1", Toast.LENGTH_LONG ).show();
                return true;
            case R.id.Score:
                Toast.makeText(this, "2", Toast.LENGTH_LONG ).show();
                return true;
            case R.id.Settings:
                Toast.makeText(this, "3", Toast.LENGTH_LONG ).show();
                return true;
            case R.id.help:
                Toast.makeText(this, "4", Toast.LENGTH_LONG ).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @SuppressLint("NonConstantResourceId")
    public void changeActivity(View view) {
        Intent intent;
        System.err.println(view.getId());
        switch (view.getId()){
            case R.id.imageButton3:
                intent = new Intent(SelectorActivity.this, StartLightOut.class);
                startActivity(intent);
                break;
            case R.id.imageButton4:
                intent = new Intent(SelectorActivity.this, SplashScreen.class);
                startActivity(intent);
                break;
        }
    }
}