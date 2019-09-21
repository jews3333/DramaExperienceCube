package com.example.dramaexperiencecube;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.dramaexperiencecube.game.Game_Fragment1;
import com.example.dramaexperiencecube.game.Game_Fragment2;
import com.example.dramaexperiencecube.game.Game_Fragment3;
import com.example.dramaexperiencecube.game.Game_Fragment4;

public class GameActivity extends AppCompatActivity {

    private FragmentManager fm;
    private FragmentTransaction ft;
    private Game_Fragment1 game_fragment1;
    private Game_Fragment2 game_fragment2;
    private Game_Fragment3 game_fragment3;
    private Game_Fragment4 game_fragment4;

    Button btn_game_frag1, btn_game_frag2, btn_game_frag3, btn_game_frag4;
    ImageButton btn_back, btn_home;

    private LinearLayout llBottom;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        game_fragment1 = new Game_Fragment1(); // 놀이 소개
        game_fragment2 = new Game_Fragment2(); // 카드 구성
        game_fragment3 = new Game_Fragment3(); // 놀이 방법
        game_fragment4 = new Game_Fragment4(); // 놀이 시작

        btn_game_frag1 = (Button) findViewById(R.id.btn_game_frag1);
        btn_game_frag2 = (Button) findViewById(R.id.btn_game_frag2);
        btn_game_frag3 = (Button) findViewById(R.id.btn_game_frag3);
        btn_game_frag4 = (Button) findViewById(R.id.btn_game_frag4);

        llBottom = findViewById(R.id.bottom_ll);

        setFrag(0);

        btn_game_frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFrag(0);
            }
        });
        btn_game_frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFrag(1);
            }
        });
        btn_game_frag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFrag(2);
            }
        });
        btn_game_frag4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFrag(3);
            }
        });


        btn_back = (ImageButton) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_home = (ImageButton) findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }

    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        switch (n) {
            case 0:
                ft.replace(R.id.frame_game, game_fragment1);
                ft.commit();
                llBottom.setVisibility(View.VISIBLE);
                break;
            case 1:
                ft.replace(R.id.frame_game, game_fragment2);
                ft.commit();
                llBottom.setVisibility(View.VISIBLE);
                break;
            case 2:
                ft.replace(R.id.frame_game, game_fragment3);
                ft.commit();
                llBottom.setVisibility(View.VISIBLE);
                break;
            case 3:
                ft.replace(R.id.frame_game, game_fragment4);
                ft.commit();
                llBottom.setVisibility(View.GONE);
                break;

        }
    }
}
