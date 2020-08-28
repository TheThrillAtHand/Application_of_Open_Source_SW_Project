package com.nestnet.thethrillathand.reservation_rental.dangjin_glamping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.nestnet.thethrillathand.R;

public class DangjinGlampingMainActivity extends AppCompatActivity {

    ImageButton btn_toDanginGlam1, btn_toDanginGlam2, btn_toDanginGlam3, btn_toDanginCosmos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangin_glamping);

        btn_toDanginGlam1 = (ImageButton) findViewById(R.id.dangjinglam1);
        btn_toDanginGlam1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DangjinGlamping1Activity.class);
                startActivity(intent);
            }
        });

        btn_toDanginGlam2 = (ImageButton) findViewById(R.id.dangjinglam2);
        btn_toDanginGlam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DangjinGlamping2Activity.class);
                startActivity(intent);
            }
        });

        btn_toDanginGlam3 = (ImageButton) findViewById(R.id.dangjinglam3);
        btn_toDanginGlam3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DangjinGlamping3Activity.class);
                startActivity(intent);
            }
        });

        btn_toDanginCosmos = (ImageButton) findViewById(R.id.dangjincosmos);
        btn_toDanginCosmos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DangjinGlampingCosmosActivity.class);
                startActivity(intent);
            }
        });
    }

}