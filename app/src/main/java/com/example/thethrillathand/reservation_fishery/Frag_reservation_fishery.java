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
import com.example.thethrillathand.reservation_fishery.FisheryDangjinActivity;
import com.example.thethrillathand.reservation_fishery.FisheryDonghaeActivity;
import com.example.thethrillathand.reservation_fishery.FisheryGumiActivity;

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
        return v;
    }
}
