package com.example.dramaexperiencecube;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.dramaexperiencecube.sound.Sound_Fragment1;
import com.example.dramaexperiencecube.sound.Sound_Fragment2;
import com.example.dramaexperiencecube.sound.Sound_Fragment3;
import com.example.dramaexperiencecube.sound.Sound_Fragment4;

public class SoundActivity extends AppCompatActivity {

    private FragmentManager fm;
    private FragmentTransaction ft;
    private Sound_Fragment1 sound_fragment1;
    private Sound_Fragment2 sound_fragment2;
    private Sound_Fragment3 sound_fragment3;
    private Sound_Fragment4 sound_fragment4;

    Button btn_sound_frag1,btn_sound_frag2,btn_sound_frag3,btn_sound_frag4;
    ImageButton btn_back,btn_home;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);

        sound_fragment1 = new Sound_Fragment1();
        sound_fragment2 = new Sound_Fragment2();
        sound_fragment3 = new Sound_Fragment3();
        sound_fragment4 = new Sound_Fragment4();

        btn_sound_frag1 = findViewById(R.id.btn_sound_frag1);
        btn_sound_frag2 = findViewById(R.id.btn_sound_frag2);
        btn_sound_frag3 = findViewById(R.id.btn_sound_frag3);
        btn_sound_frag4 = findViewById(R.id.btn_sound_frag4);

        setFrag(0);

        btn_sound_frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFrag(0);
            }
        });
        btn_sound_frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFrag(1);
            }
        });
        btn_sound_frag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFrag(2);
            }
        });
        btn_sound_frag4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFrag(3);
            }
        });

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                mediaPlayer = null;
                onBackPressed();
            }
        });

        btn_home = findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SoundActivity.this, MainActivity.class);
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
                ft.replace(R.id.frame_sound, sound_fragment1);
                ft.commit();
                break;
            case 1 :
                ft.replace(R.id.frame_sound, sound_fragment2);
                ft.commit();
                break;
            case 2 :
                ft.replace(R.id.frame_sound, sound_fragment3);
                ft.commit();
                break;
            case 3 :
                ft.replace(R.id.frame_sound, sound_fragment4);
                ft.commit();
                break;
        }
    }

    public void onSound(View view){

        Button btn = (Button)view;
        String fileName = btn.getText().toString();

        int lib = this.getResources().getIdentifier("sound_"+fileName, "raw", this.getPackageName());

//        Toast.makeText(this, lib, Toast.LENGTH_SHORT).show();

        if(mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(SoundActivity.this, lib);
            mediaPlayer.start();
        } else
        if(!mediaPlayer.isPlaying()){
            mediaPlayer = null;
            mediaPlayer = MediaPlayer.create(SoundActivity.this, lib);
            mediaPlayer.start();
        } else {
            mediaPlayer.stop();
            mediaPlayer = null;
            mediaPlayer = MediaPlayer.create(SoundActivity.this, lib);
            mediaPlayer.start();
        }
    }
}
