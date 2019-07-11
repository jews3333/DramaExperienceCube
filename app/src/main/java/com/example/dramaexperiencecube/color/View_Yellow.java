package com.example.dramaexperiencecube.color;

import android.Manifest;
import android.app.Activity;

import com.example.dramaexperiencecube.R;
import com.example.dramaexperiencecube.record.Permissions;

import java.io.File;
import java.lang.reflect.Field;

public class View_Yellow extends Activity{
    private Activity activity;

    private String basePath;
    private static File directory;


    /**
     * 생성자.
     * base 경로를 설정, 권한 요청, base 경로 폴더 생성 등의 작업을 함.
     *
     * @param activity {Activity} 액티비티
     * @param baseDir {String} 동영상 경로
     */
    public View_Yellow(Activity activity, String baseDir) {
        this.activity = activity;
        this.basePath = "android.resource://" + baseDir + "/";

        // 권한 요청
        String[] permissions = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
        };
        Permissions.requestPermissions(activity, permissions);
        //this.directory = new File(this.basePath);
    }



    /**
     * basePath 경로의 파일 리스트 반환 (영상리스트)
     *
     */
    public static String[] getViewList() {
        Field[] fields = R.raw.class.getFields();
        String[] listStr =  new String[10];
        int cnt = 0;

        for(int count=0; count < fields.length; count++){
//            Log.i("Raw Asset name: ", fields[count].getName().substring(0,3));

            if(fields[count].getName().substring(0,5).equals("yello")){
//                Log.i("내가 뿌려줄 이름들", fields[count].getName());
                listStr[cnt] = (String)fields[count].getName();
                cnt++;


            }
        }

        return listStr;
//        return R.raw.class.getFields();
    }

}
