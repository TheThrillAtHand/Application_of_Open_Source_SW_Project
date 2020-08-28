/*
  작성자 : 이선명
  내용 : 동해낚시터 상세보기 및 구매하기(동해 낚시터 상세보기를 클릭 할 경우 현재 페이지로 이동)
*/
package com.nestnet.thethrillathand.reservation_fishery;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.nestnet.thethrillathand.R;

public class FisheryDonghaeActivity extends AppCompatActivity {

    Button btn_dialog_dh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fishery_donghae);

        btn_dialog_dh = (Button)findViewById(R.id.btn_buy_dh);

        btn_dialog_dh.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                AlertDialog.Builder ad = new AlertDialog.Builder(FisheryDonghaeActivity.this);
                ad.setIcon(R.drawable.sample);
                ad.setTitle("구매");
                ad.setMessage(" 구매가격 : 30,000원\n\n 구매하시겠습니까?");

                ad.setPositiveButton("확인",new  DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        dialog.dismiss();
                        Toast.makeText(FisheryDonghaeActivity.this, "결제 완료", Toast.LENGTH_LONG).show();
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
