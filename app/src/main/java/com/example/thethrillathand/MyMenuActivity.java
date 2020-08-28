/*
    작성자 : 2018038019 최승혜
    설 명 :  Activity - 마이메뉴의 이벤트

*/

package com.example.thethrillathand;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thethrillathand.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MyMenuActivity extends AppCompatActivity {

    private static final String TAG = "MyMenuActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mymenu);

        Button notice = (Button) findViewById(R.id.button_notice);
        Button configuration = (Button) findViewById(R.id.button_configuration);
        Button event = (Button) findViewById(R.id.button_event);
        Button logout = (Button) findViewById(R.id.logoutButton);
        final ImageView profileImageView = findViewById(R.id.profileImageView);
        final TextView nameTextView = findViewById(R.id.nameTextView);
        final TextView phoneNumberTextView = findViewById(R.id.phoneNumberTextView);
        final TextView birthDayTextView = findViewById(R.id.birthDayTextView);
        final TextView addressTextView = findViewById(R.id.addressTextView);

        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent noticeintent = new Intent(getApplicationContext(), noticeActivity.class);
                startActivity(noticeintent);
            }
        });
        configuration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent conintent = new Intent(getApplicationContext(), configurationActivity.class);
                startActivity(conintent);
            }
        });
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent eventintent = new Intent(getApplicationContext(), eventActivity.class);
                startActivity(eventintent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent signupintent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(signupintent);



            }
        });


        DocumentReference documentReference = FirebaseFirestore.getInstance().collection("users").document(FirebaseAuth.getInstance().getCurrentUser().getUid());
        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null) {
                        if (document.exists()) {
                            Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                            if(document.getData().get("photoUrl") != null){
                                Glide.with(getApplicationContext()).load(document.getData().get("photoUrl")).centerCrop().override(500).into(profileImageView);
                            }
                            nameTextView.setText("이름: "+document.getData().get("name").toString());
                            phoneNumberTextView.setText("번호: "+ document.getData().get("phoneNumber").toString());
                            birthDayTextView.setText("생년월일: "+document.getData().get("birthDay").toString());
                            addressTextView.setText("지역: "+ document.getData().get("address").toString());
                        } else {
                            Log.d(TAG, "No such document");
                        }
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });



    }


}

