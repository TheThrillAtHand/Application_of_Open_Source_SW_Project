/*
  작성자 : 이선명
  내용 : 안산호 상세설명 및 구매 페이지(상세설명 클릭시 현재 페이지로 이동)
*/
package com.nestnet.thethrillathand.reservation_ship;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.nestnet.thethrillathand.R;

public class ShipAnsanActivity extends AppCompatActivity {

    Button btn_dialog_ansan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ship_ansan);

        btn_dialog_ansan = (Button)findViewById(R.id.btn_buy_ansan);

        btn_dialog_ansan.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                AlertDialog.Builder ad = new AlertDialog.Builder(ShipAnsanActivity.this);
                ad.setIcon(R.drawable.sample);
                ad.setTitle("구매");
                ad.setMessage(" 구매가격 : 70,000원\n\n 구매하시겠습니까?");

                ad.setPositiveButton("확인",new  DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        dialog.dismiss();
                        Toast.makeText(ShipAnsanActivity.this, "결제 완료", Toast.LENGTH_LONG).show();
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
