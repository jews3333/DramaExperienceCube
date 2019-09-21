package com.example.dramaexperiencecube;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.dramaexperiencecube.color.Red;

public class ColorActivity extends Activity {
    Button Red;
    Button Yellow;
    Button Blue;
    Button Gray;
    ImageButton btn_back, btn_home;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        Red = (Button)findViewById(R.id.btn_Red);
        Yellow = (Button)findViewById(R.id.btn_Yellow);
        Blue = (Button)findViewById(R.id.btn_Blue);
        Gray = (Button)findViewById(R.id.btn_Gray);

        Red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ColorActivity.this, com.example.dramaexperiencecube.color.Red.class);
                startActivity(intent);
            }
        });

        Yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ColorActivity.this, com.example.dramaexperiencecube.color.Yellow.class);
                startActivity(intent);
            }
        });

        Blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ColorActivity.this, com.example.dramaexperiencecube.color.Blue.class);
                startActivity(intent);
            }
        });

        Gray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ColorActivity.this, com.example.dramaexperiencecube.color.Gray.class);
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
                Intent intent = new Intent(ColorActivity.this, MainActivity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
