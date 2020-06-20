/*
    작성자 : 2018038019 최승혜
    설 명 :  환경설정의 공지사항 Activity에 해당하는 코드
            expandable listview를 이용하여 구현
*/




package com.example.thethrillathand;

import android.os.Bundle;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;

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
        temp.child.add("0.4 ver 업데이트\n UI 수정\n 정보 업데이트");
        DataList.add(temp);




        ExpandAdapter adapter = new ExpandAdapter(getApplicationContext(), R.layout.exlistview_group, R.layout.exlistview_child,DataList);
        listView.setAdapter(adapter);
    }
}




