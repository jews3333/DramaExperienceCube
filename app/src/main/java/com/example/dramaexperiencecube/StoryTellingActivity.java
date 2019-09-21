package com.example.dramaexperiencecube;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class StoryTellingActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer = null;

    private int step = 0;
    static final int PERMISSON = 1;

    private TextView tvBox01, tvBox02, tvBox03, tvBox04; //text_box_01_tv
    private ImageView play, children;
    private ImageButton btnHome;


    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            nextStep();
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
        setContentView(R.layout.activity_story_telling);

        tvBox01 = findViewById(R.id.text_box_01_tv);
        tvBox02 = findViewById(R.id.text_box_02_tv);
        tvBox03 = findViewById(R.id.text_box_03_tv);
        tvBox04 = findViewById(R.id.text_box_04_tv);

        play = findViewById(R.id.play);
        children = findViewById(R.id.children_iv);

        btnHome = findViewById(R.id.btn_home);

        initView();

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play.setVisibility(View.GONE);
                children.setVisibility(View.VISIBLE);
                step++;
                nextStep();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goMain();
                finish();
            }
        });


        //권한이 부여되어 있는지 확인
        getAll_permissions();
    }

    private void initView() {
        play.setVisibility(View.VISIBLE);
        tvBox01.setVisibility(View.GONE);
        tvBox02.setVisibility(View.GONE);
        tvBox03.setVisibility(View.GONE);
        tvBox04.setVisibility(View.GONE);
        children.setVisibility(View.GONE);
    }

    private void tvBoxGone() {
        tvBox01.setVisibility(View.GONE);
        tvBox02.setVisibility(View.GONE);
        tvBox03.setVisibility(View.GONE);
        tvBox04.setVisibility(View.GONE);
    }

    private void nextStep() {

        switch (step) {
            case 0:
                initView();
                break;
            case 1:
                playStory(R.raw.st1_01);
                tvBoxGone();
                tvBox01.setVisibility(View.VISIBLE);
                tvBox01.setText("얘들아~ 학예발표회에서 우리 함께 연극을 해보는게 어때?");
                break;
            case 2:
                playStory(R.raw.st2_02);
                tvBoxGone();
                tvBox02.setVisibility(View.VISIBLE);
                tvBox02.setText("좋아! 연극을 공연하려면 먼저 무엇을 해야할까?");
                break;
            case 3:
                playStory(R.raw.st3_03);
                tvBoxGone();
                tvBox04.setVisibility(View.VISIBLE);
                tvBox04.setText("연극을 공연하려면 극본이 있어야 해. 극본에는 무엇을 넣어야하지?");
                break;
            case 4:
                playStory(R.raw.st4_04);
                tvBoxGone();
                tvBox03.setVisibility(View.VISIBLE);
                tvBox03.setText("연극으로 만들 이야기를 정해야 하고, 등장인물, 대사... 잘 모르겠어 연극은 어려워!");
                break;
            case 5:
                playStory(R.raw.st1_05);
                tvBoxGone();
                tvBox01.setVisibility(View.VISIBLE);
                tvBox01.setText("연극을 쉽게 할 수 있도록 도와주는 앱이 있는데 같이 한번 살펴볼래?");
                break;
            case 6:
                playStory(R.raw.st3_06);
                tvBoxGone();
                tvBox04.setVisibility(View.VISIBLE);
                tvBox04.setText("너랑나랑 체험중심연극 플레이???");
                break;
            case 7:
                playStory(R.raw.st4_07);
                tvBoxGone();
                tvBox03.setVisibility(View.VISIBLE);
                tvBox03.setText("이 앱으로 연극에 대해 잘 알 수 있다 이거지?");
                break;
            case 8:
                playStory(R.raw.st2_08);
                tvBoxGone();
                tvBox02.setVisibility(View.VISIBLE);
                tvBox02.setText("그럼! 걱정마!! 지금부터 연극의 시작부터 끝까지 함께 알아보자구^^");
                break;
            case 9:
                goMain();
                break;
        }

        step++;
    }

    public Boolean getAll_permissions() {

        //권한이 부여되어 있는지 확인
        int permissonRecord = ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO);
        int permissonWrite = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int permissonRead = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);

        if (permissonRecord == PackageManager.PERMISSION_GRANTED && permissonWrite == PackageManager.PERMISSION_GRANTED && permissonRead == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECORD_AUDIO)) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.RECORD_AUDIO}, PERMISSON);
            } else {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.RECORD_AUDIO}, PERMISSON);
            }
        }
        return true;
    }

    private void goMain() {
        Intent intent = new Intent(StoryTellingActivity.this, MainActivity.class);
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
