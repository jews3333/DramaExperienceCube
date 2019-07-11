package com.example.dramaexperiencecube;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.dramaexperiencecube.adapter.ScriptAdapter;
import com.example.dramaexperiencecube.data.DramaScript;
import com.example.dramaexperiencecube.dialog.RecordDialog;
import com.example.dramaexperiencecube.record.Player;
import com.example.dramaexperiencecube.record.Recorder;

import java.util.ArrayList;


public class ReadingActivity extends AppCompatActivity implements ScriptAdapter.OnClickItemListener {

    Recorder recorder;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    ScriptAdapter myAdapter;

    Button btn_goplan;

    ImageButton btn_back, btn_home;
    boolean isRecording = false;
    boolean isPlaying = false;

    String where;
    String time;
    String location;
    ArrayList<String> humans;
    ArrayList<DramaScript> scripts;

    RecordDialog recordDialog;
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);

        context = this;

        Intent intent = getIntent();
        where = intent.getStringExtra("where");
        time = intent.getStringExtra("time");
        location = intent.getStringExtra("location");
        humans = intent.getStringArrayListExtra("humans");
        scripts = intent.getParcelableArrayListExtra("scripts");

        recorder = new Recorder(this, "/DramaExperienceCube/records/");
        recorder.empty();

        // recyclerview 설정
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        myAdapter = new ScriptAdapter(scripts);
        myAdapter.setOnClickItemListener(this);
        mRecyclerView.setAdapter(myAdapter);

        btn_back = (ImageButton) findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_home = (ImageButton) findViewById(R.id.btn_home);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReadingActivity.this, MainActivity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btn_goplan = (Button)findViewById(R.id.btn_goplan);

        // 연극 시작으로 이동
        btn_goplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReadingActivity.this, PlayReadingActivity.class);
                intent.putExtra("where", where);
                intent.putExtra("time", time);
                intent.putExtra("location", location);
                intent.putStringArrayListExtra("humans", humans);
                intent.putParcelableArrayListExtra("scripts", scripts);
                startActivity(intent);
            }
        });
    }



    @Override
    public void onClickItem(View item, final int position) {
        final DramaScript script = scripts.get(position);
        final Player player = new Player(this, "/DramaExperienceCube/records/");
        recordDialog = new RecordDialog(this, script);

        recordDialog.setOOnDialogItemClickListener(new RecordDialog.OnDialogItemClickListener() {
            @Override
            public void onClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tv = (TextView) view;
                String filename = position + "";

                if (i == 0) { // 녹음/중지
                    if (isRecording) { // 중지
                        recorder.stopRecord();
                        tv.setText("녹음");
                        isRecording = false;
                    } else { // 녹음
                        recorder.record(filename);
                        script.setAudioPath(filename);
                        tv.setText("중지");
                        isRecording = true;
                    }
                } else { // 재생/중지
                    if (isPlaying) { // 중지
                        player.stop();
                        tv.setText("재생");
                        isPlaying = false;
                    } else { // 재생
                        player.play(filename);
                        tv.setText("중지");
                        isPlaying = true;
                    }
                }
            }
        });

        recordDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if (isRecording) {
                    recorder.stopRecord();
                    isRecording = false;
                }
                if (isPlaying) {
                    player.stop();
                    isPlaying = false;
                }
                updateDataset();
            }
        });

        recordDialog.show();
    }



    public void updateDataset() {
        myAdapter = new ScriptAdapter(scripts);
        myAdapter.setOnClickItemListener(this);
        mRecyclerView.swapAdapter(myAdapter, false);
    }

    public void getActive(){
        Intent intent = new Intent(ReadingActivity.this, PlayReadingActivity.class);
        intent.putExtra("where", where);
        intent.putExtra("time", time);
        intent.putExtra("location", location);
        intent.putStringArrayListExtra("humans", humans);
        intent.putParcelableArrayListExtra("scripts", scripts);
        startActivity(intent);
    }
}