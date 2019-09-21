package com.example.dramaexperiencecube.record;

import android.Manifest;
import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class Recorder {
    private Activity activity;

    private String basePath;
    private File directory;

    private MediaRecorder recorder;

    /**
     * 생성자.
     * base 경로를 설정, 권한 요청, base 경로 폴더 생성 등의 작업을 함.
     *
     * @param activity {Activity} 액티비티
     * @param baseDir {String} 연극 녹음 대본이 저장될 경로
     */
    public Recorder(Activity activity, String baseDir) {
        this.activity = activity;
        this.basePath = Environment.getExternalStorageDirectory().toString() + baseDir;

        // 권한 요청
        String[] permissions = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.RECORD_AUDIO,
        };
        Permissions.requestPermissions(activity, permissions);

        // 기본 폴더 생성
        this.directory = new File(this.basePath);
        if (!this.directory.exists()) this.directory.mkdirs();
    }

    // 서브 디렉토리 통째로 비우기
    public void empty() {
//        Toast.makeText(this.activity, "삭제", Toast.LENGTH_SHORT).show();
        enptyDir(basePath, false);
    }

    // 해당 디렉토리 통째로 비우기
    private void enptyDir(String path, boolean deletePath) {
        File dir = new File(path);

        if (dir.exists()) {
            File[] childFileList = dir.listFiles();

            for (File childFile : childFileList) {
                if (childFile.isDirectory()) {
                    enptyDir(childFile.getAbsolutePath(), true);
                    //하위 디렉토리
                } else {
                    childFile.delete();
                    //하위 파일
                }
            }

            if (deletePath) dir.delete();
        }
    }

    /**
     * basePath 경로의 파일 리스트 반환 (녹음된 연극 리스트)
     *
     */
    public File[] getRecordList() {
        return this.directory.listFiles();
    }


    /* *****************************
     *  녹음 관련 메서드
     * *****************************/

    /**
     * 녹음 시작
     *
     */
    public void record(String filename) {
        recorder = new MediaRecorder();

        recorder.setAudioSource(MediaRecorder.AudioSource.MIC); // 어디에서 음성 데이터를 받을 것인지
        recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4); // 압축 형식 설정
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT); // 인코더 설정

        recorder.setOutputFile(basePath + filename + ".mp3");

        try {
            recorder.prepare();
            recorder.start();

            Toast.makeText(activity, "녹음 시작됨.", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 녹음 중지
     */
    public void stopRecord() {
        if (recorder != null) {
            recorder.stop();
            recorder.release();
            recorder = null;
            Toast.makeText(activity, "녹음 중지됨.", Toast.LENGTH_SHORT).show();
        }
    }
}