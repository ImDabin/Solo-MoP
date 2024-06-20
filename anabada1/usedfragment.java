package com.example.anabada1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class usedfragment extends Fragment {

    public usedfragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_used, container, false);

        Button moreButton = view.findViewById(R.id.more_button);
        moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 카테고리 화면으로 이동하는 메소드를 호출합니다.
                navigateToCategory();
            }
        });

        // 버튼을 찾아 클릭 이벤트를 추가합니다.
        Button digiButton = view.findViewById(R.id.digital_button);
        digiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 카테고리 화면으로 이동하는 메소드를 호출합니다.
                navigateToCategory();
            }
        });

        Button healButton = view.findViewById(R.id.health_button);
        healButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 카테고리 화면으로 이동하는 메소드를 호출합니다.
                navigateToCategory();
            }
        });

        Button shoButton = view.findViewById(R.id.shoes_button);
        shoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 카테고리 화면으로 이동하는 메소드를 호출합니다.
                navigateToCategory();
            }
        });

        ImageButton shop2Button = view.findViewById(R.id.shoping_button2);
        shop2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 카테고리 화면으로 이동하는 메소드를 호출합니다.
                navigateTogoods2();
            }
        });

        ImageButton shop1Button = view.findViewById(R.id.shoping_button1);
        shop1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 카테고리 화면으로 이동하는 메소드를 호출합니다.
                navigateTogoods1();
            }
        });

        ImageButton shop3Button = view.findViewById(R.id.shoping_button3);
        shop3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 카테고리 화면으로 이동하는 메소드를 호출합니다.
                navigateTogoods3();
            }
        });

        ImageButton regi1Button = view.findViewById(R.id.regi_button1);
        regi1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 카테고리 화면으로 이동하는 메소드를 호출합니다.
                navigateTogoods4();
            }
        });

        ImageButton regi2Button = view.findViewById(R.id.regi_button2);
        regi2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 카테고리 화면으로 이동하는 메소드를 호출합니다.
                navigateTogoods5();
            }
        });

        ImageButton regi3Button = view.findViewById(R.id.regi_button3);
        regi3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 카테고리 화면으로 이동하는 메소드를 호출합니다.
                navigateTogoods6();
            }
        });

        return view;
    }

    // 카테고리 화면으로 이동하는 메소드
    private void navigateToCategory() {
        // 카테고리 화면으로 이동하기 위해 Intent를 사용합니다.
        Intent intent = new Intent(getActivity(), category.class);
        startActivity(intent);
    }

    private void navigateTogoods1() {
        // 카테고리 화면으로 이동하기 위해 Intent를 사용합니다.
        Intent intent = new Intent(getActivity(), goods1.class);
        startActivity(intent);


    }

    private void navigateTogoods2() {
        // 카테고리 화면으로 이동하기 위해 Intent를 사용합니다.
        Intent intent = new Intent(getActivity(), goods2.class);
        startActivity(intent);


    }

    private void navigateTogoods3() {
        // 카테고리 화면으로 이동하기 위해 Intent를 사용합니다.
        Intent intent = new Intent(getActivity(), goods3.class);
        startActivity(intent);


    }

    private void navigateTogoods4() {
        // 카테고리 화면으로 이동하기 위해 Intent를 사용합니다.
        Intent intent = new Intent(getActivity(), goods4.class);
        startActivity(intent);


    }

    private void navigateTogoods5() {
        // 카테고리 화면으로 이동하기 위해 Intent를 사용합니다.
        Intent intent = new Intent(getActivity(), goods5.class);
        startActivity(intent);


    }

    private void navigateTogoods6() {
        // 카테고리 화면으로 이동하기 위해 Intent를 사용합니다.
        Intent intent = new Intent(getActivity(), goods6.class);
        startActivity(intent);


    }


}

