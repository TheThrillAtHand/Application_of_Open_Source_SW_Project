/*
    작성자 : 2018038019 최승혜
    설 명 :  마이메뉴 Frag (UI제작)
            각 버튼을 클릭 하면 해당하는 Activity로 이동

*/

package com.example.thethrillathand;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class Frag_Mymenu extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public Frag_Mymenu() {

    }


    public static Frag_Mymenu newInstance(String param1, String param2) {
        Frag_Mymenu fragment = new Frag_Mymenu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_frag__mymenu, container, false);
        Button notice = (Button) v.findViewById(R.id.button_notice);
        Button configuration = (Button) v.findViewById(R.id.button_configuration);
        Button event = (Button) v.findViewById(R.id.button_event);

        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent noticeintent = new Intent(getActivity(), noticeActivity.class);
                startActivity(noticeintent);
            }
        });
        configuration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent conintent = new Intent(getActivity(), configurationActivity.class);
                startActivity(conintent);
            }
        });
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent eventintent = new Intent(getActivity(), eventActivity.class);
                startActivity(eventintent);
            }
        });


        return v;
    }
}
