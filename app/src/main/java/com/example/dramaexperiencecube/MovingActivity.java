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
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MovingActivity extends AppCompatActivity {

    ImageButton btn_back,btn_home;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moving);

        LinearLayout ll = (LinearLayout)findViewById(R.id.drawing);

        MyView m = new MyView(ll.getContext());

        ll.addView(m);

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
                Intent intent = new Intent(MovingActivity.this, MainActivity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}

class MyView extends View {
    Paint paint = new Paint();
    Path path = new Path();

    public MyView(Context context) {
        super(context);
        paint.setStyle(Paint.Style.STROKE); // 선이 그려지도록
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10f); // 선의 굵기 지정
    }
    @Override
    protected void onDraw(Canvas canvas) { // 화면을 그려주는 메서드

        Bitmap grid = BitmapFactory.decodeResource(getResources(),R.drawable.grid);
        grid = Bitmap.createScaledBitmap(grid, 600, 260, true);

        canvas.drawBitmap(grid,0,0,paint);
        canvas.drawColor(Color.TRANSPARENT);
        canvas.drawPath(path, paint); // 저장된 path 를 그려라
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN :
                path.moveTo(x, y); // 자취에 그리지 말고 위치만 이동해라
                break;
            case MotionEvent.ACTION_MOVE :
                path.lineTo(x, y); // 자취에 선을 그려라
                break;
            case MotionEvent.ACTION_UP :
                break;
        }

        invalidate(); // 화면을 다시그려라

        return true;
    }
}
