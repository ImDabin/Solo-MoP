package com.example.anabada1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class search extends AppCompatActivity {

    private static final int HOME_ID = 1;
    private static final int OFFER_ID = 2;
    private static final int PUSH_ID = 3;
    private static final int CHAT_ID = 4;
    private static final int MY_ID = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);



    }
}