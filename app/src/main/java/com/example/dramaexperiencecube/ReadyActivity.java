package com.example.dramaexperiencecube;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ReadyActivity extends AppCompatActivity {
    Button btn_Color;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready);


        btn_Color = (Button)findViewById(R.id.btn_ColorActivity);

        btn_Color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReadyActivity.this, ColorActivity.class);
                startActivity(intent);
            }
        });
    }
}
