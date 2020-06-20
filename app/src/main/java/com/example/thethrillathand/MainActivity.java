package com.example.thethrillathand;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity"; // 추가

//    private FragmentManager fragmentManager = getSupportFragmentManager();
//
//    private Frag_Home fragmentHome = new Frag_Home();
//    private Frag_fishing fragmentFishing = new Frag_fishing();
//    private Frag_weather fragmentWeather = new Frag_weather();
//    private Frag_reservation fragmentReservation = new Frag_reservation();
//    private Frag_board fragmentBoard = new Frag_board();
//    //    private Frag_Mymenu fragmentMyMenu = new Frag_Mymenu();
//    private Frag_SOS fragmentSOS = new Frag_SOS();

    // 추가
    @Override
    protected void onResume() {
        super.onResume();
    }

    // 추가
    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                init();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init(); // 추가

//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.main, fragmentHome).commitAllowingStateLoss();
    }

    private void init(){
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser == null) {
            myStartActivity(SignUpActivity.class);
        }
        else {
            DocumentReference documentReference = FirebaseFirestore.getInstance().collection("users").document(firebaseUser.getUid());
            documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document != null) {
                            if (document.exists()) {
                                Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                            } else {
                                Log.d(TAG, "No such document");
                                myStartActivity(MemberInitActivity.class);
                            }
                        }
                    } else {
                        Log.d(TAG, "get failed with ", task.getException());
                    }
                }
            });

            Frag_Home fragmentHome = new Frag_Home();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragmentHome)
                    .commit();

            BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.home:
                            // BoardFragment boardFragment = new BoardFragment();
                            Frag_Home fragmentHome = new Frag_Home();
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.container, fragmentHome)
                                    .commit();
                            return true;
                        case R.id.weather:
                            Frag_weather fragmentWeather = new Frag_weather();
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.container, fragmentWeather)
                                    .commit();
                            return true;
                        case R.id.board:
                            //Frag_board fragmentBoard = new Frag_board();
                            BoardFragment boardFragment = new BoardFragment();
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.container, boardFragment)
                                    .commit();
                            return true;
                        case R.id.reservation:
                            Frag_reservation fragmentReservation = new Frag_reservation();
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.container, fragmentReservation)
                                    .commit();
                            return true;
                        case R.id.sosMenu:
                            Frag_SOS fragmentSOS = new Frag_SOS();
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.container, fragmentSOS)
                                    .commit();
                            return true;

                    }
                    return false;
                }
            });


        }
    }

    private void myStartActivity(Class c) {
        Intent intent = new Intent(this, c);
        startActivityForResult(intent, 1);
    }





//
//    public void homeclick(View v) {
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.main, fragmentHome).commitAllowingStateLoss();
//
//    }
//    public void weatherclick(View v) {
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.main, fragmentWeather).commitAllowingStateLoss();
//
//    }
//    public void reservationclick(View v) {
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.main, fragmentReservation).commitAllowingStateLoss();
//
//    }
//    public void sosclick(View v) {
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.main, fragmentSOS).commitAllowingStateLoss();
//
//    }
//    public void boardclick(View v) {
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.main, fragmentBoard).commitAllowingStateLoss();
//
//    }
//    public void mymenuclick(View v) {
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.main, fragmentFishing).commitAllowingStateLoss();
//
//    }
//    public void black(int i, String v) {
//
//
//    }




}
