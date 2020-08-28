/*
    작성자 : 2018038019 최승혜
    설 명 :  홈 화면 Frag (UI제작)
            Search 버튼 클릭 시 어종 검색 Activity로 이동
            추천 point의 이미지 클릭 시 해당 포인트의 예약 상세 페이지로 이동
*/


package com.nestnet.thethrillathand;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.nestnet.thethrillathand.fishsearch.SearchActivity;
import com.nestnet.thethrillathand.reservation_fishery.FisheryChungjuActivity;
import com.nestnet.thethrillathand.reservation_fishery.FisheryDangjinActivity;
import com.nestnet.thethrillathand.reservation_fishery.FisheryDonghaeActivity;
import com.nestnet.thethrillathand.reservation_fishery.FisheryGapyungActivity;
import com.nestnet.thethrillathand.reservation_fishery.FisheryGumiActivity;
import com.nestnet.thethrillathand.reservation_ship.ShipAnsanActivity;
import com.nestnet.thethrillathand.reservation_ship.ShipJoyActivity;
import com.nestnet.thethrillathand.reservation_ship.ShipSinnaraActivity;

import java.util.Random;


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

        final Class[] activity = new Class[]{FisheryDangjinActivity.class,FisheryDonghaeActivity.class,FisheryGumiActivity.class,FisheryChungjuActivity.class,FisheryGapyungActivity.class,ShipAnsanActivity.class, ShipJoyActivity.class, ShipSinnaraActivity.class};
        String ClassName[] ={"당진 낚시터","동해 낚시터","구미 낚시터","청주 낚시터","가평 낚시터","안산 1호","조이호","신나라 1호","빅스타호","에이스호"};
        String ClassDscript[] = {"충청남도 당진시","강원도 동해시","경상북도 구미시","충청북도 청주시","경기도 가평시","경기도 시흥시 정왕동","전라남도 여수시 신월5길","충남 서천군 서면","경기도 평택시","충남 보령시"};
        int[] ImageName = {R.drawable.dangjin,R.drawable.donghae,R.drawable.gumi,R.drawable.chungjufishery,R.drawable.gapyungfishery,R.drawable.ansan,R.drawable.joy,R.drawable.sinnara,R.drawable.bigstar,R.drawable.ace};
        Random r = new Random();

        int Random_1 = r.nextInt(9);
        int Random_2 = r.nextInt(9);
        if (Random_1 == Random_2){
            Random_2--;
        }
        final int Point_1 = Random_1;
        final int Point_2 = Random_2;

        ImageView point1 = (ImageView) v.findViewById(R.id.point1);
        point1.setImageResource(ImageName[Point_1]);
        ImageView point2 = (ImageView) v.findViewById(R.id.point2);
        point2.setImageResource(ImageName[Point_2]);

        Button search = (Button) v.findViewById(R.id.button_search);

        getFragmentManager().beginTransaction().add(R.id.home_banner, new Frag_banner()).commit();
        getFragmentManager().beginTransaction().add(R.id.home_list, new Frag_exlistview()).commit();

        TextView Point1_Name = (TextView) v.findViewById(R.id.point1_Name);
        Point1_Name.setText(ClassName[Point_1]);
        TextView Point1_Area = (TextView) v.findViewById(R.id.point1_Area);
        Point1_Area.setText(ClassDscript[Point_1]);
        TextView Point2_Name = (TextView) v.findViewById(R.id.point2_Name);
        Point2_Name.setText(ClassName[Point_2]);
        TextView Point2_Area = (TextView) v.findViewById(R.id.point2_Area);
        Point2_Area.setText(ClassDscript[Point_2]);


        // 홈 오늘의 추천 Point
        point1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent point = new Intent(getActivity(), activity[Point_1]);
                startActivity(point);
            }
        });
        point2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent point = new Intent(getActivity(), activity[Point_2]);
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
