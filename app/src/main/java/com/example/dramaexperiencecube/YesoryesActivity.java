package com.example.dramaexperiencecube;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Arrays;

public class YesoryesActivity extends AppCompatActivity {


    Button btn_Level1;
    Button btn_Level2;
    Button btn_All_Level;
    TextView txt_Level1;
    TextView txt_Level2;

    ImageButton btn_back,btn_home,btn_help;

    private boolean _isBtnDown1;
    private boolean _isBtnDown2;
    private boolean _isBtnDown3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yesoryes);
        final Handler handler = new Handler();

        final String[] str = {"웃다", "울다", "걷다", "절하다", "기다", "랩하다", "노래하다", "환호하다", "날다", "뛰다", "춤추다", "먹다", "놀라다"};
        int r = (int) (Math.random() * 12);

        txt_Level1 = (TextView) findViewById(R.id.txt_Level1);
        txt_Level2 = (TextView) findViewById(R.id.txt_Level2);

        btn_Level1 = (Button) findViewById(R.id.btn_Level1);
        btn_Level2 = (Button) findViewById(R.id.btn_Level2);
        btn_All_Level = (Button) findViewById(R.id.btn_All_Level);


        btn_Level1.setOnTouchListener(onBtnTouchListener1);
        btn_Level2.setOnTouchListener(onBtnTouchListener2);
        btn_All_Level.setOnTouchListener(onBtnTouchListener3);

        btn_help = (ImageButton)findViewById(R.id.btn_help);
        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YesoryesActivity.this, YesorysesHelpActivity.class);
                startActivity(intent);
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
                Intent intent = new Intent(YesoryesActivity.this, MainActivity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


    }

    private View.OnTouchListener onBtnTouchListener3 = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    _isBtnDown3 = true;
                    onBtnDown3();
                    break;
                case MotionEvent.ACTION_UP:
                    _isBtnDown3 = false;
                    break;
                default:
                    break;
            }
            return false;
        }
    };


    private View.OnTouchListener onBtnTouchListener1 = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    _isBtnDown1 = true;
                    onBtnDown1();
                    break;
                case MotionEvent.ACTION_UP:
                    _isBtnDown1 = false;
                    break;
                default:
                    break;
            }
            return false;
        }
    };

    private View.OnTouchListener onBtnTouchListener2 = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    _isBtnDown2 = true;
                    onBtnDown2();
                    break;
                case MotionEvent.ACTION_UP:
                    _isBtnDown2 = false;
                    break;
                default:
                    break;
            }
            return false;
        }
    };

    private void onBtnDown1() {
        TouchThread1 kThread1 = new TouchThread1();
        kThread1.start();
    }

    private void onBtnDown2() {
        TouchThread2 kThread2 = new TouchThread2();
        kThread2.start();
    }
    private void onBtnDown3() {
        TouchThread3 kThread3 = new TouchThread3();
        kThread3.start();
    }

    private class TouchThread1 extends Thread {
        @Override
        public void run() {
            super.run();
            while (_isBtnDown1) {
                //touchHandler1.sendEmptyMessage(9876);
                RejectTxt1();
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class TouchThread2 extends Thread {
        @Override
        public void run() {
            super.run();
            while (_isBtnDown2) {
                //touchHandler2.sendEmptyMessage(9876);
                RejectTxt2();
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class TouchThread3 extends Thread {
        @Override
        public void run() {
            super.run();
            while (_isBtnDown3) {
                RejectTxt1();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                RejectTxt2();
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public void RejectTxt1() {
        final String[] str = {"웃거나", "울거나", "걷거나", "절하거나", "기거나", "랩하거나", "노래하거나", "환호하거나", "날거나", "뛰거나", "춤추거나", "먹거나", "놀라거나"};
        final int r = (int) (Math.random() * 12);

        if (Reject(1, (String)txt_Level2.getText(), r)) {
            RejectTxt1();
        } else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            txt_Level1.setText(str[r]);
                        }
                    });
                }
            }).start();
        }
    }

    public void RejectTxt2() {
        final String[] str = {"웃는", "우는", "걷는", "절하는", "기는", "랩하는", "노래하는", "환호하는", "나는", "뛰는", "춤추는", "먹는", "놀라는"};
        final int r = (int) (Math.random() * 12);

        if (Reject(2, (String)txt_Level1.getText(), r)) {
            RejectTxt2();
        } else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            txt_Level2.setText(str[r]);
                        }
                    });
                }
            }).start();
        }
    }

    public boolean Reject(int num, String txt, int r) {
        final String[] str1 = {"웃거나", "울거나", "걷거나", "절하거나", "기거나", "랩하거나", "노래하거나", "환호하거나", "날거나", "뛰거나", "춤추거나", "먹거나", "놀라거나"};
        final String[] str2 = {"웃는", "우는", "걷는", "절하는", "기는", "랩하는", "노래하는", "환호하는", "나는", "뛰는", "춤추는", "먹는", "놀라는"};
        boolean result = false;

        if(num == 1){
            if(txt.equals(str2[r])){
                return true;
            }else {
                return false;
            }
        }else if(num == 2) {
            if(txt.equals(str1[r])){
                return true;
            }else {
                return false;
            }
        }
        return true;
    }


}

