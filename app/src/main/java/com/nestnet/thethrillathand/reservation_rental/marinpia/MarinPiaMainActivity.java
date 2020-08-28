package com.nestnet.thethrillathand.reservation_rental.marinpia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.nestnet.thethrillathand.R;

public class MarinPiaMainActivity extends AppCompatActivity {

    ImageButton btn_toMarin101, btn_toMarin102, btn_toPia101, btn_toPia102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marin_pia_main);

        btn_toMarin101 = (ImageButton) findViewById(R.id.marin101);
        btn_toMarin101.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Marin101Activity.class);
                startActivity(intent);
            }
        });

        btn_toMarin102 = (ImageButton) findViewById(R.id.marin102);
        btn_toMarin102.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Marin102Activity.class);
                startActivity(intent);
            }
        });

        btn_toPia101 = (ImageButton) findViewById(R.id.pia101);
        btn_toPia101.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Pia101Activity.class);
                startActivity(intent);
            }
        });

        btn_toPia102 = (ImageButton) findViewById(R.id.pia102);
        btn_toPia102.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Pia102Activity.class);
                startActivity(intent);
            }
        });
    }
}