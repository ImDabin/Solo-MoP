package com.example.anabada1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    private EditText phoneNumberEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        phoneNumberEditText = findViewById(R.id.phonenumber);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginbutton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phoneNumberEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (TextUtils.isEmpty(phoneNumber)) {
                    Toast.makeText(login.this, "전화번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(login.this, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                } else {
                    // 홈 액티비티로 이동
                    Intent intent = new Intent(login.this, home.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
