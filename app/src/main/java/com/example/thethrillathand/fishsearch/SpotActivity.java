package com.example.thethrillathand.fishsearch;

import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;

import com.example.thethrillathand.R;

import androidx.appcompat.app.AppCompatActivity;


public class SpotActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot);

        Intent intent = getIntent(); /*데이터 수신*/
        TextView fish = (TextView) findViewById(R.id.fish_name);

        String fish_name = intent.getStringExtra("name");

        fish.setText(fish_name+" 추천 Point");

    }
}



