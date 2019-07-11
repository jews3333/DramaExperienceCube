package com.example.dramaexperiencecube;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.dramaexperiencecube.data.Drama;

import com.example.dramaexperiencecube.data.DramaScript;

import java.util.ArrayList;

public class RealityActivity extends AppCompatActivity {

    Button btn_sub_btn_ReadingActivity, btn_moving;
    ImageButton btn_back,btn_home;

    String where;
    String time;
    String location;
    ArrayList<String> humans;
    ArrayList<DramaScript> scripts;
    Drama drama;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reality);
        drama = new Drama();
        btn_sub_btn_ReadingActivity = (Button)findViewById(R.id.btn_ReadingActivity);

        // 연극 시작으로 이동
        btn_sub_btn_ReadingActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ((ReadingActivity)ReadingActivity.context).getActive();
                }catch (Exception e){
                    System.out.println("Error : " + e);
                    Toast.makeText(RealityActivity.this, "극본을 만들기로 이동합니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RealityActivity.this, MyPlanActivity.class);
                    startActivity(intent);
                }

            }
        });

        btn_moving = (Button)findViewById(R.id.btn_moving);

        btn_moving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RealityActivity.this, MovingActivity.class);
                startActivity(intent);
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
                Intent intent = new Intent(RealityActivity.this, MainActivity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
