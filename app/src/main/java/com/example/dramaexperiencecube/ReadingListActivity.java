package com.example.dramaexperiencecube;

import android.content.Intent;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.dramaexperiencecube.adapter.DramaAdapter;
import com.example.dramaexperiencecube.data.DramaScript;
import com.example.dramaexperiencecube.dbmanager.DramaRoomDB;
import com.example.dramaexperiencecube.dbmanager.table.DramaDB;
import com.example.dramaexperiencecube.dbmanager.table.DramaScriptDB;
import com.example.dramaexperiencecube.dbmanager.table.HumanDB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.example.dramaexperiencecube.ReadingActivity.context;

public class ReadingListActivity extends AppCompatActivity {
    private RecyclerView rvDrama;
    private DramaAdapter dramaAdapter;
    private Button btnSelect;

    private DramaRoomDB dramaRoomDB;

    ImageButton btn_home, btn_back;

    private static final int GET_LIST = 100;
    private static final int INSERT_SUCCESS = 200;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case GET_LIST:
                    List<DramaDB> items = (List<DramaDB>) (msg.obj);
                    if (items.size() == 0) {
                        createData();
                    }
                    dramaAdapter.setItems((ArrayList<DramaDB>) items);
                    break;

                case INSERT_SUCCESS:
                    new SelectAsyncTask().execute();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_list);

        rvDrama = (RecyclerView) findViewById(R.id.recycler_view);
        btnSelect = (Button) findViewById(R.id.btn_select);
        btnSelect.setVisibility(View.GONE);

        dramaAdapter = new DramaAdapter();
        rvDrama.setLayoutManager(new LinearLayoutManager(this));
        rvDrama.setAdapter(dramaAdapter);

        btn_back = (ImageButton) findViewById(R.id.btn_back);
        btn_home = (ImageButton) findViewById(R.id.btn_home);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReadingListActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


        new SelectAsyncTask().execute();
    }

    private void createData() {
        new InsertAsyncTask().execute();
    }
    private class InsertAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            DramaDB dramaDB = new DramaDB();
            dramaDB.setTitle("현장체험학습 날, 친구들과 함께 도시락을 먹는 상황");
            dramaDB.setWhere("현장체험학습 날, 친구들과 함께 도시락을 먹는 상황");
            dramaDB.setLocation("공원");
            dramaDB.setTime("점심시간");

            ArrayList<String> humans = new ArrayList<>();
            humans.add("남학생");
            humans.add("여학생");
            humans.add("선생님");
            humans.add("곰");

            ArrayList<DramaScript> scripts = new ArrayList<>();

//            남학생
//            우리 상남동 가서 놀지 않을래?
//            여학생
//            좋아 !! 너 돈 있어? ㅋㅋ
//            호랑이
//            어흥 너희들 여기서 뭐하고 있니?
//            남학생
//            헉! 넌 누구니?
//            호랑이
//            난 이숲의 정령이란다.

            DramaScript script = new DramaScript();
            script.setHuman("선생님");
            script.setScript("우리반 친구들~ 위험한 곳에 가지 말고 이 나무 근처에서 도시락을 먹어요!");
            script.setAudioPath("ex");
            scripts.add(script);

            script = new DramaScript();
            script.setHuman("여학생");
            script.setScript("민국아~ 우리 저 바위 뒤에 가서 김밥 먹자.");
            script.setAudioPath("ex");
            scripts.add(script);

            script = new DramaScript();
            script.setHuman("남학생");
            script.setScript("안돼. 선생님이 위험한 곳에 가지 말라고 하셨는데...");
            script.setAudioPath("ex");
            scripts.add(script);

            script = new DramaScript();
            script.setHuman("여학생");
            script.setScript("괜찮아, 빨리 가보자!");
            script.setAudioPath("ex");
            scripts.add(script);

            script = new DramaScript();
            script.setHuman("곰");
            script.setScript("어서와 친구들! 안그래도 배가 고팠는데, 어서 그 도시락을 나에게 줘.");
            script.setAudioPath("ex");
            scripts.add(script);


                copyAssets();


            dramaRoomDB = DramaRoomDB.getDatabase(getApplicationContext());
            long id = dramaRoomDB.DramaDao().insert(dramaDB);

            if (id > 0) {
                for (String item : humans) {
                    HumanDB human = new HumanDB();
                    human.setDrama_id(id);
                    human.setName(item);
                    dramaRoomDB.humanDao().insert(human);
                }

                for (DramaScript item : scripts) {
                    DramaScriptDB scriptDB = new DramaScriptDB();
                    scriptDB.setDrama_id(id);
                    scriptDB.setHuman(item.getHuman());
                    scriptDB.setAudioPath(item.getAudioPath());
                    scriptDB.setScript(item.getScript());

                    dramaRoomDB.scriptDao().insert(scriptDB);
                }
            }

            Message msg = mHandler.obtainMessage();
            msg.obj = id;
            msg.what = INSERT_SUCCESS;

            mHandler.sendMessage(msg);

            return null;
        }
    }

    private class SelectAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                dramaRoomDB = DramaRoomDB.getDatabase(getApplicationContext());
                Message msg = mHandler.obtainMessage();
                msg.what = GET_LIST;
                msg.obj = dramaRoomDB.DramaDao().getDrama();

                mHandler.sendMessage(msg);
            } catch (Exception e) {

            }

            return null;
        }
    }

    private void copyAssets() {
        //폴더 생성
        String dirPath  = Environment.getExternalStorageDirectory().toString()
                +"/DramaExperienceCube/records/";
        File file = new File(dirPath);
        if( !file.exists() ){  // 원하는 경로에 폴더가 있는지 확인
            file.mkdirs();
        }else{
            Log.d("폴더 생성 : ", "폴더 확인 필요");
        }



        AssetManager assetManager = getAssets();
        String[] files = null;
        try {
            files = assetManager.list("");
        } catch (IOException e) {
            Log.e("tag", "Failed to get asset file list.", e);
        }
        if (files != null) for (String filename : files) {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open(filename);
                File outFile = new File(Environment.getExternalStorageDirectory().toString()
                        +"/DramaExperienceCube/records/", filename);
//                File outFile = new File(getExternalFilesDir(null), filename);

                out = new FileOutputStream(outFile);
                copyFile(in, out);
            } catch(IOException e) {
                Log.e("tag", "Failed to copy asset file: " + filename, e);
            }
            finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        // NOOP
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        // NOOP
                    }
                }
            }
        }
    }
    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }
}
