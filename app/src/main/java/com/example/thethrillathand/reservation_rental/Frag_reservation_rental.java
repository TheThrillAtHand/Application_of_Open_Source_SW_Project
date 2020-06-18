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
import com.example.thethrillathand.reservation_rental.LeCielActivity;
import com.example.thethrillathand.reservation_rental.PoinAcitivity;

public class Frag_reservation_rental extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reservation_rental, container, false);

        Button rental_product1 = (Button) v.findViewById(R.id.product_rental);
        Button rental_product2 = (Button) v.findViewById(R.id.product_rental2);

        //클릭 이벤트
        rental_product1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent product = new Intent(getActivity(), PoinAcitivity.class);
                startActivity(product);
            }
        });

        rental_product2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent product = new Intent(getActivity(), LeCielActivity.class);
                startActivity(product);
            }
        });

        return v;
    }
}
