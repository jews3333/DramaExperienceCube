package com.example.dramaexperiencecube;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_sub_activity1;
    Button btn_sub_activity2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_sub_activity1 = (Button)findViewById(R.id.btn_subActivity1);
        btn_sub_activity2 = (Button)findViewById(R.id.btn_subActivity2);

        btn_sub_activity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubActivity1.class);
                startActivity(intent);
            }
        });

        btn_sub_activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubActivity2.class);
                startActivity(intent);
            }
        });
    }
}
