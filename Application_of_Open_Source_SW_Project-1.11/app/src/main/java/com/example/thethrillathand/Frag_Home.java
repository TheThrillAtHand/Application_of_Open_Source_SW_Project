/*
    작성자 : 2018038019 최승혜
    설 명 :  홈 화면 Frag (UI제작)
            Search 버튼 클릭 시 어종 검색 Activity로 이동
            추천 point의 이미지 클릭 시 해당 포인트의 예약 상세 페이지로 이동
*/


package com.example.thethrillathand;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.thethrillathand.fishsearch.SearchActivity;
import com.example.thethrillathand.reservation_fishery.FisheryDangjinActivity;
import com.example.thethrillathand.reservation_fishery.FisheryDonghaeActivity;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Frag_Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frag_Home extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Frag_Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Frag_Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Frag_Home newInstance(String param1, String param2) {
        Frag_Home fragment = new Frag_Home();
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
        View v = inflater.inflate(R.layout.fragment_frag__home,container,false);

        // 지역의 날씨정보 받아오기

        // 날씨 맑음 or 흐림 OR 비 X 지역 추천

        // 지도에서 포인트 찍어 보여주기 또는 ㅇ그냥 장소만 알려주기



        ImageView point1 = (ImageView) v.findViewById(R.id.point1);
        ImageView point2 = (ImageView) v.findViewById(R.id.point2);
        Button search = (Button) v.findViewById(R.id.button_search);

        getFragmentManager().beginTransaction().add(R.id.home_banner, new Frag_banner()).commit();
        getFragmentManager().beginTransaction().add(R.id.home_list, new Frag_exlistview()).commit();

        point1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent point = new Intent(getActivity(), FisheryDangjinActivity.class);
                startActivity(point);
            }
        });
        point2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent point = new Intent(getActivity(), FisheryDonghaeActivity.class);
                startActivity(point);
            }
        });
        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent search = new Intent(getActivity(), SearchActivity.class);
                startActivity(search);
            }
        });

        return v;
    }
}
