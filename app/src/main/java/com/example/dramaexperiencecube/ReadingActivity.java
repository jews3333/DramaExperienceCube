package com.example.dramaexperiencecube;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dramaexperiencecube.record.InputAlert;
import com.example.dramaexperiencecube.record.MyAdapter;
import com.example.dramaexperiencecube.record.Player;
import com.example.dramaexperiencecube.record.Recorder;


public class ReadingActivity extends AppCompatActivity implements Button.OnClickListener, MyAdapter.OnClickItemListener {

    Recorder recorder;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    MyAdapter myAdapter;

    Button prepareBtn;
    Button recordBtn;
    Button stopBtn;

    boolean isRecording = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);

        recorder = new Recorder(this, "/MyRecords");

        // recyclerview 설정
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        myAdapter = new MyAdapter(recorder.getRecordList());
        myAdapter.setOnClickItemListener(this);
        mRecyclerView.setAdapter(myAdapter);

        // 버튼 클릭 이벤트 등록
        prepareBtn = findViewById(R.id.btn_prepare);
        recordBtn = findViewById(R.id.btn_record);
        stopBtn = findViewById(R.id.btn_stop);

        prepareBtn.setOnClickListener(this);
        recordBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_prepare: // "녹음시작" 버튼 클릭 이벤트
                InputAlert alert = new InputAlert(this, "연극 이름");
                alert.setOnPressOkListener(new InputAlert.OnPressOkListener() {
                    @Override
                    public void onPressOk(String value) {
                        recorder.setSubDir("/" + value);
                        updateBtnVisibility(true);
                        updateDataset();
                    }
                });
                alert.show();
                break;
            case R.id.btn_record: // "녹음"/"다음" 버튼 클릭 이벤트
                if (!isRecording) { // "녹음" 클릭시
                    recordBtn.setText("다음");
                    recorder.record();
                    isRecording = true;
                } else { // "다음" 클릭시
                    recordBtn.setText("녹음");
                    recorder.prepareNext();
                    isRecording = false;
                    updateDataset();
                }
                break;
            case R.id.btn_stop: // "중지" 버튼 클릭 이벤트
                recorder.stop();
                updateBtnVisibility(false);
                break;
        }
    }

    final Context context = this;


    @Override
    public void onClickItem(View item) {
        TextView textItem = (TextView) item;
        final String text = textItem.getText().toString();
        //Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        final CharSequence[] items = { "재생", "삭제"};
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        final Player player = new Player(this, "/MyRecords/" + text);
        final Player playerDel = new Player(this, "/MyRecords/" + text);
// 제목셋팅
        alertDialogBuilder.setTitle("선택 목록 대화 상자");
        alertDialogBuilder.setItems(items,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // 프로그램을 종료한다
                        //Toast.makeText(getApplicationContext(),items[id] + " 선택했습니다.", Toast.LENGTH_SHORT).show();
                        if (items[id] == "재생"){

                            player.playAll();
                        }else if (items[id] == "삭제"){
                            player.setDirEmpty("/MyRecords/" + text);
                            //페이지 새로고침
                            Intent intent = new Intent(ReadingActivity.this, ReadingActivity.class);
                            startActivity(intent);
                            finish();
                        }

                        dialog.dismiss();
                    }
                });

        // 다이얼로그 생성
        AlertDialog alertDialog = alertDialogBuilder.create();

       // 다이얼로그 보여주기
        alertDialog.show();





        //Player player = new Player(this, "/MyRecords/" + text);
        //player.playAll();

    }




    public void updateBtnVisibility(boolean recording) {
        if (recording) {
            prepareBtn.setVisibility(View.GONE);
            recordBtn.setVisibility(View.VISIBLE);
            stopBtn.setVisibility(View.VISIBLE);
        } else {
            prepareBtn.setVisibility(View.VISIBLE);
            recordBtn.setVisibility(View.GONE);
            stopBtn.setVisibility(View.GONE);
        }
    }

    public void updateDataset() {
        myAdapter = new MyAdapter(recorder.getRecordList());
        myAdapter.setOnClickItemListener(this);
        mRecyclerView.swapAdapter(myAdapter, false);
    }
}
