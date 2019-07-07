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
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    ImageButton btn_back, btn_home;
    String[] MyPlanstr;
    boolean isRecording = false;
    boolean getTxt = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);


            final LinearLayout layout_make = (LinearLayout)findViewById(R.id.layout_make);
            final TextView txt_where = (TextView)findViewById(R.id.txt_where);
            final TextView txt_time = (TextView)findViewById(R.id.txt_time);
            final TextView txt_location = (TextView)findViewById(R.id.txt_location);
            final TextView txt_human = (TextView)findViewById(R.id.txt_human);
            final TextView txt_make = (TextView)findViewById(R.id.txt_make);
            Intent intent = getIntent();


        try {
            MyPlanstr = intent.getStringArrayExtra("MyPlanstr");
                layout_make.setVisibility(View.VISIBLE);
                txt_where.setVisibility(View.VISIBLE);
                txt_time.setVisibility(View.VISIBLE);
                txt_location.setVisibility(View.VISIBLE);
                txt_human.setVisibility(View.VISIBLE);
                txt_make.setVisibility(View.VISIBLE);
                txt_where.setText(MyPlanstr[0]);
                txt_time.setText(MyPlanstr[1]);
                txt_location.setText(MyPlanstr[2]);
                txt_human.setText(MyPlanstr[3] + "  " + MyPlanstr[4] + "  " + MyPlanstr[5] + "  " + MyPlanstr[6]);
                txt_make.setText(MyPlanstr[7]);
            getTxt = true;
        }catch (Exception e){
            System.out.println(" : "  + e);
        }



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
                Intent intent = new Intent(ReadingActivity.this, MainActivity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
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
                            Intent intent = new Intent(ReadingActivity.this, PlayReadingActivity.class);
                            if(getTxt){
                                intent.putExtra("MyPlanstr", MyPlanstr);
                                startActivity(intent);
                            }

                            player.playAll();

                        } else if (items[id] == "삭제"){

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
