package com.example.dramaexperiencecube;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class PlayReadingActivity extends Activity {

    String[] MyPlanstr;
    TextView txt_where, txt_time, txt_make;
    ImageView location, location_1, location_2, location_3, location_4, location_5, location_6, location_7, location_8, location_9,
              human, human_1, human_2, human_3, human_4, human_5, human_6, human_7, human_8, human_9, human_10;
    Boolean human1 = true;
    Boolean human2 = true;
    Boolean human3 = true;
    Boolean human4 = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playreading);
        View view = new View(PlayReadingActivity.this);


        txt_where = (TextView)findViewById(R.id.txt_where);
        txt_time = (TextView)findViewById(R.id.txt_time);
        txt_make = (TextView)findViewById(R.id.txt_make);
        location = (ImageView)findViewById(R.id.location);
        location_1 = (ImageView)findViewById(R.id.location_1);
        location_2 = (ImageView)findViewById(R.id.location_2);
        location_3 = (ImageView)findViewById(R.id.location_3);
        location_4 = (ImageView)findViewById(R.id.location_4);
        location_5 = (ImageView)findViewById(R.id.location_5);
        location_6 = (ImageView)findViewById(R.id.location_6);
        location_7 = (ImageView)findViewById(R.id.location_7);
        location_8 = (ImageView)findViewById(R.id.location_8);
        location_9 = (ImageView)findViewById(R.id.location_9);
        human = (ImageView)findViewById(R.id.human);
        human_1 = (ImageView)findViewById(R.id.human_1);
        human_2 = (ImageView)findViewById(R.id.human_2);
        human_3 = (ImageView)findViewById(R.id.human_3);
        human_4 = (ImageView)findViewById(R.id.human_4);
        human_5 = (ImageView)findViewById(R.id.human_5);
        human_6 = (ImageView)findViewById(R.id.human_6);
        human_7 = (ImageView)findViewById(R.id.human_7);
        human_8 = (ImageView)findViewById(R.id.human_8);
        human_9 = (ImageView)findViewById(R.id.human_9);
        human_10 = (ImageView)findViewById(R.id.human_10);

//        location.setVisibility(view.VISIBLE);
//        location_1.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
        try{
            String[] str_location = {"학교", "현장체험학습 장소", "버스 안", "교실", "집", "운동장", "PC방", "도서관", "창원 시내"};
            String[] str_human = {"해인(남학생)", "지민(여학생)", "선생님", "아빠", "엄마", "호랑이", "사자", "로봇", "할아버지", "요정"};
            MyPlanstr = intent.getStringArrayExtra("MyPlanstr");
            txt_where.setText("장면 : " + MyPlanstr[0]);
            txt_time.setText("때 : " + MyPlanstr[1]);
            txt_make.setText("대본 : " + MyPlanstr[7]);
            //배경 설정
            for(int i = 0; i < str_location.length; i++) {
                if (str_location[i].equals(MyPlanstr[2])) {
                    location.setVisibility(View.GONE);
                    if (i == 0) {
                        location_1.setVisibility(View.VISIBLE);
                    }
                    else if (i == 1) {
                        location_2.setVisibility(View.VISIBLE);
                    }
                    else if (i == 2) {
                        location_3.setVisibility(View.VISIBLE);
                    }
                    else if (i == 3) {
                        location_4.setVisibility(View.VISIBLE);
                    }
                    else if (i == 4) {
                        location_5.setVisibility(View.VISIBLE);
                    }
                    else if (i == 5) {
                        location_6.setVisibility(View.VISIBLE);
                    }
                    else if (i == 6) {
                        location_7.setVisibility(View.VISIBLE);
                    }
                    else if (i == 7) {
                        location_8.setVisibility(View.VISIBLE);
                    }
                    else if (i == 8) {
                        location_9.setVisibility(View.VISIBLE);
                    }
                    i = str_location.length;
                }

            }


            //인물 설정
            for(int i = 0; i < str_human.length; i++) {
                if (str_human[i].equals(MyPlanstr[3]) && human1) {
                    human1 = false;
                    if (i == 0) {
                        human_1.setVisibility(View.VISIBLE);
                    }
                    else if (i == 1) {
                        human_2.setVisibility(View.VISIBLE);
                    }
                    else if (i == 2) {
                        human_3.setVisibility(View.VISIBLE);
                    }
                    else if (i == 3) {
                        human_4.setVisibility(View.VISIBLE);
                    }
                    else if (i == 4) {
                        human_5.setVisibility(View.VISIBLE);
                    }
                    else if (i == 5) {
                        human_6.setVisibility(View.VISIBLE);
                    }
                    else if (i == 6) {
                        human_7.setVisibility(View.VISIBLE);
                    }
                    else if (i == 7) {
                        human_8.setVisibility(View.VISIBLE);
                    }
                    else if (i == 8) {
                        human_9.setVisibility(View.VISIBLE);
                    }
                    else if (i == 9) {
                        human_10.setVisibility(View.VISIBLE);
                    }
                }else if(MyPlanstr[3] != "" && human1){
//                    human.setVisibility(View.VISIBLE);
                }

                if (str_human[i].equals(MyPlanstr[4]) && human2) {
                    human2 = true;
                    if (i == 0) {
                        human_1.setVisibility(View.VISIBLE);
                    }
                    else if (i == 1) {
                        human_2.setVisibility(View.VISIBLE);
                    }
                    else if (i == 2) {
                        human_3.setVisibility(View.VISIBLE);
                    }
                    else if (i == 3) {
                        human_4.setVisibility(View.VISIBLE);
                    }
                    else if (i == 4) {
                        human_5.setVisibility(View.VISIBLE);
                    }
                    else if (i == 5) {
                        human_6.setVisibility(View.VISIBLE);
                    }
                    else if (i == 6) {
                        human_7.setVisibility(View.VISIBLE);
                    }
                    else if (i == 7) {
                        human_8.setVisibility(View.VISIBLE);
                    }
                    else if (i == 8) {
                        human_9.setVisibility(View.VISIBLE);
                    }
                    else if (i == 9) {
                        human_10.setVisibility(View.VISIBLE);
                    }
                }else if(MyPlanstr[4] != ""  && human2){
//                    human.setVisibility(View.VISIBLE);
                }

                if (str_human[i].equals(MyPlanstr[5]) && human3) {
                    human3 = false;
                    if (i == 0) {
                        human_1.setVisibility(View.VISIBLE);
                    }
                    else if (i == 1) {
                        human_2.setVisibility(View.VISIBLE);
                    }
                    else if (i == 2) {
                        human_3.setVisibility(View.VISIBLE);
                    }
                    else if (i == 3) {
                        human_4.setVisibility(View.VISIBLE);
                    }
                    else if (i == 4) {
                        human_5.setVisibility(View.VISIBLE);
                    }
                    else if (i == 5) {
                        human_6.setVisibility(View.VISIBLE);
                    }
                    else if (i == 6) {
                        human_7.setVisibility(View.VISIBLE);
                    }
                    else if (i == 7) {
                        human_8.setVisibility(View.VISIBLE);
                    }
                    else if (i == 8) {
                        human_9.setVisibility(View.VISIBLE);
                    }
                    else if (i == 9) {
                        human_10.setVisibility(View.VISIBLE);
                    }
                }else if(MyPlanstr[5] != "" && human3){
//                    human.setVisibility(View.VISIBLE);
                }

                if (str_human[i].equals(MyPlanstr[6]) && human4) {
                    human4 = false;
                    if (i == 0) {
                        human_1.setVisibility(View.VISIBLE);
                    }
                    else if (i == 1) {
                        human_2.setVisibility(View.VISIBLE);
                    }
                    else if (i == 2) {
                        human_3.setVisibility(View.VISIBLE);
                    }
                    else if (i == 3) {
                        human_4.setVisibility(View.VISIBLE);
                    }
                    else if (i == 4) {
                        human_5.setVisibility(View.VISIBLE);
                    }
                    else if (i == 5) {
                        human_6.setVisibility(View.VISIBLE);
                    }
                    else if (i == 6) {
                        human_7.setVisibility(View.VISIBLE);
                    }
                    else if (i == 7) {
                        human_8.setVisibility(View.VISIBLE);
                    }
                    else if (i == 8) {
                        human_9.setVisibility(View.VISIBLE);
                    }
                    else if (i == 9) {
                        human_10.setVisibility(View.VISIBLE);
                    }
                }else if(MyPlanstr[6] != "" && human4){
//                    human.setVisibility(View.VISIBLE);
                }
            }




//            Toast.makeText(PlayReadingActivity.this, MyPlanstr[0] + " : " + MyPlanstr[1] + " : " + MyPlanstr[2], Toast.LENGTH_SHORT).show();
//            Toast.makeText(PlayReadingActivity.this, MyPlanstr[3] + " : " + MyPlanstr[4] + " : " + MyPlanstr[5] + " : " + MyPlanstr[6], Toast.LENGTH_SHORT).show();
//            Toast.makeText(PlayReadingActivity.this, "LAST : " + MyPlanstr[7], Toast.LENGTH_SHORT).show();

            txt_where.setText(MyPlanstr[0]);
            txt_time.setText(MyPlanstr[1]);
//            txt_location.setText(MyPlanstr[2]);
//            txt_human.setText(MyPlanstr[3] + "  " + MyPlanstr[4] + "  " + MyPlanstr[5] + "  " + MyPlanstr[6]);
            txt_make.setText(MyPlanstr[7]);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
