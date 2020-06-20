
/*
    작성자 : 2018038019 최승혜
    설 명 : 어종을 검색 했을 시의 결과를 출력하는 Activity에 해당하는 코드

*/



package com.example.thethrillathand.fishsearch;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thethrillathand.R;


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



