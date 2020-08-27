/*
    작성자 : 2018038019 최승혜
    설 명 :  예약 화면의 낚시터 Frag (UI제작)

*/



package com.example.thethrillathand.reservation_fishery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.thethrillathand.R;

public class Frag_reservation_fishery extends Fragment {

    Button product1, product2, product3, product4, product5;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reservation_fishery, container, false);

        product1 = (Button) v.findViewById(R.id.product_fishery1);
        product2 = (Button) v.findViewById(R.id.product_fishery2);
        product3 = (Button) v.findViewById(R.id.product_fishery3);
        product4 = (Button) v.findViewById(R.id.product_fishery4);
        product5 = (Button) v.findViewById(R.id.product_fishery5);

        //클릭 이벤트
        product1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent product = new Intent(getActivity(), FisheryDonghaeActivity.class);
                startActivity(product);
            }
        });

        //클릭 이벤트
        product2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent product = new Intent(getActivity(), FisheryDangjinActivity.class);
                startActivity(product);
            }
        });

        product3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent product = new Intent(getActivity(), FisheryGumiActivity.class);
                startActivity(product);
            }
        });

        product4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent product = new Intent(getActivity(), FisheryChungjuActivity.class);
                startActivity(product);
            }
        });

        product5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent product = new Intent(getActivity(), FisheryGapyungActivity.class);
                startActivity(product);
            }
        });
        return v;
    }
}
