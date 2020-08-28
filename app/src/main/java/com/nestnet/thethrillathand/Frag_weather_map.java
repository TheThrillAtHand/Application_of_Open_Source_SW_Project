// 작성자 : 2016039020 정경창
// 설  명 : Map(지도보기)를 구현한 클래스

package com.nestnet.thethrillathand;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag_weather_map extends Fragment {
    public ToggleButton toggleButton;
    public WebView mWebView;
    public WebSettings mWebSettings;
    Frag_weather_map() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_weather_map,container,false);

        toggleButton = (ToggleButton) v.findViewById(R.id.toggleButton);
        mWebView=(WebView) v.findViewById(R.id.Windy);
        mWebView.setWebViewClient(new WebViewClient());
        mWebSettings = mWebView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);

//        // 화면 비율
//        mWebSettings.setUseWideViewPort(true);       // wide viewport를 사용하도록 설정
//        mWebSettings.setLoadWithOverviewMode(true);  // 컨텐츠가 웹뷰보다 클 경우 스크린 크기에 맞게 조정
        // 웹뷰 멀티 터치 가능하게 (줌기능)
        mWebSettings.setBuiltInZoomControls(true);   // 줌 아이콘 사용
        mWebSettings.setSupportZoom(true);

        mWebView.loadUrl("https://www.windy.com/?36.571,128.546,7,m:eF7ajHL");


        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mWebView.loadUrl("https://www.weather.go.kr/w/ocean/now/buoy.do");
                }else{
                    mWebView.loadUrl("https://www.windy.com/?36.571,128.546,7,m:eF7ajHL");
                }
            }
        });




        return v;
    }

    // 보류
//    public void onToggleClicked(View v){
//        boolean on =((ToggleButton) v).isChecked();
//
//        if(on){
//            WebView mWebView;
//            WebSettings mWebSettings;
//            mWebView = (WebView) v.findViewById(R.id.Windy);
//            mWebView.setWebViewClient(new WebViewClient());
//            mWebSettings = mWebView.getSettings();
//            mWebSettings.setJavaScriptEnabled(true);
//
//            mWebView.loadUrl("https://www.windy.com/?36.571,128.546,7,m:eF7ajHL");
//
//        }
//        else{
//            WebView mWebView;
//            WebSettings mWebSettings;
//            mWebView = (WebView) v.findViewById(R.id.Windy);
//            mWebView.setWebViewClient(new WebViewClient());
//            mWebSettings = mWebView.getSettings();
//            mWebSettings.setJavaScriptEnabled(true);
//
//
//        }
//    }
}
