/*
    작성자 : 2018038019 최승혜
    설 명 :  예약 화면의 선박 Frag (UI제작)

*/


package com.example.thethrillathand.reservation_ship;

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

public class Frag_reservation_ship extends Fragment {

    Button ship_product1,ship_product2,ship_product3,ship_product4,ship_product5;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reservation_ship, container, false);

        ship_product1 = (Button) v.findViewById(R.id.btn_toAnsan);
        ship_product2 = (Button) v.findViewById(R.id.btn_toJoy);
        ship_product3 = (Button) v.findViewById(R.id.btn_toSinnara);
        ship_product4 = (Button) v.findViewById(R.id.btn_toBigstar);
        ship_product5 = (Button) v.findViewById(R.id.btn_toAce);

        //클릭 이벤트
        ship_product1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent product = new Intent(getActivity(), ShipAnsanActivity.class);
                startActivity(product);
            }
        });

        ship_product2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent product = new Intent(getActivity(), ShipJoyActivity.class);
                startActivity(product);
            }
        });

        ship_product3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent product = new Intent(getActivity(), ShipSinnaraActivity.class);
                startActivity(product);
            }
        });

        ship_product4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent product = new Intent(getActivity(), ShipBigstarActivity.class);
                startActivity(product);
            }
        });

        ship_product5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent product = new Intent(getActivity(), ShipAceActivity.class);
                startActivity(product);
            }
        });

        return v;
    }
}
