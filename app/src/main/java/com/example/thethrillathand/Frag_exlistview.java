package com.example.thethrillathand;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



public class Frag_exlistview extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listview, container, false);
        ExpandableListView mListView;
        mListView = (ExpandableListView) v.findViewById(R.id.exListView_home);
        ArrayList<myGroup> DataList = new ArrayList<myGroup>();
        myGroup temp = new myGroup("낚시 정보");
        temp.child.add("낚시 매듭");
        temp.child.add("한반도 대표 어종");
        temp.child.add("해도 보는 법");
        DataList.add(temp);
        temp = new myGroup("-");
        temp.child.add("-");
        DataList.add(temp);
        temp = new myGroup("-");
        temp.child.add("-");

        DataList.add(temp);

        final ExpandAdapter adapter = new ExpandAdapter(getActivity(),R.layout.exlistview_group,R.layout.exlistview_child,DataList);
        mListView.setAdapter(adapter);

        mListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                final String selected = (String) adapter.getChild(i,i1);

                if(selected == "낚시 매듭")
                {
                    Intent intent = new Intent(getActivity(),SOSActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });
        return v;
    }
}