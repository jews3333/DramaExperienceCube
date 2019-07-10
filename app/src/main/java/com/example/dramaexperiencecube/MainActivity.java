package com.example.dramaexperiencecube;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
//Main화면, 시작화면
    Button btn_sub_activity1,btn_sub_activity2;
    ImageButton btn_help;
    static final int PERMISSON=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //권한이 부여되어 있는지 확인
        getAll_permissions();




        btn_sub_activity1 = findViewById(R.id.btn_subActivity1);
        btn_sub_activity2 = findViewById(R.id.btn_subActivity2);

        btn_sub_activity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubActivity1.class);
                startActivity(intent);
            }
        });

        btn_sub_activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubActivity2.class);
                startActivity(intent);
            }
        });

        btn_help = findViewById(R.id.btn_help);
        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LicenseActivity.class);
                startActivity(intent);
            }
        });
    }

    public Boolean getAll_permissions(){

        //권한이 부여되어 있는지 확인
        int permissonRecord= ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO);
        int permissonWrite= ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int permissonRead= ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);

        if(permissonRecord == PackageManager.PERMISSION_GRANTED && permissonWrite == PackageManager.PERMISSION_GRANTED  && permissonRead == PackageManager.PERMISSION_GRANTED){
            return true;
        }else{
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECORD_AUDIO)){
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.RECORD_AUDIO}, PERMISSON);
            }else{
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.RECORD_AUDIO}, PERMISSON);
            }
        }
        return true;
    }

}
