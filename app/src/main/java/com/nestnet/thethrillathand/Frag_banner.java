/*
    작성자 : 2018038019 최승혜
    설 명 :  홈 화면의 슬라이드 배너의 메인 Frag

*/



package com.nestnet.thethrillathand;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class Frag_banner extends Fragment {

    private Frag_banner_first banner1;
    private Frag_banner_second banner2;
    private Frag_banner_third banner3;
    ViewPager banner;
    public Frag_banner() {

    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_banner, container, false);

        banner1 = new Frag_banner_first();
        banner2 = new Frag_banner_second();
        banner3 = new Frag_banner_third();

        banner = (ViewPager) v.findViewById(R.id.banner);
        banner.setAdapter(new PagerAdapter(getChildFragmentManager()));
        banner.setCurrentItem(0);
        return v;


    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
    private class PagerAdapter extends FragmentPagerAdapter {
        public PagerAdapter(FragmentManager fm){
            super(fm);
            getItem(0);
        }
        public Fragment getItem(int position){
            if(position==0)
            {
                return banner1;

            }else if (position==1){
                return banner2;
            }
            else
                return banner3;
        }
        public int getCount(){
            return 3;
        }

    }

}
