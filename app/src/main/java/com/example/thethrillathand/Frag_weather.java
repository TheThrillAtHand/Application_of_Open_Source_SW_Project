package com.example.thethrillathand;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Frag_weather#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frag_weather extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Frag_weather() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Frag_weather.
     */
    // TODO: Rename and change types and number of parameters
    public static Frag_weather newInstance(String param1, String param2) {
        Frag_weather fragment = new Frag_weather();
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
        View v = inflater.inflate(R.layout.fragment_frag_weather, container, false);
        //Button windy = (Button) v.findViewById(R.id.live_windy);
        Button map = (Button) v.findViewById(R.id.button_map);
        Button local = (Button) v.findViewById(R.id.button_local);
        Button news = (Button) v.findViewById(R.id.button_news);
        getFragmentManager().beginTransaction().add(R.id.weather_child, new Frag_weather_map()).commit();

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.weather_child, new Frag_weather_map()).commit();
            }
        });
//        local.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getFragmentManager().beginTransaction().replace(R.id.weather_child, new Frag_weather_local()).commit();
//            }
//        });
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.weather_child, new Frag_weather_news()).commit();
            }
        });

        local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent local_weather = new Intent(getActivity(), WeatherActivity.class);
                startActivity(local_weather);
            }
        });




        return v;
    }

}
