package com.example.thethrillathand;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.thethrillathand.reservation_fishery.Frag_reservation_fishery;
import com.example.thethrillathand.reservation_rental.Frag_reservation_rental;
import com.example.thethrillathand.reservation_ship.Frag_reservation_ship;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Frag_reservation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frag_reservation extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Frag_reservation() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Frag_reservation.
     */
    // TODO: Rename and change types and number of parameters
    public static Frag_reservation newInstance(String param1, String param2) {
        Frag_reservation fragment = new Frag_reservation();
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
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_frag_reservation, container, false);

        //처음 childfragment 지정
        getFragmentManager().beginTransaction().add(R.id.child_fragment, new Frag_reservation_fishery()).commit();

        //하위버튼
        LinearLayout subButton1 = (LinearLayout) v.findViewById(R.id.reservation_fishery);
        LinearLayout subButton2 = (LinearLayout) v.findViewById(R.id.reservation_ship);
        LinearLayout subButton3 = (LinearLayout) v.findViewById(R.id.reservation_rental);

        //클릭 이벤트
        subButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.child_fragment, new Frag_reservation_fishery()).commit();
            }
        });
        subButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.child_fragment, new Frag_reservation_ship()).commit();

            }
        });
        subButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.child_fragment, new Frag_reservation_rental()).commit();

            }
        });

        return v;


       // return inflater.inflate(R.layout.fragment_frag_reservation, container, false);
    }
}
