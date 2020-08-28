/*
    작성자 : 2018038019 최승혜
    설 명 :  예약 화면의 숙박 Frag (UI제작)

*/


package com.example.thethrillathand.reservation_rental;

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
import com.example.thethrillathand.reservation_rental.dangjin_glamping.DangjinGlampingMainActivity;
import com.example.thethrillathand.reservation_rental.leciel.LeCielMainActivity;
import com.example.thethrillathand.reservation_rental.marinpia.MarinPiaMainActivity;
import com.example.thethrillathand.reservation_rental.mongsan.MongsanMainActivity;
import com.example.thethrillathand.reservation_rental.poin.PoinMainAcitivity;

public class Frag_reservation_rental extends Fragment {

    Button rental_product1,rental_product2,rental_product3,rental_product4,rental_product5;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reservation_rental, container, false);

        rental_product1 = (Button) v.findViewById(R.id.product_rental);
        rental_product2 = (Button) v.findViewById(R.id.product_rental2);
        rental_product3 = (Button) v.findViewById(R.id.product_rental3);
        rental_product4 = (Button) v.findViewById(R.id.product_rental4);
        rental_product5 = (Button) v.findViewById(R.id.product_rental5);

        //클릭 이벤트
        rental_product1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent product = new Intent(getActivity(), PoinMainAcitivity.class);
                startActivity(product);
            }
        });

        rental_product2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent product = new Intent(getActivity(), LeCielMainActivity.class);
                startActivity(product);
            }
        });

        rental_product3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent product = new Intent(getActivity(), DangjinGlampingMainActivity.class);
                startActivity(product);
            }
        });

        rental_product4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent product = new Intent(getActivity(), MarinPiaMainActivity.class);
                startActivity(product);
            }
        });

        rental_product5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent product = new Intent(getActivity(), MongsanMainActivity.class);
                startActivity(product);
            }
        });

        return v;
    }
}
