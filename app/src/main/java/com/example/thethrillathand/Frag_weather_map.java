// 작성자 : 2016039020 정경창
// 설  명 : 기상청 해상특보를 보여주는 클래스

package com.example.thethrillathand;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag_weather_map extends Fragment {

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
        WebView mWebView;
        WebSettings mWebSettings;
        mWebView = (WebView) v.findViewById(R.id.Windy);
        mWebView.setWebViewClient(new WebViewClient());
        mWebSettings = mWebView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);

        mWebView.loadUrl("https://www.windy.com/?36.571,128.546,7,m:eF7ajHL");

        WebView mWebView2;
        WebSettings mWebSettings2;
        mWebView2 = (WebView) v.findViewById(R.id.SeaWeather);
        mWebView2.setWebViewClient(new WebViewClient());
        mWebSettings2 = mWebView2.getSettings();
        mWebSettings2.setJavaScriptEnabled(true);

        mWebView2.loadUrl("https://www.weather.go.kr/w/ocean/now/buoy.do");

        return v;
    }
}
