/*
 작성자 : 이선명
 르시엘 펜션 정보페이지(르시엘 펜션 상세보기 클릭시 현재 페이지로 이동)
*/
package com.example.thethrillathand.reservation_rental;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thethrillathand.R;

public class LeCielActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_le_ciel);

        ImageButton btn_toLeVip1 = (ImageButton) findViewById(R.id.cilevip1);
        btn_toLeVip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LeCielVip1Activity.class);
                startActivity(intent);
            }
        });

        ImageButton btn_toLeVip2 = (ImageButton) findViewById(R.id.cilevip2);
        btn_toLeVip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LeCielVip2Activity.class);
                startActivity(intent);
            }
        });

        ImageButton btn_toLeGrand = (ImageButton) findViewById(R.id.cilegrand);
        btn_toLeGrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LeCielGrandActivity.class);
                startActivity(intent);
            }
        });
    }
}
