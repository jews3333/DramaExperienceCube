package com.example.dramaexperiencecube;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dramaexperiencecube.adapter.ScriptAdapter;
import com.example.dramaexperiencecube.data.DramaScript;
import com.example.dramaexperiencecube.record.Player;
import com.example.dramaexperiencecube.record.Recorder;

import java.util.ArrayList;


public class PlayReadingActivity extends Activity {

    String[] MyPlanstr;
    TextView txt_where, txt_time, txt_make;
    ImageView location, location_1, location_2, location_3, location_4, location_5, location_6, location_7, location_8, location_9,
            human, human_1, human_2, human_3, human_4, human_5, human_6, human_7, human_8, human_9, human_10;
    Boolean human1 = true;
    Boolean human2 = true;
    Boolean human3 = true;
    Boolean human4 = true;
    ImageButton btn_home, btn_back;

    String get_where;
    String get_time;
    String get_location;
    ArrayList<String> get_humans;
    ArrayList<DramaScript> get_scripts;
    Recorder recorder;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    ScriptAdapter myAdapter;

    final Player player = new Player(this, "/DramaExperienceCube/records/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playreading);

        Intent intent = getIntent();
        get_where = intent.getStringExtra("where");
        get_time = intent.getStringExtra("time");
        get_location = intent.getStringExtra("location");
        get_humans = intent.getStringArrayListExtra("humans");
        get_scripts = intent.getParcelableArrayListExtra("scripts");

        // recyclerview 설정
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        myAdapter = new ScriptAdapter(get_scripts, true);
        mRecyclerView.setAdapter(myAdapter);

        player.playAll();
        myAdapter.updateSelection(0);

        myAdapter.setOnClickItemListener(new ScriptAdapter.OnClickItemListener() {
            @Override
            public void onClickItem(View item, int position) {
                player.stop();
                player.setPlayIndex(position);
                myAdapter.updateSelection(position);
                player.playAll();
            }
        });

        player.setOnCompletionListener(new Player.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer, int position) {
                myAdapter.updateSelection(position);
            }
        });

        View view = new View(PlayReadingActivity.this);

        txt_where = (TextView) findViewById(R.id.txt_where);
        txt_time = (TextView) findViewById(R.id.txt_time);
        location = (ImageView) findViewById(R.id.location);
        location_1 = (ImageView) findViewById(R.id.location_1);
        location_2 = (ImageView) findViewById(R.id.location_2);
        location_3 = (ImageView) findViewById(R.id.location_3);
        location_4 = (ImageView) findViewById(R.id.location_4);
        location_5 = (ImageView) findViewById(R.id.location_5);
        location_6 = (ImageView) findViewById(R.id.location_6);
        location_7 = (ImageView) findViewById(R.id.location_7);
        location_8 = (ImageView) findViewById(R.id.location_8);
        location_9 = (ImageView) findViewById(R.id.location_9);
        human = (ImageView) findViewById(R.id.human);
        human_1 = (ImageView) findViewById(R.id.human_1);
        human_2 = (ImageView) findViewById(R.id.human_2);
        human_3 = (ImageView) findViewById(R.id.human_3);
        human_4 = (ImageView) findViewById(R.id.human_4);
        human_5 = (ImageView) findViewById(R.id.human_5);
        human_6 = (ImageView) findViewById(R.id.human_6);
        human_7 = (ImageView) findViewById(R.id.human_7);
        human_8 = (ImageView) findViewById(R.id.human_8);
        human_9 = (ImageView) findViewById(R.id.human_9);
        human_10 = (ImageView) findViewById(R.id.human_10);
        ArrayList<String> humans = get_humans;
        try {
            String[] str_location = {"학교", "공원", "버스 정류소", "교실", "집", "운동장", "PC방", "도서관", "창원 시내"};
            String[] str_human = {"남학생", "여학생", "선생님", "아빠", "엄마", "호랑이", "사자", "코끼리", "곰", "여우"};
            MyPlanstr = intent.getStringArrayExtra("MyPlanstr");
            txt_where.setText("장면 : " + get_where);
            txt_time.setText("언제 : " + get_time);
//            txt_make.setText("대본 : " + MyPlanstr[7]);
            //배경 설정
            for (int i = 0; i < str_location.length; i++) {
                if (str_location[i].equals(get_location)) {
                    location.setVisibility(View.GONE);
                    if (i == 0) {
                        location_1.setVisibility(View.VISIBLE);
                    } else if (i == 1) {
                        location_2.setVisibility(View.VISIBLE);
                    } else if (i == 2) {
                        location_3.setVisibility(View.VISIBLE);
                    } else if (i == 3) {
                        location_4.setVisibility(View.VISIBLE);
                    } else if (i == 4) {
                        location_5.setVisibility(View.VISIBLE);
                    } else if (i == 5) {
                        location_6.setVisibility(View.VISIBLE);
                    } else if (i == 6) {
                        location_7.setVisibility(View.VISIBLE);
                    } else if (i == 7) {
                        location_8.setVisibility(View.VISIBLE);
                    } else if (i == 8) {
                        location_9.setVisibility(View.VISIBLE);
                    }
                    i = str_location.length;
                }

            }

            for (int j = 0; j < humans.size(); j++) {
                for (int i = 0; i < str_human.length; i++) {
                    if (humans.get(j).toString().equals(str_human[i])) {
                        if (i == 0) {
                            human_1.setVisibility(View.VISIBLE);
                        } else if (i == 1) {
                            human_2.setVisibility(View.VISIBLE);
                        } else if (i == 2) {
                            human_3.setVisibility(View.VISIBLE);
                        } else if (i == 3) {
                            human_4.setVisibility(View.VISIBLE);
                        } else if (i == 4) {
                            human_5.setVisibility(View.VISIBLE);
                        } else if (i == 5) {
                            human_6.setVisibility(View.VISIBLE);
                        } else if (i == 6) {
                            human_7.setVisibility(View.VISIBLE);
                        } else if (i == 7) {
                            human_8.setVisibility(View.VISIBLE);
                        } else if (i == 8) {
                            human_9.setVisibility(View.VISIBLE);
                        } else if (i == 9) {
                            human_10.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }

            txt_where.setText(get_where);
            txt_time.setText(get_time);
        } catch (Exception e) {
            System.out.println(e);
        }


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
                Intent intent = new Intent(PlayReadingActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.stop();
    }
}