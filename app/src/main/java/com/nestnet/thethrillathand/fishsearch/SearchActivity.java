/*
    작성자 : 2018038019 최승혜
    설 명 : 사용자가 포인트 추천을 받기 위하여 원하는 어종을 검색하는 Activity에 해당하는 코드
    Listview를 이용하여 어종의 목록을 출력하고, 원하는 어종을 입력하면 해당하는 어종이 리스트에 나타남.
*/

package com.nestnet.thethrillathand.fishsearch;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.nestnet.thethrillathand.R;


public class SearchActivity extends AppCompatActivity {

    ListView listview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        listview = (ListView) findViewById(R.id.search_list); // 리스트 뷰 선언




        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1); //어뎁터 선언
        listview.setAdapter(adapter);


        adapter.add("우럭");
        adapter.add("참돔");
        adapter.add("돌돔");
        adapter.add("감성돔");
        adapter.add("벵에돔");
        adapter.add("농어");
        adapter.add("방어");
        adapter.add("망상어");
        adapter.add("쥐노래미");
        adapter.add("가자미");
        adapter.add("임연수어");
        adapter.add("숭어");
        adapter.add("광어");
        adapter.add("벤자리");


        EditText editTextFilter = (EditText)findViewById(R.id.editTextFilter) ;
        editTextFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable edit) {
                String filterText = edit.toString() ;
                if (filterText.length() > 0) {
                    listview.setFilterText(filterText) ;
                } else {
                    listview.clearTextFilter() ;
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

        }) ;
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String selected = (String) adapter.getItem(i);
                Intent intent = new Intent(getApplicationContext(), SpotActivity.class);
                intent.putExtra("name",selected);
                startActivity(intent);





            }
        });


    }
}



