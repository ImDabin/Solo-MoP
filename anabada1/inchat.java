package com.example.anabada1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class inchat extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inchat);

        // gochatbutton 버튼 클릭 시 chat 액티비티로 이동
        ImageButton goChatButton = findViewById(R.id.gochatbutton);
        goChatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(inchat.this, chat.class);
                startActivity(intent);
            }
        });
    }
}
