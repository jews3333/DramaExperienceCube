package com.example.dramaexperiencecube;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class StoryTellingEndActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer = null;

    private ImageView ivLast;
    private ImageButton btnBack, btnHome;


    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            goMain();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_telling_end);


        ivLast = findViewById(R.id.last_iv);

        btnBack = findViewById(R.id.btn_back);
        btnHome = findViewById(R.id.btn_home);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goMain();
                finish();
            }
        });

        playStory(R.raw.final_all);
    }

    private void goMain() {
        Intent intent = new Intent(StoryTellingEndActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void playStory(int res) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

        mediaPlayer = MediaPlayer.create(this, res);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(onCompletionListener);
    }
}
