package com.example.dramaexperiencecube;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RealityActivity extends AppCompatActivity {

    Button btn_sub_btn_ReadingActivity;
    Button btn_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reality);

        btn_sub_btn_ReadingActivity = (Button)findViewById(R.id.btn_ReadingActivity);

        btn_sub_btn_ReadingActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RealityActivity.this, ReadingActivity.class);
                startActivity(intent);
            }
        });

        btn_back = (Button)findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
