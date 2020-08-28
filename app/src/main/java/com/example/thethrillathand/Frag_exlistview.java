/*
    작성자 : 2018038019 최승혜
    설 명 :  홈 화면의 Expandable list view에 해당하는 Frag

*/


package com.example.thethrillathand;


import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.thethrillathand.knot.clinch;
import com.example.thethrillathand.knot.outside;
import com.example.thethrillathand.knot.uninote;
import com.example.thethrillathand.knot.yarn;
import com.example.thethrillathand.preparations.bass;
import com.example.thethrillathand.preparations.hairtail;
import com.example.thethrillathand.preparations.rockfish;
import com.example.thethrillathand.preparations.sanddab;

import java.util.ArrayList;


public class Frag_exlistview extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listview, container, false);
        ExpandableListView mListView;



        Point size = new Point();
        Display mdp = getActivity().getWindowManager().getDefaultDisplay();
        mdp.getSize(size);
        int width  = size.x;

        mListView = (ExpandableListView) v.findViewById(R.id.exListView_home);
        ArrayList<myGroup> DataList = new ArrayList<myGroup>();
        myGroup temp = new myGroup("낚시 매듭");
        temp.child.add("유니 노트");
        temp.child.add("클린치 노트");
        temp.child.add("바깥 돌리기");
        temp.child.add("면사 매듭");
        DataList.add(temp);

        temp = new myGroup("어종별 채비");
        temp.child.add("갈치");
        temp.child.add("가자미");
        temp.child.add("농어");
        temp.child.add("우럭");
        DataList.add(temp);
        temp = new myGroup("수산물 포획 금지 안내 사이트");
        temp.child.add("포획 금지 안내 사이트 바로가기");
        DataList.add(temp);



        final ExpandAdapter adapter = new ExpandAdapter(getActivity(), R.layout.exlistview_group, R.layout.exlistview_child,DataList);
        mListView.setAdapter(adapter);


        mListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                final String selected = (String) adapter.getChild(i,i1);
                if(selected == "유니 노트")
                {

                    Intent intent = new Intent(getActivity(), uninote.class);
                    startActivity(intent);


                }
                if(selected == "클린치 노트")
                {
                    Intent intent = new Intent(getActivity(), clinch.class);
                    startActivity(intent);
                }
                if(selected == "바깥 돌리기")
                {
                    Intent intent = new Intent(getActivity(), outside.class);
                    startActivity(intent);
                }
                if(selected == "면사 매듭")
                {
                    Intent intent = new Intent(getActivity(), yarn.class);
                    startActivity(intent);
                }
                if(selected == "갈치")
                {
                    Intent intent = new Intent(getActivity(), hairtail.class);
                    startActivity(intent);
                }
                if(selected == "농어")
                {
                    Intent intent = new Intent(getActivity(), bass.class);
                    startActivity(intent);
                }
                if(selected == "우럭")
                {
                    Intent intent = new Intent(getActivity(), rockfish.class);
                    startActivity(intent);
                }
                if(selected == "가자미")
                {
                    Intent intent = new Intent(getActivity(), sanddab.class);
                    startActivity(intent);
                }
                if(selected == "수산물 포획 금지 안내 사이트")
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nifs.go.kr/lmo/scb/index2.lmo"));
                    startActivity(intent);
                }


                return false;
            }
        });

        mListView.setIndicatorBounds(width-80, width -30);
        return v;
    }
}