package com.example.anabada1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class push extends AppCompatActivity {

    private static final int HOME_ID = 1;
    private static final int OFFER_ID = 2;
    private static final int PUSH_ID = 3;
    private static final int CHAT_ID = 4;
    private static final int MY_ID = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.push);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getOrder();
                switch (itemId) {
                    case HOME_ID:
                        startActivity(new Intent(push.this, home.class));
                        return true;
                    case OFFER_ID:
                        startActivity(new Intent(push.this, offer.class));
                        return true;
                    case PUSH_ID:
                        return true;
                    case CHAT_ID:
                        startActivity(new Intent(push.this, chat.class));
                        return true;
                    case MY_ID:
                        startActivity(new Intent(push.this, mypage.class));
                        return true;
                    default:
                        return false;
                }
            }
        });

        // 팝업 메뉴 버튼 설정
        Button buttonPopup = findViewById(R.id.button_popup);
        buttonPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(view);
            }
        });
    }

    private void showPopupMenu(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, popup.getMenu());
        popup.show();
    }
}
