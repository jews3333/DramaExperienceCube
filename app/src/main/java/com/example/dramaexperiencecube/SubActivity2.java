package com.example.dramaexperiencecube;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SubActivity2 extends AppCompatActivity {

    Button btn_ready;
    Button btn_traning;
    Button btn_reality;
    ImageButton btn_back, btn_home;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        btn_ready = (Button)findViewById(R.id.btn_ready);
        btn_traning = (Button)findViewById(R.id.btn_traning);
        btn_reality = (Button)findViewById(R.id.btn_reality);

        btn_ready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubActivity2.this, ReadyActivity.class);
                startActivity(intent);
            }
        });

        btn_traning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubActivity2.this, TraningActivity.class);
                startActivity(intent);
            }
        });

        btn_reality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubActivity2.this, RealityActivity.class);
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
                Intent intent = new Intent(SubActivity2.this, MainActivity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
