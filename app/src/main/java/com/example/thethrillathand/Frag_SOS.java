/*
    작성자 : 2018038019 최승혜
    설 명 :  SOS Frag (UI제작)
            이미지 터치 시 SOS Activity로 이동
*/

package com.example.thethrillathand;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class Frag_SOS extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Frag_SOS() {

    }


    public static Frag_SOS newInstance(String param1, String param2) {
        Frag_SOS fragment = new Frag_SOS();
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
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_s_o_s, container, false);
        LinearLayout sos = (LinearLayout) v.findViewById(R.id.button_sos);


        sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sosintent = new Intent(getActivity(), SOSActivity.class);
                startActivity(sosintent);
            }
        });


        return v;
    }
}





