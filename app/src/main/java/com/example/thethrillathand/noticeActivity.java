package com.example.thethrillathand;

import android.os.Bundle;
import android.view.Display;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class noticeActivity extends AppCompatActivity {

    private ExpandableListView listView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);


        ArrayList<myGroup> DataList = new ArrayList<myGroup>();
        listView = (ExpandableListView)findViewById(R.id.exListView_notice);
        myGroup temp = new myGroup("버전 업데이트 안내");
        temp.child.add("0.11ver 업그레이드 완료\n * UI 개선\n * 슬라이드 배너 추가 \n * expandablelistview 구현");
        DataList.add(temp);




        ExpandAdapter adapter = new ExpandAdapter(getApplicationContext(),R.layout.exlistview_group,R.layout.exlistview_child,DataList);
        listView.setAdapter(adapter);
    }
}




