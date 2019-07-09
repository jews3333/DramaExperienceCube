package com.example.dramaexperiencecube;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

public class YesorysesHelpActivity extends AppCompatActivity {

    Button btn_media;
    VideoView media;
    LinearLayout media_wrap;
    ImageButton btn_back,btn_home,btn_help;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yesoryes_help);

        String VIDEO_URL = "android.resource://" + getPackageName() + "/" + R.raw.dramabyyes;

        media = (VideoView)findViewById(R.id.media);
        media.setVideoPath(VIDEO_URL);

        media_wrap = (LinearLayout)findViewById(R.id.media_wrap);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(media);

        media.setMediaController(mediaController);

        btn_media = (Button)findViewById(R.id.btn_media);
        btn_media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                media_wrap.setVisibility(View.VISIBLE);
                media.start();
            }
        });

        btn_back = (ImageButton)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                media.pause();
                media.seekTo(0);
                if(media_wrap.getVisibility() == View.VISIBLE){
                    media_wrap.setVisibility(View.GONE);
                } else {
                    onBackPressed();
                }
            }
        });

        btn_home = (ImageButton)findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                media.pause();
                media.seekTo(0);
                Intent intent = new Intent(YesorysesHelpActivity.this, MainActivity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
