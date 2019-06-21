package com.example.dramaexperiencecube.record;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.Handler;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class Player implements MediaPlayer.OnCompletionListener {
    private MediaPlayer player;
    private Activity activity;
    private File[] playlist;
    private int playIndex = 0;

    public Player(Activity activity, String dir) {
        this.activity = activity;
        String basePath = Environment.getExternalStorageDirectory().toString();
        File directory = new File(basePath + dir);
        playlist = directory.listFiles();
    }

    // 해당 디렉토리 통째로 비우기
    public void setDirEmpty(String dirName){
        Toast.makeText(this.activity, "삭제삭제.", Toast.LENGTH_SHORT).show();
        String path = Environment.getExternalStorageDirectory().toString() + dirName;

    File dir = new File(path);
    File[] childFileList = dir.listFiles();
    if (dir.exists()) {
        for (File childFile : childFileList) {
            if (childFile.isDirectory()) {
                setDirEmpty(childFile.getAbsolutePath());
                //하위 디렉토리
                } else {
                childFile.delete();
                //하위 파일
                }
        } dir.delete();
     }
    }



                public void playAll() {
                    playNext();
                }

                private void playNext() {
                    if (playIndex > playlist.length - 1) {
                        stop();
                        return;
                    }

                    File currentAudio = playlist[playIndex];
                    playAudio(currentAudio.getAbsolutePath());

                    playIndex += 1;
                }

                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            playNext();
                        }
                    }, 1000); // 1초 대기
                }

                public void stop() {
                    stopAudio();
                    closePlayer();
                }

                private void playAudio(String filename) {
                    try {
                        closePlayer();

                        player = new MediaPlayer();
                        player.setOnCompletionListener(this);
                        player.setDataSource(filename);
                        player.prepare();
                        player.start();

                        Toast.makeText(this.activity, "재생 시작됨.", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                private void stopAudio() {
                    if (player != null && player.isPlaying()) {
                        player.stop();

                        Toast.makeText(this.activity, "재생 중지됨.", Toast.LENGTH_SHORT).show();
                    }
                }

                private void closePlayer() {
                    if (player != null) {
                        player.release();
                        player = null;
                    }
                }
            }
