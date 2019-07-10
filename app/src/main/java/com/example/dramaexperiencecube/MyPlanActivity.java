package com.example.dramaexperiencecube;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dramaexperiencecube.data.Drama;
import com.example.dramaexperiencecube.data.DramaScript;
import com.example.dramaexperiencecube.dialog.ScriptDialog;

import java.util.ArrayList;

public class MyPlanActivity extends AppCompatActivity {
    boolean[] humanSelected = new boolean[10];
    Drama drama;
    ImageButton btn_home, btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myplan);

        drama = new Drama();

        final EditText edittext = findViewById(R.id.edit_txt);

        //장면
        final LinearLayout layout_where = findViewById(R.id.layout_where);
        final Button btn_where = findViewById(R.id.btn_where);
        final Button btn_where1 = findViewById(R.id.btn_where1);
        final Button btn_where2 = findViewById(R.id.btn_where2);
        final Button btn_where3 = findViewById(R.id.btn_where3);

        //때
        final LinearLayout layout_time = findViewById(R.id.layout_time);
        final Button btn_time = findViewById(R.id.btn_time);
        final Button btn_time1 = findViewById(R.id.btn_time1);
        final Button btn_time2 = findViewById(R.id.btn_time2);
        final Button btn_time3 = findViewById(R.id.btn_time3);
        final Button btn_time4 = findViewById(R.id.btn_time4);
        final Button btn_time5 = findViewById(R.id.btn_time5);

        //장소
        final LinearLayout layout_location = findViewById(R.id.layout_location);
        final Button btn_location = findViewById(R.id.btn_location);
        final Button btn_location1 = findViewById(R.id.btn_location1);
        final Button btn_location2 = findViewById(R.id.btn_location2);
        final Button btn_location3 = findViewById(R.id.btn_location3);
        final Button btn_location4 = findViewById(R.id.btn_location4);
        final Button btn_location5 = findViewById(R.id.btn_location5);
        final Button btn_location6 = findViewById(R.id.btn_location6);
        final Button btn_location7 = findViewById(R.id.btn_location7);
        final Button btn_location8 = findViewById(R.id.btn_location8);
        final Button btn_location9 = findViewById(R.id.btn_location9);

        //인물
        final LinearLayout layout_human = findViewById(R.id.layout_human);
        final Button btn_human = findViewById(R.id.btn_human);
        final Button btn_human1 = findViewById(R.id.btn_human1);
        final Button btn_human2 = findViewById(R.id.btn_human2);
        final Button btn_human3 = findViewById(R.id.btn_human3);
        final Button btn_human4 = findViewById(R.id.btn_human4);
        final Button btn_human5 = findViewById(R.id.btn_human5);
        final Button btn_human6 = findViewById(R.id.btn_human6);
        final Button btn_human7 = findViewById(R.id.btn_human7);
        final Button btn_human8 = findViewById(R.id.btn_human8);
        final Button btn_human9 = findViewById(R.id.btn_human9);
        final Button btn_human10 = findViewById(R.id.btn_human10);

        //만들기
        final LinearLayout layout_make = findViewById(R.id.layout_make);
        final TextView txt_where = findViewById(R.id.txt_where);
        final TextView txt_time = findViewById(R.id.txt_time);
        final TextView txt_location = findViewById(R.id.txt_location);
        final TextView txt_human = findViewById(R.id.txt_human);
        final Button btn_reading = findViewById(R.id.btn_reading);
        final Button btn_make = findViewById(R.id.btn_make);
        final ListView list_scripts = findViewById(R.id.list_scripts);

        //장면
        Button[] whereBtns = new Button[]{btn_where1, btn_where2, btn_where3};
        for (final Button btn : whereBtns) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    drama.setWhere(btn.getText().toString());

                    layout_where.setVisibility(View.GONE);
                    btn_where1.setVisibility(View.GONE);
                    btn_where2.setVisibility(View.GONE);
                    btn_where3.setVisibility(View.GONE);
                    btn_where.setVisibility(View.GONE);

                    layout_time.setVisibility(View.VISIBLE);
                    btn_time1.setVisibility(View.VISIBLE);
                    btn_time2.setVisibility(View.VISIBLE);
                    btn_time3.setVisibility(View.VISIBLE);
                    btn_time4.setVisibility(View.VISIBLE);
                    btn_time5.setVisibility(View.VISIBLE);
                    btn_time.setVisibility(View.VISIBLE);
                    edittext.setText("");
                }
            });
        }

        btn_where.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drama.setWhere(edittext.getText().toString());

                layout_where.setVisibility(View.GONE);
                btn_where1.setVisibility(View.GONE);
                btn_where2.setVisibility(View.GONE);
                btn_where3.setVisibility(View.GONE);
                btn_where.setVisibility(View.GONE);

                layout_time.setVisibility(View.VISIBLE);
                btn_time1.setVisibility(View.VISIBLE);
                btn_time2.setVisibility(View.VISIBLE);
                btn_time3.setVisibility(View.VISIBLE);
                btn_time4.setVisibility(View.VISIBLE);
                btn_time5.setVisibility(View.VISIBLE);
                btn_time.setVisibility(View.VISIBLE);
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

                    layout_time.setVisibility(View.GONE);
                    btn_time1.setVisibility(View.GONE);
                    btn_time2.setVisibility(View.GONE);
                    btn_time3.setVisibility(View.GONE);
                    btn_time4.setVisibility(View.GONE);
                    btn_time5.setVisibility(View.GONE);
                    btn_time.setVisibility(View.GONE);

                    layout_location.setVisibility(View.VISIBLE);
                    btn_location1.setVisibility(View.VISIBLE);
                    btn_location2.setVisibility(View.VISIBLE);
                    btn_location3.setVisibility(View.VISIBLE);
                    btn_location4.setVisibility(View.VISIBLE);
                    btn_location5.setVisibility(View.VISIBLE);
                    btn_location6.setVisibility(View.VISIBLE);
                    btn_location7.setVisibility(View.VISIBLE);
                    btn_location8.setVisibility(View.VISIBLE);
                    btn_location9.setVisibility(View.VISIBLE);
                    btn_location.setVisibility(View.VISIBLE);
                    edittext.setText("");
                }
            });
        }

        btn_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drama.setTime(edittext.getText().toString());

                layout_time.setVisibility(View.GONE);
                btn_time1.setVisibility(View.GONE);
                btn_time2.setVisibility(View.GONE);
                btn_time3.setVisibility(View.GONE);
                btn_time4.setVisibility(View.GONE);
                btn_time5.setVisibility(View.GONE);
                btn_time.setVisibility(View.GONE);

                layout_location.setVisibility(View.VISIBLE);
                btn_location1.setVisibility(View.VISIBLE);
                btn_location2.setVisibility(View.VISIBLE);
                btn_location3.setVisibility(View.VISIBLE);
                btn_location4.setVisibility(View.VISIBLE);
                btn_location5.setVisibility(View.VISIBLE);
                btn_location6.setVisibility(View.VISIBLE);
                btn_location7.setVisibility(View.VISIBLE);
                btn_location8.setVisibility(View.VISIBLE);
                btn_location9.setVisibility(View.VISIBLE);
                btn_location.setVisibility(View.VISIBLE);
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

                    layout_location.setVisibility(View.GONE);
                    btn_location1.setVisibility(View.GONE);
                    btn_location2.setVisibility(View.GONE);
                    btn_location3.setVisibility(View.GONE);
                    btn_location4.setVisibility(View.GONE);
                    btn_location5.setVisibility(View.GONE);
                    btn_location6.setVisibility(View.GONE);
                    btn_location7.setVisibility(View.GONE);
                    btn_location8.setVisibility(View.GONE);
                    btn_location9.setVisibility(View.GONE);
                    btn_location.setVisibility(View.GONE);

                    layout_human.setVisibility(View.VISIBLE);
                    btn_human.setVisibility(View.VISIBLE);
                    btn_human1.setVisibility(View.VISIBLE);
                    btn_human2.setVisibility(View.VISIBLE);
                    btn_human3.setVisibility(View.VISIBLE);
                    btn_human4.setVisibility(View.VISIBLE);
                    btn_human5.setVisibility(View.VISIBLE);
                    btn_human6.setVisibility(View.VISIBLE);
                    btn_human7.setVisibility(View.VISIBLE);
                    btn_human8.setVisibility(View.VISIBLE);
                    btn_human9.setVisibility(View.VISIBLE);
                    btn_human10.setVisibility(View.VISIBLE);

                    edittext.setText("");
                }
            });
        }

        btn_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drama.setLocation(edittext.getText().toString());

                layout_location.setVisibility(View.GONE);
                btn_location1.setVisibility(View.GONE);
                btn_location2.setVisibility(View.GONE);
                btn_location3.setVisibility(View.GONE);
                btn_location4.setVisibility(View.GONE);
                btn_location5.setVisibility(View.GONE);
                btn_location6.setVisibility(View.GONE);
                btn_location7.setVisibility(View.GONE);
                btn_location8.setVisibility(View.GONE);
                btn_location9.setVisibility(View.GONE);
                btn_location.setVisibility(View.GONE);

                layout_human.setVisibility(View.VISIBLE);
                btn_human.setVisibility(View.VISIBLE);
                btn_human1.setVisibility(View.VISIBLE);
                btn_human2.setVisibility(View.VISIBLE);
                btn_human3.setVisibility(View.VISIBLE);
                btn_human4.setVisibility(View.VISIBLE);
                btn_human5.setVisibility(View.VISIBLE);
                btn_human6.setVisibility(View.VISIBLE);
                btn_human7.setVisibility(View.VISIBLE);
                btn_human8.setVisibility(View.VISIBLE);
                btn_human9.setVisibility(View.VISIBLE);
                btn_human10.setVisibility(View.VISIBLE);

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
                String humanName = edittext.getText().toString();

                if (!humanName.equals("")) {
                    ArrayList<String> humans = drama.getHumans();
                    humans.add(humanName);
                    drama.setHumans(humans);
                }

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

        btn_back = findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_home = findViewById(R.id.btn_home);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyPlanActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    final ArrayList<String> arraylist = new ArrayList<String>();
    public void setListScripts(String selectedHuman, String script){
        arraylist.add(selectedHuman + " : " + script);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraylist){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                TextView item = (TextView) super.getView(position,convertView,parent);
                item.setTextColor(Color.parseColor("#FFFFFF"));
                return item;
            }
        };
        final ListView list = findViewById(R.id.list_scripts);
        list.setAdapter(adapter);
    }
}