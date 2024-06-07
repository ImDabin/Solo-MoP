package com.example.anabada1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class mypage extends AppCompatActivity {

    private static final int HOME_ID = 1;
    private static final int OFFER_ID = 2;
    private static final int PUSH_ID = 3;
    private static final int CHAT_ID = 4;
    private static final int MY_ID = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.my);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getOrder();
                switch (itemId) {
                    case HOME_ID:
                        startActivity(new Intent(mypage.this, home.class));
                        return true;
                    case OFFER_ID:
                        startActivity(new Intent(mypage.this, offer.class));
                        return true;
                    case PUSH_ID:
                        startActivity(new Intent(mypage.this, push.class));
                        return true;
                    case CHAT_ID:
                        startActivity(new Intent(mypage.this, chat.class));
                        return true;
                    case MY_ID:
                        return true;
                    default:
                        return false;
                }
            }
        });

        // Customer 버튼 클릭 시 customer 액티비티로 이동
        Button customerButton = findViewById(R.id.customer);
        customerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mypage.this, customer.class));
            }
        });

        // 로그아웃 버튼 클릭 시 확인 다이얼로그 표시
        Button logoutButton = findViewById(R.id.logout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLogoutDialog();
            }
        });
    }

    private void showLogoutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("로그아웃하시겠습니까?")
                .setPositiveButton("네", (dialog, which) -> {
                    // 로그인 액티비티로 이동
                    startActivity(new Intent(mypage.this, login.class));
                })
                .setNegativeButton("아니요", (dialog, which) -> {
                    // 다이얼로그 닫기
                    dialog.dismiss();
                });
        builder.create().show();
    }
}
