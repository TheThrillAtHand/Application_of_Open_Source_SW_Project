// 작성자 : 2016039020 정경창
// 설  명 : 해상 특보를 보여주는 클래스

package com.example.thethrillathand;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.InputStream;
import java.net.URL;

public class Frag_weather_news extends Fragment {
    ImageView imageView;
    String imageUrl;

    Frag_weather_news() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable

    Handler handler1 = new Handler();  // 외부쓰레드 에서 메인 UI화면을 그릴때 사용
    Handler handler2 = new Handler();  // 외부쓰레드 에서 메인 UI화면을 그릴때 사용

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_weather_news,container,false);
        WebView mWebView;

        mWebView = (WebView) v.findViewById(R.id.water);
        mWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // 화면 비율
        webSettings.setUseWideViewPort(true);       // wide viewport를 사용하도록 설정
        webSettings.setLoadWithOverviewMode(true);  // 컨텐츠가 웹뷰보다 클 경우 스크린 크기에 맞게 조정
        // 웹뷰 멀티 터치 가능하게 (줌기능)
        webSettings.setBuiltInZoomControls(true);   // 줌 아이콘 사용
        webSettings.setSupportZoom(true);
        mWebView.loadUrl("https://www.badatime.com/");
        return v;


//        View v = inflater.inflate(R.layout.fragment_weather_news,container,false);
//
//        WebView mWebView = (WebView) v.findViewById(R.id.water);
//        WebSettings webSettings = mWebView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
//        webSettings.setAllowFileAccessFromFileURLs(true);
//        webSettings.setSaveFormData(false);
//        webSettings.setSavePassword(false);
//        webSettings.setUseWideViewPort(true);
//        webSettings.setSupportMultipleWindows(true);
//        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//        mWebView.setWebViewClient(new WebViewClient());
//        mWebView.setWebChromeClient(new WebChromeClient());
//
//        mWebView.loadUrl("http://www.khoa.go.kr/swtc/main.do#secondFloor");
//        return v;
    }


}
