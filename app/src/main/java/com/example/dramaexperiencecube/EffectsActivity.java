package com.example.dramaexperiencecube;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

public class EffectsActivity extends AppCompatActivity {

    Button btn_sound, btn_light;
    ImageButton btn_back,btn_home;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effects);

        btn_sound = (Button)findViewById(R.id.btn_sound);
        btn_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EffectsActivity.this, SoundActivity.class);
                startActivity(intent);
            }
        });

        btn_light = (Button)findViewById(R.id.btn_light);
        btn_light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getPackageManager().getLaunchIntentForPackage("com.xiaomi.smarthome");

                if(intent != null){
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                } else {
                    String url = "market://details?id=" + "com.xiaomi.smarthome";
                    Intent market = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(market);
                }
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
                Intent intent = new Intent(EffectsActivity.this, MainActivity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }
}
