/*
    작성자 : 2018038019 최승혜
    설 명 :  환경설정의 공지사항 Activity에 해당하는 코드
            expandable listview를 이용하여 구현
*/

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
        temp.child.add( "\n0.6 ver 업데이트 \n 로그인, 회원가입, 게시판 기능 추가" +
                "\n0.5 ver 업데이트 \n 예약 기능 추가" +
                "\n0.4 ver 업데이트\n UI 수정\n 정보 업데이트" +
                "\n0.3 ver 업데이트 \n 날씨 보기 기능 추가" +
                "\n0.2 ver 업데이트 \n UI 개선"+
                "\n0.1 ver 업데이트 \n UI 구현\n");
        DataList.add(temp);

        temp = new myGroup("무창포 광어 다운샷 낚시대회 안내");
        temp.child.add( "\n  ● 대회일시 : 2020년 6월 21일 일요일 (7물)"+
                "\n\n  ● 대회 장소 : 충남 보령시 무창포 항 일원"+
                "\n\n  ● 참가인원 : 255명 + 한국낚시방송 “좌충우돌 낚시소풍” 방송촬영자 6명 포함 (총261명)"+
                "\n\n  ● 대상어 : 광어 한 마리 최대길이" +
                "\n\n  ● 상세 안내는 홈페이지를 참고하세요!\n   http://www.mattanza.co.kr/");
        DataList.add(temp);
        temp = new myGroup("초대 이벤트 당첨자 안내");
        temp.child.add("\n\n   ● 지난 초대 이벤트의 당첨자를 공지합니다!"+
                "\n\n      ps***** 박*진"+
                "\n\n      ls**** 이*명" +
                "\n\n   기간 내로 메일 회신 해주시길 바랍니다!\n");
        DataList.add(temp);




        ExpandAdapter adapter = new ExpandAdapter(getApplicationContext(),R.layout.exlistview_group,R.layout.exlistview_child,DataList);
        listView.setAdapter(adapter);
    }
}




