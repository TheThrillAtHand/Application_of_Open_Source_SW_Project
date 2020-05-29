package com.example.thethrillathand;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private Frag_Home fragmentSearch = new Frag_Home();
    private Frag_fishing fragmentCamera = new Frag_fishing();
    private Frag_weather fragmentCall = new Frag_weather();
    private Frag_reservation fragmentReservation = new Frag_reservation();
    private Frag_Mymenu fragmentMyMenu = new Frag_Mymenu();
    //private Frag_sos fragmentsos = new Frag_sos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragmentSearch).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch(menuItem.getItemId())
            {
                case R.id.홈:
                    transaction.replace(R.id.frameLayout, fragmentSearch).commitAllowingStateLoss();

                    break;
                case R.id.낚시정보:
                    transaction.replace(R.id.frameLayout, fragmentCamera).commitAllowingStateLoss();
                    break;
                case R.id.날씨정보:
                    transaction.replace(R.id.frameLayout, fragmentCall).commitAllowingStateLoss();
                    break;
                case R.id.예약:
                    transaction.replace(R.id.frameLayout, fragmentReservation).commitAllowingStateLoss();
                    break;
                case R.id.마이메뉴:
                    transaction.replace(R.id.frameLayout, fragmentMyMenu).commitAllowingStateLoss();
                    break;
//                case R.id.SOS:
//                    transaction.replace(R.id.frameLayout, fragmentMyMenu).commitAllowingStateLoss();
//                    break;
            }
            return true;
        }
    }

}
