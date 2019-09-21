package com.example.dramaexperiencecube;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dramaexperiencecube.data.Drama;
import com.example.dramaexperiencecube.data.DramaScript;
import com.example.dramaexperiencecube.dbmanager.DramaRoomDB;
import com.example.dramaexperiencecube.dbmanager.table.DramaDB;
import com.example.dramaexperiencecube.dbmanager.table.DramaScriptDB;
import com.example.dramaexperiencecube.dbmanager.table.HumanDB;
import com.example.dramaexperiencecube.dialog.ScriptDialog;

import java.util.ArrayList;

public class MyPlanActivity extends AppCompatActivity {
    boolean[] humanSelected = new boolean[10];
    ImageButton btn_home, btn_back;
    Drama drama;
    private DramaRoomDB dramaRoomDB;

    EditText edittext;
    LinearLayout layout_where, layout_time, layout_location, layout_human, ll_myBottom, ll_myBottom2, layout_make;

    Button btn_where, btn_where1, btn_where2, btn_where3, btn_where4, btn_where5, btn_where6,
            btn_time, btn_time1, btn_time2, btn_time3, btn_time4, btn_time5,
            btn_location, btn_location1, btn_location2, btn_location3, btn_location4, btn_location5, btn_location6, btn_location7, btn_location8, btn_location9,
            btn_human, btn_human1, btn_human2, btn_human3, btn_human4, btn_human5,
            btn_human6, btn_human7, btn_human8, btn_human9, btn_human10,
            btn_reading, btn_make, btn_save, btn_remove;


    TextView txt_where, txt_time, txt_location, txt_human;

    ListView list_scripts;

    private long editMode = -1;

    private int selectedScriptItemPoi = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myplan);

        drama = new Drama();

        edittext = (EditText) findViewById(R.id.edit_txt);

        //장면
        layout_where = (LinearLayout) findViewById(R.id.layout_where);
        btn_where = (Button) findViewById(R.id.btn_where);
        btn_where1 = (Button) findViewById(R.id.btn_where1);
        btn_where2 = (Button) findViewById(R.id.btn_where2);
        btn_where3 = (Button) findViewById(R.id.btn_where3);
        btn_where4 = (Button) findViewById(R.id.btn_where4);
        btn_where5 = (Button) findViewById(R.id.btn_where5);
        btn_where6 = (Button) findViewById(R.id.btn_where6);

        //때
        layout_time = (LinearLayout) findViewById(R.id.layout_time);
        btn_time = (Button) findViewById(R.id.btn_time);
        btn_time1 = (Button) findViewById(R.id.btn_time1);
        btn_time2 = (Button) findViewById(R.id.btn_time2);
        btn_time3 = (Button) findViewById(R.id.btn_time3);
        btn_time4 = (Button) findViewById(R.id.btn_time4);
        btn_time5 = (Button) findViewById(R.id.btn_time5);

        //장소
        layout_location = (LinearLayout) findViewById(R.id.layout_location);
        btn_location = (Button) findViewById(R.id.btn_location);
        btn_location1 = (Button) findViewById(R.id.btn_location1);
        btn_location2 = (Button) findViewById(R.id.btn_location2);
        btn_location3 = (Button) findViewById(R.id.btn_location3);
        btn_location4 = (Button) findViewById(R.id.btn_location4);
        btn_location5 = (Button) findViewById(R.id.btn_location5);
        btn_location6 = (Button) findViewById(R.id.btn_location6);
        btn_location7 = (Button) findViewById(R.id.btn_location7);
        btn_location8 = (Button) findViewById(R.id.btn_location8);
        btn_location9 = (Button) findViewById(R.id.btn_location9);

        //인물
        layout_human = (LinearLayout) findViewById(R.id.layout_human);
        btn_human = (Button) findViewById(R.id.btn_human);
        btn_human1 = (Button) findViewById(R.id.btn_human1);
        btn_human2 = (Button) findViewById(R.id.btn_human2);
        btn_human3 = (Button) findViewById(R.id.btn_human3);
        btn_human4 = (Button) findViewById(R.id.btn_human4);
        btn_human5 = (Button) findViewById(R.id.btn_human5);
        btn_human6 = (Button) findViewById(R.id.btn_human6);
        btn_human7 = (Button) findViewById(R.id.btn_human7);
        btn_human8 = (Button) findViewById(R.id.btn_human8);
        btn_human9 = (Button) findViewById(R.id.btn_human9);
        btn_human10 = (Button) findViewById(R.id.btn_human10);

        ll_myBottom = findViewById(R.id.MyPlan_Bottom);
        ll_myBottom2 = findViewById(R.id.MyPlan_Bottom2);

        //만들기
        layout_make = (LinearLayout) findViewById(R.id.layout_make);
        txt_where = (TextView) findViewById(R.id.txt_where);
        txt_time = (TextView) findViewById(R.id.txt_time);
        txt_location = (TextView) findViewById(R.id.txt_location);
        txt_human = (TextView) findViewById(R.id.txt_human);
        btn_reading = (Button) findViewById(R.id.btn_reading);
        btn_make = (Button) findViewById(R.id.btn_make);
        list_scripts = (ListView) findViewById(R.id.list_scripts);

        btn_save = findViewById(R.id.btn_save);
        btn_remove = findViewById(R.id.btn_remove);

        // editMode true이면 수정 모드이고 현제 클레스에서 editMode에 -1이 아니면 저장된 db아이디 임.
        if (getIntent().getBooleanExtra("EditMode", false)) {
            editMode = getIntent().getIntExtra("ID", -1);
            Toast.makeText(this, "수정모드 입니다.", Toast.LENGTH_SHORT).show();
            drama = getIntent().getParcelableExtra("Drama");

            refreshScript();
            editor();
        }

        //장면
        Button[] whereBtns = new Button[]{btn_where1, btn_where2, btn_where3, btn_where4, btn_where5, btn_where6};
        for (final Button btn : whereBtns) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    drama.setWhere(btn.getText().toString());

                    layout_where.setVisibility(view.GONE);
                    btn_where1.setVisibility(view.GONE);
                    btn_where2.setVisibility(view.GONE);
                    btn_where3.setVisibility(view.GONE);
                    btn_where4.setVisibility(view.GONE);
                    btn_where5.setVisibility(view.GONE);
                    btn_where6.setVisibility(view.GONE);
                    btn_where.setVisibility(view.GONE);
                    ll_myBottom2.setVisibility(View.GONE);

                    ll_myBottom.setVisibility(View.VISIBLE);
                    layout_time.setVisibility(view.VISIBLE);
                    btn_time1.setVisibility(view.VISIBLE);
                    btn_time2.setVisibility(view.VISIBLE);
                    btn_time3.setVisibility(view.VISIBLE);
                    btn_time4.setVisibility(view.VISIBLE);
                    btn_time5.setVisibility(view.VISIBLE);
                    btn_time.setVisibility(view.VISIBLE);
                    edittext.setText("");
                }
            });
        }

        btn_where.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drama.setWhere(edittext.getText().toString());

                layout_where.setVisibility(view.GONE);
                btn_where1.setVisibility(view.GONE);
                btn_where2.setVisibility(view.GONE);
                btn_where3.setVisibility(view.GONE);
                btn_where.setVisibility(view.GONE);
                ll_myBottom2.setVisibility(View.GONE);

                ll_myBottom.setVisibility(View.VISIBLE);
                layout_time.setVisibility(view.VISIBLE);
                btn_time1.setVisibility(view.VISIBLE);
                btn_time2.setVisibility(view.VISIBLE);
                btn_time3.setVisibility(view.VISIBLE);
                btn_time4.setVisibility(view.VISIBLE);
                btn_time5.setVisibility(view.VISIBLE);
                btn_time.setVisibility(view.VISIBLE);
                edittext.setText("");
            }
        });


        //때
        Button[] timeBtns = new Button[]{btn_time, btn_time1, btn_time2, btn_time3, btn_time4, btn_time5};
        for (final Button btn : timeBtns) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    drama.setTime(btn.getText().toString());

                    layout_time.setVisibility(view.GONE);
                    btn_time1.setVisibility(view.GONE);
                    btn_time2.setVisibility(view.GONE);
                    btn_time3.setVisibility(view.GONE);
                    btn_time4.setVisibility(view.GONE);
                    btn_time5.setVisibility(view.GONE);
                    btn_time.setVisibility(view.GONE);
                    ll_myBottom2.setVisibility(View.GONE);

                    ll_myBottom.setVisibility(View.VISIBLE);
                    layout_location.setVisibility(view.VISIBLE);
                    btn_location1.setVisibility(view.VISIBLE);
                    btn_location2.setVisibility(view.VISIBLE);
                    btn_location3.setVisibility(view.VISIBLE);
                    btn_location4.setVisibility(view.VISIBLE);
                    btn_location5.setVisibility(view.VISIBLE);
                    btn_location6.setVisibility(view.VISIBLE);
                    btn_location7.setVisibility(view.VISIBLE);
                    btn_location8.setVisibility(view.VISIBLE);
                    btn_location9.setVisibility(view.VISIBLE);
                    btn_location.setVisibility(view.VISIBLE);
                    edittext.setText("");
                }
            });
        }

        btn_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drama.setTime(edittext.getText().toString());

                layout_time.setVisibility(view.GONE);
                btn_time1.setVisibility(view.GONE);
                btn_time2.setVisibility(view.GONE);
                btn_time3.setVisibility(view.GONE);
                btn_time4.setVisibility(view.GONE);
                btn_time5.setVisibility(view.GONE);
                btn_time.setVisibility(view.GONE);
                ll_myBottom2.setVisibility(View.GONE);

                ll_myBottom.setVisibility(View.VISIBLE);
                layout_location.setVisibility(view.VISIBLE);
                btn_location1.setVisibility(view.VISIBLE);
                btn_location2.setVisibility(view.VISIBLE);
                btn_location3.setVisibility(view.VISIBLE);
                btn_location4.setVisibility(view.VISIBLE);
                btn_location5.setVisibility(view.VISIBLE);
                btn_location6.setVisibility(view.VISIBLE);
                btn_location7.setVisibility(view.VISIBLE);
                btn_location8.setVisibility(view.VISIBLE);
                btn_location9.setVisibility(view.VISIBLE);
                btn_location.setVisibility(view.VISIBLE);
                edittext.setText("");
            }
        });


        //장소
        Button[] locationBtns = new Button[]{btn_location, btn_location1, btn_location2, btn_location3, btn_location4, btn_location5, btn_location6, btn_location7, btn_location8, btn_location9};
        for (final Button btn : locationBtns) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    drama.setLocation(btn.getText().toString());

                    layout_location.setVisibility(view.GONE);
                    btn_location1.setVisibility(view.GONE);
                    btn_location2.setVisibility(view.GONE);
                    btn_location3.setVisibility(view.GONE);
                    btn_location4.setVisibility(view.GONE);
                    btn_location5.setVisibility(view.GONE);
                    btn_location6.setVisibility(view.GONE);
                    btn_location7.setVisibility(view.GONE);
                    btn_location8.setVisibility(view.GONE);
                    btn_location9.setVisibility(view.GONE);
                    btn_location.setVisibility(view.GONE);
                    ll_myBottom2.setVisibility(View.GONE);

                    ll_myBottom.setVisibility(View.VISIBLE);
                    layout_human.setVisibility(view.VISIBLE);
                    btn_human.setVisibility(view.VISIBLE);
                    btn_human1.setVisibility(view.VISIBLE);
                    btn_human2.setVisibility(view.VISIBLE);
                    btn_human3.setVisibility(view.VISIBLE);
                    btn_human4.setVisibility(view.VISIBLE);
                    btn_human5.setVisibility(view.VISIBLE);
                    btn_human6.setVisibility(view.VISIBLE);
                    btn_human7.setVisibility(view.VISIBLE);
                    btn_human8.setVisibility(view.VISIBLE);
                    btn_human9.setVisibility(view.VISIBLE);
                    btn_human10.setVisibility(view.VISIBLE);

                    edittext.setText("");
                }
            });
        }

        btn_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drama.setLocation(edittext.getText().toString());

                layout_location.setVisibility(view.GONE);
                btn_location1.setVisibility(view.GONE);
                btn_location2.setVisibility(view.GONE);
                btn_location3.setVisibility(view.GONE);
                btn_location4.setVisibility(view.GONE);
                btn_location5.setVisibility(view.GONE);
                btn_location6.setVisibility(view.GONE);
                btn_location7.setVisibility(view.GONE);
                btn_location8.setVisibility(view.GONE);
                btn_location9.setVisibility(view.GONE);
                btn_location.setVisibility(view.GONE);
                ll_myBottom2.setVisibility(View.GONE);

                ll_myBottom.setVisibility(View.VISIBLE);
                layout_human.setVisibility(view.VISIBLE);
                btn_human.setVisibility(view.VISIBLE);
                btn_human1.setVisibility(view.VISIBLE);
                btn_human2.setVisibility(view.VISIBLE);
                btn_human3.setVisibility(view.VISIBLE);
                btn_human4.setVisibility(view.VISIBLE);
                btn_human5.setVisibility(view.VISIBLE);
                btn_human6.setVisibility(view.VISIBLE);
                btn_human7.setVisibility(view.VISIBLE);
                btn_human8.setVisibility(view.VISIBLE);
                btn_human9.setVisibility(view.VISIBLE);
                btn_human10.setVisibility(view.VISIBLE);

                edittext.setText("");
            }
        });

        // 인물
        Button[] humanBtns = new Button[]{btn_human1, btn_human2, btn_human3, btn_human4, btn_human5, btn_human6, btn_human7, btn_human8, btn_human9, btn_human10};
        for (int i = 0; i < humanBtns.length; i++) {
            final Button btn = humanBtns[i];
            final int index = i;

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean selected = humanSelected[index];
                    ArrayList<String> humans = drama.getHumans();
                    String humanName = btn.getText().toString();

                    if (selected) {
                        btn.setTextColor(Color.BLACK);
                        humans.remove(humanName);
                    } else {
                        btn.setTextColor(Color.BLUE);
                        humans.add(humanName);
                    }

                    drama.setHumans(humans);
                    humanSelected[index] = !selected;
                }
            });
        }

        btn_human.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor();
            }
        });

        // 대본 추가
        btn_make.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScriptDialog dialog = new ScriptDialog(MyPlanActivity.this, drama.getHumans());
                dialog.setOnDialogButtonClickListener(new ScriptDialog.OnDialogButtonClickListener() {
                    @Override
                    public void onClick(String selectedHuman, String script) {
                        DramaScript dramaScript = new DramaScript();
                        dramaScript.setHuman(selectedHuman);
                        dramaScript.setScript(script);
                        setListScripts(selectedHuman, script);

                        ArrayList<DramaScript> scripts = drama.getScripts();
                        scripts.add(dramaScript);
                        drama.setScripts(scripts);
                    }
                });
                dialog.show();
            }
        });

        // 대본 리딩으로 이동
        btn_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyPlanActivity.this, ReadingActivity.class);
                intent.putExtra("where", drama.getWhere());
                intent.putExtra("time", drama.getTime());
                intent.putExtra("location", drama.getLocation());
                intent.putStringArrayListExtra("humans", drama.getHumans());
                intent.putParcelableArrayListExtra("scripts", drama.getScripts());
                startActivity(intent);
            }
        });

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
                Intent intent = new Intent(MyPlanActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editMode == -1) {
                    new InsertAsyncTask().execute(drama);
                } else {
                    new UpdateAsyncTask(editMode).execute(drama);
                }
            }
        });

        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedScriptItemPoi >= 0 && drama.getScripts().size() >= selectedScriptItemPoi) {
                    drama.getScripts().remove(selectedScriptItemPoi);
                    adapter.clear();
                    refreshScript();
                }
            }
        });

        list_scripts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedScriptItemPoi = i;
            }
        });
    }

    private void refreshScript() {
        for (DramaScript script : drama.getScripts()) {
            setListScripts(script.getHuman(), script.getScript());
        }
    }

    private void editor() {
        String humanName = edittext.getText().toString();

        if (!humanName.equals("")) {
            ArrayList<String> humans = drama.getHumans();
            humans.add(humanName);
            drama.setHumans(humans);
        }

        layout_where.setVisibility(View.GONE);
        btn_where1.setVisibility(View.GONE);
        btn_where2.setVisibility(View.GONE);
        btn_where3.setVisibility(View.GONE);
        btn_where.setVisibility(View.GONE);

        layout_human.setVisibility(View.GONE);
        btn_human.setVisibility(View.GONE);
        btn_human1.setVisibility(View.GONE);
        btn_human2.setVisibility(View.GONE);
        btn_human3.setVisibility(View.GONE);
        btn_human4.setVisibility(View.GONE);
        btn_human5.setVisibility(View.GONE);
        btn_human6.setVisibility(View.GONE);
        btn_human7.setVisibility(View.GONE);
        btn_human8.setVisibility(View.GONE);
        btn_human9.setVisibility(View.GONE);
        btn_human10.setVisibility(View.GONE);
        edittext.setVisibility(View.GONE);
        ll_myBottom.setVisibility(View.GONE);

        ll_myBottom2.setVisibility(View.VISIBLE);
        layout_make.setVisibility(View.VISIBLE);
        txt_where.setVisibility(View.VISIBLE);
        txt_time.setVisibility(View.VISIBLE);
        txt_location.setVisibility(View.VISIBLE);
        txt_human.setVisibility(View.VISIBLE);
        btn_reading.setVisibility(View.VISIBLE);
        btn_make.setVisibility(View.VISIBLE);
        list_scripts.setVisibility(View.VISIBLE);

        txt_where.setText(drama.getWhere());
        txt_time.setText(drama.getTime());
        txt_location.setText(drama.getLocation());
        txt_human.setText(drama.getHumans().toString());
    }

    ArrayList<String> arraylist = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    public void setListScripts(String selectedHuman, String script) {
        arraylist.add(selectedHuman + " : " + script);
        adapter = new ArrayAdapter<String>(this, R.layout.item_simple_list_1, arraylist) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView item = (TextView) super.getView(position, convertView, parent);
                item.setTextColor(Color.parseColor("#FFFFFF"));
                return item;
            }
        };
        final ListView list = (ListView) findViewById(R.id.list_scripts);
        list.setAdapter(adapter);
    }

    private final int INSERT_SUCCESS = 100;
    private final int UPDATE_SUCCESS = 200;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case INSERT_SUCCESS:
                    Toast.makeText(MyPlanActivity.this, "저장되었습니다.", Toast.LENGTH_SHORT).show();

                    editMode = (long) msg.obj;
                    adapter.clear();
                    refreshScript();
                    editor();
                    Toast.makeText(MyPlanActivity.this, "수정모드 입니다.", Toast.LENGTH_SHORT).show();
                    break;
                case UPDATE_SUCCESS:
                    Toast.makeText(MyPlanActivity.this, "수정되었습니다.", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    private class InsertAsyncTask extends AsyncTask<Drama, Void, Void> {

        @Override
        protected Void doInBackground(Drama... dramas) {
            DramaDB dramaDB = new DramaDB();
            dramaDB.setTitle(dramas[0].getWhere());
            dramaDB.setWhere(dramas[0].getWhere());
            dramaDB.setLocation(dramas[0].getLocation());
            dramaDB.setTime(dramas[0].getTime());

            dramaRoomDB = DramaRoomDB.getDatabase(getApplicationContext());
            long id = dramaRoomDB.DramaDao().insert(dramaDB);

            Message msg = mHandler.obtainMessage();
            msg.obj = id;
            msg.what = INSERT_SUCCESS;

            if (id > 0) {
                for (String item : dramas[0].getHumans()) {
                    HumanDB human = new HumanDB();
                    human.setDrama_id(id);
                    human.setName(item);
                    dramaRoomDB.humanDao().insert(human);
                }

                for (DramaScript script : dramas[0].getScripts()) {
                    DramaScriptDB scriptDB = new DramaScriptDB();
                    scriptDB.setDrama_id(id);
                    scriptDB.setHuman(script.getHuman());
                    scriptDB.setScript(script.getScript());
                    scriptDB.setAudioPath(script.getAudioPath());
                    dramaRoomDB.scriptDao().insert(scriptDB);
                }
            }

            mHandler.sendMessage(msg);

            return null;
        }
    }

    private class UpdateAsyncTask extends AsyncTask<Drama, Void, Void> {
        private long id;

        public UpdateAsyncTask(long id) {
            this.id = id;
        }

        @Override
        protected Void doInBackground(Drama... dramas) {
            DramaDB dramaDB = new DramaDB();
            dramaDB.setId(id);
            dramaDB.setTitle(dramas[0].getWhere());
            dramaDB.setWhere(dramas[0].getWhere());
            dramaDB.setLocation(dramas[0].getLocation());
            dramaDB.setTime(dramas[0].getTime());

            dramaRoomDB = DramaRoomDB.getDatabase(getApplicationContext());
            dramaRoomDB.DramaDao().update(dramaDB);

            if (id > 0) {
//                dramaRoomDB.humanDao().deleteAll(id);
                dramaRoomDB.scriptDao().deleteAll(id);
//
//                for (String item : dramas[0].getHumans()) {
//                    HumanDB human = new HumanDB();
//                    human.setDrama_id(id);
//                    human.setName(item);
//                    dramaRoomDB.humanDao().insert(human);
//                }

                for (DramaScript script : dramas[0].getScripts()) {
                    DramaScriptDB scriptDB = new DramaScriptDB();
                    scriptDB.setDrama_id(id);
                    scriptDB.setHuman(script.getHuman());
                    scriptDB.setScript(script.getScript());
                    scriptDB.setAudioPath(script.getAudioPath());
                    dramaRoomDB.scriptDao().insert(scriptDB);
                }
            }

            mHandler.sendEmptyMessage(UPDATE_SUCCESS);

            return null;
        }
    }
}