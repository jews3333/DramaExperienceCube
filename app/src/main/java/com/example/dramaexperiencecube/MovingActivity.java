package com.example.dramaexperiencecube;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MovingActivity extends AppCompatActivity {

    ImageButton btn_back, btn_home;
    Button btn_black, btn_red, btn_blue, btn_green, btn_yellow, btn_clear, btn_stroytelling;

    private int color = Color.BLACK;
    private float r = 10f;

    List<MyView.PathInfo> data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moving);


        //drawing 레이아웃에 뷰 상속
        LinearLayout ll = (LinearLayout) findViewById(R.id.drawing);
        final MyView m = new MyView(ll.getContext());

        m.setPaintInfo(color, r);

        ll.addView(m);

        btn_black = (Button) findViewById(R.id.btn_black);
        btn_black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = Color.BLACK;
                m.setPaintInfo(color, r);
            }
        });

        btn_red = (Button) findViewById(R.id.btn_red);
        btn_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = Color.RED;
                m.setPaintInfo(color, r);
            }
        });

        btn_blue = (Button) findViewById(R.id.btn_blue);
        btn_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = Color.BLUE;
                m.setPaintInfo(color, r);
            }
        });

        btn_green = (Button) findViewById(R.id.btn_green);
        btn_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = Color.GREEN;
                m.setPaintInfo(color, r);
            }
        });

        btn_yellow = (Button) findViewById(R.id.btn_yellow);
        btn_yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = Color.YELLOW;
                m.setPaintInfo(color, r);
            }
        });

        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = Color.BLACK;
                m.setPaintInfo(color, r);
                data.clear();
                m.invalidate();
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
                Intent intent = new Intent(MovingActivity.this, MainActivity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btn_stroytelling = findViewById(R.id.btn_stroytelling);
        btn_stroytelling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MovingActivity.this, StoryTellingEndActivity.class));
            }
        });
    }

    class MyView extends View {
        private Paint paint;
        //protected List<PathInfo> data;
        // Path path = new Path();

        private PathInfo pathInfo;

        public void setPaintInfo(int color, float r) {
            paint = new Paint();
            paint.setColor(color);

            paint.setStyle(Paint.Style.STROKE);

            paint.setStrokeWidth(r);

            pathInfo = new PathInfo();
            pathInfo.setPaint(paint);
        }

        public MyView(Context context) {
            super(context);

            paint = new Paint();

            paint.setStyle(Paint.Style.STROKE); // 선이 그려지도록
            paint.setColor(Color.RED);
            paint.setStrokeWidth(10f); // 선의 굵기 지정

            data = new ArrayList<>();
        }

        @Override
        protected void onDraw(Canvas canvas) { // 화면을 그려주는 메서드

            int width = canvas.getWidth();
            int height = canvas.getHeight();

            Bitmap grid = BitmapFactory.decodeResource(getResources(), R.drawable.grid);
            Bitmap resize_grid = Bitmap.createScaledBitmap(grid, width, height, true);

            canvas.drawBitmap(resize_grid, 10, 10, paint);
            canvas.drawARGB(80, 255, 255, 255);
            //canvas.drawPath(path, paint); // 저장된 path 를 그려라

            for (PathInfo p : data) {
                canvas.drawPath(p, p.getPaint());
            }

            super.onDraw(canvas);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {


            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    pathInfo.moveTo(event.getX(), event.getY()); // 자취에 그리지 말고 위치만 이동해라
                    break;
                case MotionEvent.ACTION_MOVE:
                    pathInfo.lineTo(event.getX(), event.getY()); // 자취에 선을 그려라
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }

            data.add(pathInfo);

            invalidate(); // 화면을 다시그려라

            return true;
        }


        class PathInfo extends Path {
            private Paint paint;

            PathInfo() {
                paint = new Paint();
            }

            public Paint getPaint() {
                return paint;
            }

            public void setPaint(Paint paint) {
                this.paint = paint;
            }
        }

    }
}




