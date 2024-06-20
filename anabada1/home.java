package com.example.anabada1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class home extends AppCompatActivity {

    private Fragment newfragment;
    private Fragment usedfragment;
    private static final int HOME_ID = 1;
    private static final int OFFER_ID = 2;
    private static final int PUSH_ID = 3;
    private static final int CHAT_ID = 4;
    private static final int MY_ID = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        ImageButton searchButton = findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 새로운 페이지로 이동하는 코드
                Intent intent1 = new Intent(home.this, search.class); // NewActivity를 새로운 페이지의 액티비티 클래스로 변경
                startActivity(intent1);
            }
        });

        ImageButton alarmButton = findViewById(R.id.alarm_button);
        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 새로운 페이지로 이동하는 코드
                Intent intent2 = new Intent(home.this, alarm.class); // NewActivity를 새로운 페이지의 액티비티 클래스로 변경
                startActivity(intent2);
            }
        });

        ImageButton adButton = findViewById(R.id.ad_button);
        adButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 새로운 페이지로 이동하는 코드
                Intent intent3 = new Intent(home.this, push.class); // NewActivity를 새로운 페이지의 액티비티 클래스로 변경
                startActivity(intent3);
            }
        });



        newfragment = new newfragment();
        usedfragment = new usedfragment();

        // 초기에는 새상품 프래그먼트를 보여줌
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, newfragment)
                .commit();

        // 버튼 클릭 이벤트 처리
        Button newButton = findViewById(R.id.new_button);
        Button usedButton = findViewById(R.id.old_button);

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 새상품 버튼 클릭 시 새상품 프래그먼트 표시
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, newfragment)
                        .commit();
            }
        });

        usedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 중고 버튼 클릭 시 중고 프래그먼트 표시
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, usedfragment)
                        .commit();
            }
        });





        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getOrder();
                switch (itemId) {
                    case HOME_ID:
                        return true;
                    case OFFER_ID:
                        startActivity(new Intent(home.this, offer.class));
                        return true;
                    case PUSH_ID:
                        startActivity(new Intent(home.this, push.class));
                        return true;
                    case CHAT_ID:
                        startActivity(new Intent(home.this, chat.class));
                        return true;
                    case MY_ID:
                        startActivity(new Intent(home.this, mypage.class));
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
}
