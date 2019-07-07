package com.example.dramaexperiencecube;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MyPlanActivity extends AppCompatActivity {

    EditText edit_txt;
    LinearLayout layout_where, layout_time, layout_location, layout_human;
    Button btn_where, btn_where1,btn_where2,btn_where3;
    Button btn_time, btn_time1, btn_time2, btn_time3, btn_time4, btn_time5;
    Button btn_location, btn_location1, btn_location2, btn_location3, btn_location4, btn_location5, btn_location6, btn_location7, btn_location8, btn_location9;
    Button btn_human, btn_human1, btn_human2, btn_human3, btn_human4, btn_human5, btn_human6, btn_human7, btn_human8, btn_human9, btn_human10, btn_human11;
    Button btn_make;
    TextView txt_where, txt_time, txt_location, txt_human;
    Button btn_reading;
    Boolean human = false;
    Boolean human1 = false;
    Boolean human2 = false;
    Boolean human3 = false;
    Boolean human4 = false;
    Boolean human5 = false;
    Boolean human6 = false;
    Boolean human7 = false;
    Boolean human8 = false;
    Boolean human9 = false;
    Boolean human10 = false;
    Boolean human11 = false;
    int cnt_human = 0;


    final String[] MyPlanstr = new String[8];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myplan);

        final EditText edittext = (EditText)findViewById(R.id.edit_txt);

        //장면
        final LinearLayout layout_where = (LinearLayout)findViewById(R.id.layout_where);
        final Button btn_where = (Button)findViewById(R.id.btn_where);
        final Button btn_where1 = (Button)findViewById(R.id.btn_where1);
        final Button btn_where2 = (Button)findViewById(R.id.btn_where2);
        final Button btn_where3 = (Button)findViewById(R.id.btn_where3);

        //때
        final LinearLayout layout_time = (LinearLayout)findViewById(R.id.layout_time);
        final Button btn_time = (Button)findViewById(R.id.btn_time);
        final Button btn_time1 = (Button)findViewById(R.id.btn_time1);
        final Button btn_time2 = (Button)findViewById(R.id.btn_time2);
        final Button btn_time3 = (Button)findViewById(R.id.btn_time3);
        final Button btn_time4 = (Button)findViewById(R.id.btn_time4);
        final Button btn_time5 = (Button)findViewById(R.id.btn_time5);

        //장소
        final LinearLayout layout_location = (LinearLayout)findViewById(R.id.layout_location);
        final Button btn_location = (Button)findViewById(R.id.btn_location);
        final Button btn_location1 = (Button)findViewById(R.id.btn_location1);
        final Button btn_location2 = (Button)findViewById(R.id.btn_location2);
        final Button btn_location3 = (Button)findViewById(R.id.btn_location3);
        final Button btn_location4 = (Button)findViewById(R.id.btn_location4);
        final Button btn_location5 = (Button)findViewById(R.id.btn_location5);
        final Button btn_location6 = (Button)findViewById(R.id.btn_location6);
        final Button btn_location7 = (Button)findViewById(R.id.btn_location7);
        final Button btn_location8 = (Button)findViewById(R.id.btn_location8);
        final Button btn_location9 = (Button)findViewById(R.id.btn_location9);

        //인물
        final LinearLayout layout_human = (LinearLayout)findViewById(R.id.layout_human);
        final Button btn_human = (Button)findViewById(R.id.btn_human);
        final Button btn_human1 = (Button)findViewById(R.id.btn_human1);
        final Button btn_human2 = (Button)findViewById(R.id.btn_human2);
        final Button btn_human3 = (Button)findViewById(R.id.btn_human3);
        final Button btn_human4 = (Button)findViewById(R.id.btn_human4);
        final Button btn_human5 = (Button)findViewById(R.id.btn_human5);
        final Button btn_human6 = (Button)findViewById(R.id.btn_human6);
        final Button btn_human7 = (Button)findViewById(R.id.btn_human7);
        final Button btn_human8 = (Button)findViewById(R.id.btn_human8);
        final Button btn_human9 = (Button)findViewById(R.id.btn_human9);
        final Button btn_human10 = (Button)findViewById(R.id.btn_human10);
        final Button btn_human11 = (Button)findViewById(R.id.btn_human11);

        //만들기
        final LinearLayout layout_make = (LinearLayout)findViewById(R.id.layout_make);
        final TextView txt_where = (TextView)findViewById(R.id.txt_where);
        final TextView txt_time = (TextView)findViewById(R.id.txt_time);
        final TextView txt_location = (TextView)findViewById(R.id.txt_location);
        final TextView txt_human = (TextView)findViewById(R.id.txt_human);
        final Button btn_reading = (Button)findViewById(R.id.btn_reading);
        final Button btn_make = (Button)findViewById(R.id.btn_make);

        //장면
        btn_where1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPlanstr[0] = (String) btn_where1.getText();

                layout_where.setVisibility(view.GONE);
                btn_where1.setVisibility(view.GONE);
                btn_where2.setVisibility(view.GONE);
                btn_where3.setVisibility(view.GONE);
                btn_where.setVisibility(view.GONE);

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

        btn_where2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPlanstr[0] = (String) btn_where2.getText();
                layout_where.setVisibility(view.GONE);
                btn_where1.setVisibility(view.GONE);
                btn_where2.setVisibility(view.GONE);
                btn_where3.setVisibility(view.GONE);
                btn_where.setVisibility(view.GONE);

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

        btn_where3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPlanstr[0] = (String) btn_where3.getText();
                layout_where.setVisibility(view.GONE);
                btn_where1.setVisibility(view.GONE);
                btn_where2.setVisibility(view.GONE);
                btn_where3.setVisibility(view.GONE);
                btn_where.setVisibility(view.GONE);

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

        btn_where.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPlanstr[0] = edittext.getText().toString();
                layout_where.setVisibility(view.GONE);
                btn_where1.setVisibility(view.GONE);
                btn_where2.setVisibility(view.GONE);
                btn_where3.setVisibility(view.GONE);
                btn_where.setVisibility(view.GONE);

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
        btn_time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPlanstr[1] = (String) btn_time1.getText();
                layout_time.setVisibility(view.GONE);
                btn_time1.setVisibility(view.GONE);
                btn_time2.setVisibility(view.GONE);
                btn_time3.setVisibility(view.GONE);
                btn_time4.setVisibility(view.GONE);
                btn_time5.setVisibility(view.GONE);
                btn_time.setVisibility(view.GONE);

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

        btn_time2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPlanstr[1] = (String) btn_time2.getText();
                layout_time.setVisibility(view.GONE);
                btn_time1.setVisibility(view.GONE);
                btn_time2.setVisibility(view.GONE);
                btn_time3.setVisibility(view.GONE);
                btn_time4.setVisibility(view.GONE);
                btn_time5.setVisibility(view.GONE);
                btn_time.setVisibility(view.GONE);

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

        btn_time3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPlanstr[1] = (String) btn_time3.getText();
                layout_time.setVisibility(view.GONE);
                btn_time1.setVisibility(view.GONE);
                btn_time2.setVisibility(view.GONE);
                btn_time3.setVisibility(view.GONE);
                btn_time4.setVisibility(view.GONE);
                btn_time5.setVisibility(view.GONE);
                btn_time.setVisibility(view.GONE);

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

        btn_time4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPlanstr[1] = (String) btn_time4.getText();
                layout_time.setVisibility(view.GONE);
                btn_time1.setVisibility(view.GONE);
                btn_time2.setVisibility(view.GONE);
                btn_time3.setVisibility(view.GONE);
                btn_time4.setVisibility(view.GONE);
                btn_time5.setVisibility(view.GONE);
                btn_time.setVisibility(view.GONE);

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

        btn_time5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPlanstr[1] = (String) btn_time5.getText();
                layout_time.setVisibility(view.GONE);
                btn_time1.setVisibility(view.GONE);
                btn_time2.setVisibility(view.GONE);
                btn_time3.setVisibility(view.GONE);
                btn_time4.setVisibility(view.GONE);
                btn_time5.setVisibility(view.GONE);
                btn_time.setVisibility(view.GONE);

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

        btn_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPlanstr[1] =  edittext.getText().toString();
                layout_time.setVisibility(view.GONE);
                btn_time1.setVisibility(view.GONE);
                btn_time2.setVisibility(view.GONE);
                btn_time3.setVisibility(view.GONE);
                btn_time4.setVisibility(view.GONE);
                btn_time5.setVisibility(view.GONE);
                btn_time.setVisibility(view.GONE);

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
        btn_location1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPlanstr[2] = (String) btn_location1.getText();
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
                btn_human11.setVisibility(view.VISIBLE);

                edittext.setText("");
                btn_human.setText("선택");
            }
        });

        btn_location2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPlanstr[2] = (String) btn_location2.getText();
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
                btn_human11.setVisibility(view.VISIBLE);

                edittext.setText("");
                btn_human.setText("선택");
            }
        });

        btn_location3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPlanstr[2] = (String) btn_location3.getText();
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
                btn_human11.setVisibility(view.VISIBLE);

                edittext.setText("");
                btn_human.setText("선택");
            }
        });

        btn_location4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPlanstr[2] = (String) btn_location4.getText();
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
                btn_human11.setVisibility(view.VISIBLE);

                edittext.setText("");
                btn_human.setText("선택");
            }
        });

        btn_location5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPlanstr[2] = (String) btn_location5.getText();
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
                btn_human11.setVisibility(view.VISIBLE);

                edittext.setText("");
                btn_human.setText("선택");
            }
        });

        btn_location6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPlanstr[2] = (String) btn_location6.getText();
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
                btn_human11.setVisibility(view.VISIBLE);

                edittext.setText("");
                btn_human.setText("선택");
            }
        });

        btn_location7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPlanstr[2] = (String) btn_location7.getText();
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
                btn_human11.setVisibility(view.VISIBLE);

                edittext.setText("");
                btn_human.setText("선택");
            }
        });

        btn_location8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPlanstr[2] = (String) btn_location8.getText();
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
                btn_human11.setVisibility(view.VISIBLE);

                edittext.setText("");
                btn_human.setText("선택");
            }
        });

        btn_location9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPlanstr[2] = (String) btn_location9.getText();
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
                btn_human11.setVisibility(view.VISIBLE);

                edittext.setText("");
                btn_human.setText("선택");
            }
        });

        btn_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPlanstr[2] =  edittext.getText().toString();
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
                btn_human11.setVisibility(view.VISIBLE);

                edittext.setText("");
                btn_human.setText("선택");
            }
        });


        //인물
        btn_human1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(human1){
                    btn_human1.setTextColor(Color.BLACK);
                    cnt_human--;
                    human1 = false;
                }else{
                    btn_human1.setTextColor(Color.BLUE);
                    cnt_human++;
                    human1 = true;
                }
            }
        });

        btn_human2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(human2){
                    btn_human2.setTextColor(Color.BLACK);
                    cnt_human--;
                    human2 = false;
                }else{
                    btn_human2.setTextColor(Color.BLUE);
                    cnt_human++;
                    human2 = true;
                }
            }
        });

        btn_human3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(human3){
                    btn_human3.setTextColor(Color.BLACK);
                    cnt_human--;
                    human3 = false;
                }else{
                    btn_human3.setTextColor(Color.BLUE);
                    cnt_human++;
                    human3 = true;
                }
            }
        });

        btn_human4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(human4){
                    btn_human4.setTextColor(Color.BLACK);
                    cnt_human--;
                    human4 = false;
                }else{
                    btn_human4.setTextColor(Color.BLUE);
                    cnt_human++;
                    human4 = true;
                }
            }
        });

        btn_human5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(human5){
                    btn_human5.setTextColor(Color.BLACK);
                    cnt_human--;
                    human5 = false;
                }else{
                    btn_human5.setTextColor(Color.BLUE);
                    cnt_human++;
                    human5 = true;
                }
            }
        });

        btn_human6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(human6){
                    btn_human6.setTextColor(Color.BLACK);
                    cnt_human--;
                    human6 = false;
                }else{
                    btn_human6.setTextColor(Color.BLUE);
                    cnt_human++;
                    human6 = true;
                }
            }
        });


        btn_human7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(human7){
                    btn_human7.setTextColor(Color.BLACK);
                    cnt_human--;
                    human7 = false;
                }else{
                    btn_human7.setTextColor(Color.BLUE);
                    cnt_human++;
                    human7 = true;
                }
            }
        });

        btn_human8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(human8){
                    btn_human8.setTextColor(Color.BLACK);
                    cnt_human--;
                    human8 = false;
                }else{
                    btn_human8.setTextColor(Color.BLUE);
                    cnt_human++;
                    human8 = true;
                }
            }
        });

        btn_human9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(human9){
                    btn_human9.setTextColor(Color.BLACK);
                    cnt_human--;
                    human9 = false;
                }else{
                    btn_human9.setTextColor(Color.BLUE);
                    cnt_human++;
                    human9 = true;
                }
            }
        });

        btn_human10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(human10){
                    btn_human10.setTextColor(Color.BLACK);
                    cnt_human--;
                    human10 = false;
                }else{
                    btn_human10.setTextColor(Color.BLUE);
                    cnt_human++;
                    human10 = true;
                }
            }
        });

        btn_human11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(human11){
                    btn_human11.setTextColor(Color.BLACK);
                    cnt_human--;
                    human11 = false;
                }else{
                    btn_human11.setTextColor(Color.BLUE);
                    cnt_human++;
                    human11 = true;
                }
            }
        });

        btn_human.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cnt_human >= 5){
                    Toast.makeText(MyPlanActivity.this, "선택한 인물들이 많아요.", Toast.LENGTH_LONG).show();
                }else{
                    int cnt = 3;
                    if(human1){
                        MyPlanstr[cnt] = btn_human1.getText().toString();
                        cnt++;
                    }
                    if(human2){
                        MyPlanstr[cnt] = btn_human2.getText().toString();
                        cnt++;
                    }
                    if(human3){
                        MyPlanstr[cnt] = btn_human3.getText().toString();
                        cnt++;
                    }
                    if(human4){
                        MyPlanstr[cnt] = btn_human4.getText().toString();
                        cnt++;
                    }
                    if(human5){
                        MyPlanstr[cnt] = btn_human5.getText().toString();
                        cnt++;
                    }
                    if(human6){
                        MyPlanstr[cnt] = btn_human6.getText().toString();
                        cnt++;
                    }
                    if(human7){
                        MyPlanstr[cnt] = btn_human7.getText().toString();
                        cnt++;
                    }
                    if(human8){
                        MyPlanstr[cnt] = btn_human8.getText().toString();
                        cnt++;
                    }
                    if(human9){
                        MyPlanstr[cnt] = btn_human9.getText().toString();
                        cnt++;
                    }
                    if(human10){
                        MyPlanstr[cnt] = btn_human10.getText().toString();
                        cnt++;
                    }
                    if(human11){
                        MyPlanstr[cnt] =  edittext.getText().toString();
                        cnt++;
                    }
                    layout_human.setVisibility(view.GONE);
                    btn_human.setVisibility(view.GONE);
                    btn_human1.setVisibility(view.GONE);
                    btn_human2.setVisibility(view.GONE);
                    btn_human3.setVisibility(view.GONE);
                    btn_human4.setVisibility(view.GONE);
                    btn_human5.setVisibility(view.GONE);
                    btn_human6.setVisibility(view.GONE);
                    btn_human7.setVisibility(view.GONE);
                    btn_human8.setVisibility(view.GONE);
                    btn_human9.setVisibility(view.GONE);
                    btn_human10.setVisibility(view.GONE);
                    btn_human11.setVisibility(view.GONE);

                    layout_make.setVisibility(view.VISIBLE);
                    txt_where.setVisibility(view.VISIBLE);
                    txt_time.setVisibility(view.VISIBLE);
                    txt_location.setVisibility(view.VISIBLE);
                    txt_human.setVisibility(view.VISIBLE);
                    txt_where.setText(MyPlanstr[0]);
                    txt_time.setText(MyPlanstr[1]);
                    txt_location.setText(MyPlanstr[2]);
                    if(MyPlanstr[3] == null){
                        MyPlanstr[3] = "";
                    }
                    if(MyPlanstr[4] == null){
                        MyPlanstr[4] = "";
                    }
                    if(MyPlanstr[5] == null){
                        MyPlanstr[5] = "";
                    }
                    if(MyPlanstr[6] == null){
                        MyPlanstr[6] = "";
                    }
                    txt_human.setText(MyPlanstr[3] + "  " + MyPlanstr[4] + "  " + MyPlanstr[5] + "  " + MyPlanstr[6]);
                    btn_reading.setVisibility(view.VISIBLE);
                    edittext.setText("");
                }
            }
        });

        btn_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyPlanActivity.this, ReadingActivity.class);
                if(!edittext.getText().toString().isEmpty()){
                    MyPlanstr[7] = edittext.getText().toString();
                }else{
                    MyPlanstr[7] = "";
                }
                intent.putExtra("MyPlanstr", MyPlanstr);
                startActivity(intent);
            }
        });
    }


}
