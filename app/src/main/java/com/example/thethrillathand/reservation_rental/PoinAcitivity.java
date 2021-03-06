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

public class PoinAcitivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poin);

        ImageButton btn_toPoinA1 = (ImageButton) findViewById(R.id.poin_a1);
        btn_toPoinA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PoinA1Activity.class);
                startActivity(intent);
            }
        });

        ImageButton btn_toPoinA2 = (ImageButton) findViewById(R.id.poin_a2);
        btn_toPoinA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PoinA2Activity.class);
                startActivity(intent);
            }
        });

        ImageButton btn_toPoinB1 = (ImageButton) findViewById(R.id.poin_b1);
        btn_toPoinB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PoinB1Activity.class);
                startActivity(intent);
            }
        });

        ImageButton btn_toPoinB2 = (ImageButton) findViewById(R.id.poin_b2);
        btn_toPoinB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PoinB2Activity.class);
                startActivity(intent);
            }
        });
    }
}
