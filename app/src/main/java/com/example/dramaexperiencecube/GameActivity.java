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

import com.example.dramaexperiencecube.game.Game_Fragment1;
import com.example.dramaexperiencecube.game.Game_Fragment2;
import com.example.dramaexperiencecube.game.Game_Fragment3;
import com.example.dramaexperiencecube.game.Game_Fragment4;
import com.example.dramaexperiencecube.game.Game_Fragment5;

public class GameActivity extends AppCompatActivity {

        private FragmentManager fm;
        private FragmentTransaction ft;
        private Game_Fragment1 game_fragment1;
        private Game_Fragment2 game_fragment2;
        private Game_Fragment3 game_fragment3;
        private Game_Fragment4 game_fragment4;
        private Game_Fragment5 game_fragment5;

    Button btn_game_frag1,btn_game_frag2,btn_game_frag3,btn_game_frag4,btn_game_frag5;
    ImageButton btn_back,btn_home;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        game_fragment1 = new Game_Fragment1();
        game_fragment2 = new Game_Fragment2();
        game_fragment3 = new Game_Fragment3();
        game_fragment4 = new Game_Fragment4();
        game_fragment5 = new Game_Fragment5();

        btn_game_frag1 = findViewById(R.id.btn_game_frag1);
        btn_game_frag2 = findViewById(R.id.btn_game_frag2);
        btn_game_frag3 = findViewById(R.id.btn_game_frag3);
        btn_game_frag4 = findViewById(R.id.btn_game_frag4);
        btn_game_frag5 = findViewById(R.id.btn_game_frag5);

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

        btn_game_frag5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFrag(4);
            }
        });


        btn_back = findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_home = findViewById(R.id.btn_home);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }

    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        switch (n) {
            case 0 :
                ft.replace(R.id.frame_game, game_fragment1);
                ft.commit();
                break;
            case 1 :
                ft.replace(R.id.frame_game, game_fragment2);
                ft.commit();
                break;
            case 2 :
                ft.replace(R.id.frame_game, game_fragment3);
                ft.commit();
                break;
            case 3 :
                ft.replace(R.id.frame_game, game_fragment4);
                ft.commit();
                break;
            case 4 :
                ft.replace(R.id.frame_game, game_fragment5);
                ft.commit();
                break;
        }
    }
}
