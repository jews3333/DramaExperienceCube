package com.example.dramaexperiencecube.record;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class Player implements MediaPlayer.OnCompletionListener {
    private MediaPlayer player;
    private Activity activity;
    private File[] playlist;
    private int playIndex = 0;
    private String basePath = "";
    private boolean playAllFlag = false;

    private Handler handler;
    private Runnable nextRunnable;

    private OnCompletionListener onCompletionListener;

    public Player(Activity activity, String dir) {
        this.activity = activity;
        basePath = Environment.getExternalStorageDirectory().toString() + dir;
        File directory = new File(basePath);
        playlist = directory.listFiles();
    }

    public void play(String filename) {
        playAudio(basePath + filename + ".mp3");
    }


    public void playAll() {
        playAllFlag = true;
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
        if (playAllFlag) {
            handler = new Handler();
            nextRunnable = new Runnable() {
                public void run() {
                    playNext();
                }
            };
            handler.postDelayed(nextRunnable, 1000); // 1초 대기
        }

        if (onCompletionListener != null) onCompletionListener.onCompletion(mediaPlayer, playIndex);
    }

    public void stop() {
        stopAudio();
        closePlayer();
        playAllFlag = false;
        if (nextRunnable != null) handler.removeCallbacks(nextRunnable);
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

    public void setPlayIndex(int playIndex) {
        this.playIndex = playIndex;
    }

    public int getPlayIndex() {
        return playIndex;
    }

    public interface OnCompletionListener {
        void onCompletion(MediaPlayer mediaPlayer, int position);
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.onCompletionListener = onCompletionListener;
    }
}