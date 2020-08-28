/*
    작성자 : 2018038019 최승혜
    설 명 :  Activity - 마이메뉴의 환경설정

*/



package com.example.thethrillathand;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.thethrillathand.Util.showToast;

public class configurationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        Button passwordReset = (Button) findViewById(R.id.passwordReset);

        passwordReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent passwordresetintent = new Intent(getApplicationContext(), PasswordResetActivity.class);
                startActivity(passwordresetintent);
            }
        });

        Switch notiSet = (Switch) findViewById(R.id.notiSet);
        notiSet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    showToast(configurationActivity.this, "알람 받기");
                } else {
                    showToast(configurationActivity.this, "알람 끄기");
                }
            }
        });

    }

}
