/*
    작성자 : 2018038019 최승혜
    설 명 :  예약 화면의 낚시터 Frag (UI제작)

*/



package com.example.thethrillathand;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag_reservation_fishery extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reservation_fishery, container, false);
        Button product1 = (Button) v.findViewById(R.id.product_fishery1);
        Button product2 = (Button) v.findViewById(R.id.product_fishery2);
        Button product3 = (Button) v.findViewById(R.id.product_fishery3);
        //클릭 이벤트
        product1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent product = new Intent(getActivity(), DetailActivity.class);
                startActivity(product);
            }
        });

        //클릭 이벤트
        product2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent product = new Intent(getActivity(), DetailActivity.class);
                startActivity(product);
            }
        });

        product3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent product = new Intent(getActivity(), DetailActivity.class);
                startActivity(product);
            }
        });
        return v;
    }
}
