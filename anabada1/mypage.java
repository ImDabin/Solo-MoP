package com.example.anabada1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;
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

        // 프로필 보기 버튼 클릭 시 다이얼로그 표시
        Button showProfileButton = findViewById(R.id.show_profile_button);
        showProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProfileDialog();
            }
        });

        // 설정 버튼 클릭 시 다이얼로그 표시
        ImageButton settingButton = findViewById(R.id.setting_button);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSettingDialog();
            }
        });

        // 제안 내역 버튼 클릭 시 offer 액티비티로 이동
        Button offerButton = findViewById(R.id.offer_button);
        offerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mypage.this, offer.class));
            }
        });

        // 등록 내역 버튼 클릭 시 등록 내역 액티비티로 이동
        Button registerButton = findViewById(R.id.push_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mypage.this, push.class));
            }
        });

        // 고객센터 버튼 클릭 시 customer 액티비티로 이동
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

    private void showProfileDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("내 프로필");

        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.seeprofile, null);
        builder.setView(dialogView);

        builder.setPositiveButton("OK", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showSettingDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("설정");

        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_settings, null);
        builder.setView(dialogView);

        Switch notificationSwitch = dialogView.findViewById(R.id.notification_switch);
        notificationSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // 스위치 상태 변경 시 처리할 로직 추가
        });

        Button phoneChangeButton = dialogView.findViewById(R.id.phone_change_button);
        phoneChangeButton.setOnClickListener(v -> showPhoneChangeDialog());

        Button passwordChangeButton = dialogView.findViewById(R.id.password_change_button);
        passwordChangeButton.setOnClickListener(v -> showChangePasswordDialog());

        Button deleteAccountButton = dialogView.findViewById(R.id.delete_account_button);
        deleteAccountButton.setOnClickListener(v -> showDeleteAccountDialog());

        builder.setPositiveButton("완료", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showPhoneChangeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("전화번호 변경");

        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_phone_change, null);
        builder.setView(dialogView);

        EditText phoneNumberEditText = dialogView.findViewById(R.id.phone_input);
        EditText verificationCodeEditText = dialogView.findViewById(R.id.injnumber);
        Button sendVerificationButton = dialogView.findViewById(R.id.send_verification_button);
        Button verifyButton = dialogView.findViewById(R.id.injcheck);
        Button changeButton = dialogView.findViewById(R.id.changenumbercheck);

        sendVerificationButton.setOnClickListener(v -> {
            String phoneNumber = phoneNumberEditText.getText().toString();
            if (!phoneNumber.isEmpty()) {
                Toast.makeText(this, "인증번호가 전송되었습니다.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "전화번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
            }
        });

        verifyButton.setOnClickListener(v -> {
            String verificationCode = verificationCodeEditText.getText().toString();
            if (!verificationCode.isEmpty()) {
                Toast.makeText(this, "인증되었습니다.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "인증번호를 입력하세요.", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setPositiveButton("취소", null);

        AlertDialog dialog = builder.create();

        changeButton.setOnClickListener(v -> {
            String phoneNumber = phoneNumberEditText.getText().toString();
            String verificationCode = verificationCodeEditText.getText().toString();
            if (!phoneNumber.isEmpty() && !verificationCode.isEmpty()) {
                Toast.makeText(this, "변경되었습니다.", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            } else {
                Toast.makeText(this, "인증을 완료해주세요.", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
    }

    private void showChangePasswordDialog() {
        // 비밀번호 변경 다이얼로그 표시
        AlertDialog.Builder builder = new AlertDialog.Builder(mypage.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_password_change, null);
        builder.setView(dialogView);

        EditText currentPasswordEditText = dialogView.findViewById(R.id.nowpass);
        EditText newPasswordEditText = dialogView.findViewById(R.id.chpass);
        EditText confirmPasswordEditText = dialogView.findViewById(R.id.chpasscheck);
        Button verifyButton = dialogView.findViewById(R.id.passcheck);
        Button changePasswordButton = dialogView.findViewById(R.id.passchange);

        // 현재 비밀번호 인증 로직
        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentPassword = currentPasswordEditText.getText().toString();
                if (TextUtils.isEmpty(currentPassword)) {
                    Toast.makeText(mypage.this, "현재 비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mypage.this, "인증되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 비밀번호 변경 로직
        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newPassword = newPasswordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();

                if (!newPassword.equals(confirmPassword)) {
                    Toast.makeText(mypage.this, "새 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mypage.this, "변경되었습니다.", Toast.LENGTH_SHORT).show();
                    // 로그인 액티비티로 이동
                    Intent intent = new Intent(mypage.this, login.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        });

        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showDeleteAccountDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mypage.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_delete_account, null);
        builder.setView(dialogView);

        EditText passwordEditText = dialogView.findViewById(R.id.delete_account_password);
        Button confirmButton = dialogView.findViewById(R.id.delete_account_confirm);
        Button cancelButton = dialogView.findViewById(R.id.delete_account_cancel);

        AlertDialog dialog = builder.create();

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = passwordEditText.getText().toString();

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(mypage.this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    // 비밀번호 확인 로직 (예: 서버 통신)
                    // 비밀번호가 맞다고 가정하고, 회원 탈퇴 처리
                    Toast.makeText(mypage.this, "회원 탈퇴가 완료되었습니다.", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    // 로그인 액티비티로 이동
                    Intent intent = new Intent(mypage.this, login.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void showLogoutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("로그아웃하시겠습니까?")
                .setPositiveButton("아니요", null)
                .setNegativeButton("네", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(mypage.this, login.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
