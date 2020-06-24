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

        //Thread t = new Thread(Runnable 객체를 만든다);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {    // 오래 거릴 작업을 구현한다
                // TODO Auto-generated method stub
                try{
                    final ImageView iv = (ImageView) getView().findViewById(R.id.Special_new);
                    URL url = new URL("https://www.weather.go.kr/repositary/image/wrn/img/KTKO50_202006201030_108_61.png");
                    InputStream is = url.openStream();
                    final Bitmap bm = BitmapFactory.decodeStream(is);
                    handler1.post(new Runnable() {

                        @Override
                        public void run() {  // 화면에 그려줄 작업
                            iv.setImageBitmap(bm);
                        }
                    });
                    iv.setImageBitmap(bm); //비트맵 객체로 보여주기
                } catch(Exception e){

                }

            }
        });

        t.start();
//        Thread t = new Thread(Runnable 객체를 만든다);
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {    // 오래 거릴 작업을 구현한다
                // TODO Auto-generated method stub
                try{
                    final ImageView iv2 = (ImageView) getView().findViewById(R.id.Special_new2);
                    URL url2 = new URL("https://www.weather.go.kr/repositary/image/wrn/img/KTKO50_202006201030_108_61b.png");
                    InputStream is2 = url2.openStream();
                    final Bitmap bm2 = BitmapFactory.decodeStream(is2);
                    handler2.post(new Runnable() {

                        @Override
                        public void run() {  // 화면에 그려줄 작업
                            iv2.setImageBitmap(bm2);
                        }
                    });
                    iv2.setImageBitmap(bm2); //비트맵 객체로 보여주기
                } catch(Exception e){

                }

            }
        });

        t2.start();


        return v;
    }


}
