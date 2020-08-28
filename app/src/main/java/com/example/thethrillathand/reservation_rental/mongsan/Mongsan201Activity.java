package com.example.thethrillathand.reservation_rental.mongsan;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.thethrillathand.R;

public class Mongsan201Activity extends AppCompatActivity {

    Button btn_dialog_monsan201;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mongsan201);

        btn_dialog_monsan201 = (Button) findViewById(R.id.btn_buy_mongsan201);

        btn_dialog_monsan201.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                AlertDialog.Builder ad = new AlertDialog.Builder(Mongsan201Activity.this);
                ad.setIcon(R.drawable.sample);
                ad.setTitle("구매");
                ad.setMessage(" 구매가격 : 160,000원\n\n 구매하시겠습니까?");

                ad.setPositiveButton("확인",new  DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        dialog.dismiss();
                        Toast.makeText(Mongsan201Activity.this, "결제 완료", Toast.LENGTH_LONG).show();
                        finish();
                    }
                });

                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                ad.show();
            }
        });
    }
}