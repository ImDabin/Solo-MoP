package com.example.anabada1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class customer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        // back_button을 눌렀을 때 mypage 액티비티로 이동
        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(customer.this, mypage.class);
                startActivity(intent);
            }
        });

        // submit_button을 눌렀을 때 처리
        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText questionTitleEditText = findViewById(R.id.question_title_edit_text);
                EditText questionContentEditText = findViewById(R.id.question_content_edit_text);
                EditText emailEditText = findViewById(R.id.email_edit_text);

                String questionTitle = questionTitleEditText.getText().toString();
                String questionContent = questionContentEditText.getText().toString();
                String email = emailEditText.getText().toString();

                if (questionTitle.isEmpty() || questionContent.isEmpty() || email.isEmpty()) {
                    Toast.makeText(customer.this, "모든 필드를 채워주시기 바랍니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(customer.this, "문의사항이 등록되었습니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(customer.this, mypage.class);
                    startActivity(intent);
                }
            }
        });
    }
}
