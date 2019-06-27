package com.example.dramaexperiencecube;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;

public class SubActivity1 extends AppCompatActivity {

    private FragmentManager fm;
    private FragmentTransaction ft;
    private Sub1_Fragment1 sub1_fragment1;
    private Sub1_Fragment2 sub1_fragment2;
    private Sub1_Fragment3 sub1_fragment3;
    private Sub1_Fragment4 sub1_fragment4;

    Button btn_sub1_frag1,btn_sub1_frag2,btn_sub1_frag3,btn_sub1_frag4;
    ImageButton btn_back,btn_home;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        sub1_fragment1 = new Sub1_Fragment1();
        sub1_fragment2 = new Sub1_Fragment2();
        sub1_fragment3 = new Sub1_Fragment3();
        sub1_fragment4 = new Sub1_Fragment4();

        btn_sub1_frag1 = (Button)findViewById(R.id.btn_sub1_frag1);
        btn_sub1_frag2 = (Button)findViewById(R.id.btn_sub1_frag2);
        btn_sub1_frag3 = (Button)findViewById(R.id.btn_sub1_frag3);
        btn_sub1_frag4 = (Button)findViewById(R.id.btn_sub1_frag4);

        setFrag(0);

        btn_sub1_frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               setFrag(0);
            }
        });

        btn_sub1_frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFrag(1);
            }
        });

        btn_sub1_frag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFrag(2);
            }
        });

        btn_sub1_frag4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFrag(3);
            }
        });


        btn_back = (ImageButton)findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_home = (ImageButton)findViewById(R.id.btn_home);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubActivity1.this, MainActivity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }

    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        switch (n) {
            case 0 :
                ft.replace(R.id.frame_sub1, sub1_fragment1);
                ft.commit();
                break;
            case 1 :
                ft.replace(R.id.frame_sub1, sub1_fragment2);
                ft.commit();
                break;
            case 2 :
                ft.replace(R.id.frame_sub1, sub1_fragment3);
                ft.commit();
                break;
            case 3 :
                ft.replace(R.id.frame_sub1, sub1_fragment4);
                ft.commit();
                break;
        }
    }
}
