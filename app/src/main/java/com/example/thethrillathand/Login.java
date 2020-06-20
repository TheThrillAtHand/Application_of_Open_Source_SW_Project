package com.example.thethrillathand;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    private EditText IDEditText;
    private CheckBox saveCheckBox;

    //설정 정보 저장 객체
    private SharedPreferences mPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        IDEditText = (EditText) findViewById(R.id.ID);
        saveCheckBox = (CheckBox) findViewById(R.id.checkBox_save);
        // Preference 객체 초기화
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //저장될 ID불러와 복원
        Boolean isChecked = mPreferences.getBoolean("save",false);
        saveCheckBox.setChecked(isChecked);
        if(isChecked){
            String ID = mPreferences.getString("id","");
            IDEditText.setText(ID);
        }

    }
    protected void onDestroy(){
        super.onDestroy();
        // SharedPreferences의 수정 가능한 객체 얻기
        SharedPreferences.Editor editor = mPreferences.edit();
        //저장할 데이터
        editor.putBoolean("save",saveCheckBox.isChecked());
        editor.putString("email",IDEditText.getText().toString());
        //저장
        editor.apply();
    }
}
