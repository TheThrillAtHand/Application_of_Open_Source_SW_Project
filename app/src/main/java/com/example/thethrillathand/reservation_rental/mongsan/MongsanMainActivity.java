package com.example.thethrillathand.reservation_rental.mongsan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thethrillathand.R;

public class MongsanMainActivity extends AppCompatActivity {

    ImageButton btn_toMongsan101, btn_toMongsan201, btn_toMongsan202;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mongsan_main);

        btn_toMongsan101 = (ImageButton) findViewById(R.id.mongsan101);
        btn_toMongsan101.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Mongsan101Activity.class);
                startActivity(intent);
            }
        });

        btn_toMongsan201 = (ImageButton) findViewById(R.id.mongsan201);
        btn_toMongsan201.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Mongsan201Activity.class);
                startActivity(intent);
            }
        });

        btn_toMongsan202 = (ImageButton) findViewById(R.id.mongsan202);
        btn_toMongsan202.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Mongsan202Activity.class);
                startActivity(intent);
            }
        });
    }

}