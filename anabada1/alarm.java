package com.example.anabada1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class alarm extends AppCompatActivity {

    private static final int HOME_ID = 1;
    private static final int OFFER_ID = 2;
    private static final int PUSH_ID = 3;
    private static final int CHAT_ID = 4;
    private static final int MY_ID = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getOrder();
                switch (itemId) {
                    case HOME_ID:
                        startActivity(new Intent(alarm.this, home.class));
                        return true;
                    case OFFER_ID:
                        return true;
                    case PUSH_ID:
                        startActivity(new Intent(alarm.this, push.class));
                        return true;
                    case CHAT_ID:
                        startActivity(new Intent(alarm.this, chat.class));
                        return true;
                    case MY_ID:
                        startActivity(new Intent(alarm.this, mypage.class));
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
}
