/*
  작성자 : 이선명
  내용 : PoinA1룸 상세설명 및 구매 페이지(PoinActivity에서 PoinA1룸 클릭시 현재 페이지로 이동)
*/
package com.example.thethrillathand.reservation_rental;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.thethrillathand.R;

import static com.example.thethrillathand.R.layout.activity_poin_a1;

public class PoinA1Activity extends AppCompatActivity {

    Button btn_dialog_poina1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_poin_a1);

        btn_dialog_poina1 = (Button)findViewById(R.id.btn_buy_a1);

        btn_dialog_poina1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                AlertDialog.Builder ad = new AlertDialog.Builder(PoinA1Activity.this);
                ad.setIcon(R.drawable.sample);
                ad.setTitle("구매");
                ad.setMessage(" 구매가격 : 95,000원\n\n 구매하시겠습니까?");

                ad.setPositiveButton("확인",new  DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        dialog.dismiss();
                        Toast.makeText(PoinA1Activity.this, "결제 완료", Toast.LENGTH_LONG).show();
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
