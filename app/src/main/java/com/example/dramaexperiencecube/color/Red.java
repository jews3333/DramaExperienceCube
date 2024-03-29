package com.example.dramaexperiencecube.color;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.dramaexperiencecube.MainActivity;
import com.example.dramaexperiencecube.R;

public class Red extends Activity {

    private static VideoView videoView;
    static String pkgNm;
    static MediaController controller;
    View_Red view_Red;
    Button btnStart, btnStop;
    ImageButton btn_back, btn_home, btn_list;
    ScrollView scrollView;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    Adapter_Red redAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_red);
        pkgNm = getPackageName();
        view_Red = new View_Red(this, getPackageName());

        //뷰 리스트 추가
        btn_list = (ImageButton) findViewById(R.id.btn_list);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        redAdapter = new Adapter_Red(view_Red.getViewList());
        mRecyclerView.setAdapter(redAdapter);


        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRecyclerView.setVisibility(mRecyclerView.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });





        //레이아웃 위젯 findViewById
        videoView = (VideoView) findViewById(R.id.view);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);

        //미디어컨트롤러 추가하는 부분
        controller = new MediaController(Red.this);
        videoView.setMediaController(controller);

        //비디오뷰 포커스를 요청함
        videoView.requestFocus();

        String path = "android.resource://" + getPackageName() + "/" + R.raw.red_1;

        videoView.setVideoPath(path);




        //동영상이 재생준비가 완료되었을 때를 알 수 있는 리스너 (실제 웹에서 영상을 다운받아 출력할 때 많이 사용됨)
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Toast.makeText(Red.this,
                        "동영상이 준비되었습니다. \n'시작' 버튼을 누르세요", Toast.LENGTH_SHORT).show();
            }
        });

        //동영상 재생이 완료된 걸 알 수 있는 리스너
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //동영상 재생이 완료된 후 호출되는 메소드
                Toast.makeText(Red.this,
                        "동영상 재생이 완료되었습니다.", Toast.LENGTH_SHORT).show();
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
                Intent intent = new Intent(Red.this, MainActivity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }
    //시작 버튼 onClick Method
    public void StartButton(View v) {
        playVideo();
    }

    //정지 버튼 onClick Method
    public void StopButton(View v) {
        stopVideo();
    }

    //동영상 재생 Method
    private void playVideo() {
        //비디오를 처음부터 재생할 때 0으로 시작(파라메터 sec)
        videoView.seekTo(0);
        videoView.start();
    }

    //동영상 정지 Method
    private void stopVideo() {
        //비디오 재생 잠시 멈춤
        videoView.pause();
        //비디오 재생 완전 멈춤
        //        videoView.stopPlayback();
        //videoView를 null로 반환 시 동영상의 반복 재생이 불가능
        //        videoView = null;
    }

    public static void View_video(TextView str){
        //미디어컨트롤러 추가하는 부분
        videoView.setMediaController(controller);

        //비디오뷰 포커스를 요청함
        videoView.requestFocus();
        //uri 획득
        Uri.parse("android.resource://"+pkgNm+"/raw/"+str.getText().toString());
        videoView.setVideoURI(Uri.parse("android.resource://"+pkgNm+"/raw/"+str.getText().toString()));
//        videoView.setVideoPath(path);
    }


}
