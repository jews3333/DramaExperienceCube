package com.example.dramaexperiencecube.game;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dramaexperiencecube.R;

import java.util.ArrayList;
import java.util.Random;

public class Game_Fragment4 extends Fragment {

    private final int MAX_BOARD_SIZE = 8;
    private final int MAX_CARD = 48;

    private MediaPlayer mediaPlayer = null;
    private int turn = 0;
    private Random rand;
    private boolean isEnd = false;

    private ArrayList<ImageView> boardViews = new ArrayList<>();
    private final int resBoards[] = {R.id.board01_iv, R.id.board02_iv, R.id.board03_iv,
            R.id.board04_iv,
            R.id.board05_iv, R.id.board06_iv, R.id.board07_iv,
            R.id.board08_iv};

    private final int cardPacks[] = {
            R.drawable.story_01, R.drawable.story_02, R.drawable.story_03, R.drawable.story_04, R.drawable.story_05,
            R.drawable.story_06, R.drawable.story_07, R.drawable.story_08, R.drawable.story_09, R.drawable.story_10,
            R.drawable.story_11, R.drawable.story_12, R.drawable.story_13, R.drawable.story_14, R.drawable.story_15,
            R.drawable.story_16, R.drawable.story_17, R.drawable.story_18, R.drawable.story_19, R.drawable.story_20,
            R.drawable.story_21, R.drawable.story_22, R.drawable.story_23, R.drawable.story_24, R.drawable.story_25,
            R.drawable.story_26, R.drawable.story_27, R.drawable.story_28, R.drawable.story_29, R.drawable.story_30,
            R.drawable.story_31, R.drawable.story_32, R.drawable.story_33, R.drawable.story_34, R.drawable.story_35,
            R.drawable.story_36, R.drawable.story_37, R.drawable.story_38, R.drawable.story_39,
            R.drawable.hidden_01, R.drawable.hidden_02, R.drawable.hidden_03, R.drawable.hidden_04,
            R.drawable.hidden_05, R.drawable.hidden_06, R.drawable.hidden_07, R.drawable.hidden_08
    };
    private final int enddings[] = {
            R.drawable.ending_01, R.drawable.ending_02, R.drawable.ending_03, R.drawable.ending_04,
            R.drawable.ending_05, R.drawable.ending_06, R.drawable.ending_07, R.drawable.ending_08
    };
    private ArrayList<Integer> cardRes = new ArrayList<>();

    private ImageView ivStoryCard, ivStart, ivEnd;

    public Game_Fragment4() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.game_fragment4, container, false);

        for (int r : resBoards) {
            boardViews.add((ImageView) rootView.findViewById(r));
        }

        ivStoryCard = rootView.findViewById(R.id.storycard_iv);
        ivStart = rootView.findViewById(R.id.start_iv);
        ivEnd = rootView.findViewById(R.id.end_iv);

        ivStoryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storyCardOpen();
            }
        });

        ivStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameStart();
            }
        });

        ivEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameEnd();
            }
        });

        setCardList();
        rand = new Random();

        return rootView;
    }

//    private void finish() {
//        getActivity().finish();
//    }

    private void setCardList() {
        cardRes.clear();

        for (int card : cardPacks) {
            cardRes.add(card);
        }
    }

    private void addEndingCard() {
        for (int card : enddings) {
            cardRes.add(card);
        }
    }

    private int getCard() {
        final int getIndex = rand.nextInt(cardRes.size() - 1);
        final int retRes = cardRes.get(getIndex);
        cardRes.remove(getIndex);
        return retRes;
    }

    private void storyCardOpen() {
//        if (isEnd) {
//            gameEnd();
//            return;
//        }
        if (turn == MAX_CARD) {
            gameEnd();
            isEnd = true;
            return;
        }

        final int cardRes = getCard();
        boardViews.get(turn % MAX_BOARD_SIZE).setBackgroundResource(cardRes);
        turn++;
        if (turn == 3) {
            addEndingCard();
        }


//        for (int i = 0; i < enddings.length; i++) {
//            if (enddings[i] == cardRes)
//                isEnd = true;
//        }
    }

    private void gameStart() {
        gameReset();
    }

    private void gameReset() {
        boardViews.get(0).setBackgroundResource(R.drawable.bg_game_start);
        for (int i = 1; i < resBoards.length; i++) {
            boardViews.get(i).setBackgroundResource(R.drawable.bg_game_card);
        }

        setCardList();

        turn = 0;
        isEnd = false;
    }

    private void gameEnd() {
        playApplause();
        showEndDialog();
    }

    private void showEndDialog() {
        AlertDialog.Builder endingDialog = new AlertDialog.Builder(getContext());
        endingDialog.setTitle("게임이 종료 되었습니다.")
                .setMessage("게임이 종료 되었습니다. 다시 놀이시작 버튼을 누르면 게임이 시작됩니다.")
                .setPositiveButton("다시시작", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        gameReset();
                    }
                })
                .setNegativeButton("게임종료", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        getActivity().finish();
                    }
                }).show();
    }

    private void playApplause() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.applause);
        }

        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        } else {
            mediaPlayer.start();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            } else {
                mediaPlayer.release();
                mediaPlayer = null;
            }
        }
    }
}
