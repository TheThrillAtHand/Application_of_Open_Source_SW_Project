/*
    작성자 : 2018038019 최승혜
    설 명 :  Expandable Listview 에서 사용되는 배열을 정의
*/




package com.example.thethrillathand;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class myGroup {
        public ArrayList<String> child;
        public String groupName;
        myGroup(String name){
            groupName = name;
            child = new ArrayList<String>();
}
    }



