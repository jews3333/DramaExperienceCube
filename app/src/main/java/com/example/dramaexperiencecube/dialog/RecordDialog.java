package com.example.dramaexperiencecube.dialog;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.dramaexperiencecube.data.DramaScript;

import java.util.ArrayList;

public class RecordDialog extends DECDialog implements AdapterView.OnItemClickListener {
    private OnDialogItemClickListener onDialogItemClickListener;

    public RecordDialog(Context context, DramaScript script) {
        super(context, "", "취소");

        this.setMessage(script.getHuman() + " : " + script.getScript());

        // parent 레이아웃 설정
        LinearLayout parent = new LinearLayout(context);
        parent.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        parent.setOrientation(LinearLayout.VERTICAL);

        // 메뉴 리스트
        ArrayList<String> menus = new ArrayList<>();
        menus.add("녹음");
        menus.add("재생");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, menus);

        // 리스트뷰 설정
        ListView listView = new ListView(context);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);

        // 뷰 설정
        parent.addView(listView);
        this.setView(parent);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (onDialogItemClickListener != null) onDialogItemClickListener.onClick(adapterView, view, i, l);
    }

    public void setOOnDialogItemClickListener(OnDialogItemClickListener onDialogItemClickListener) {
        this.onDialogItemClickListener = onDialogItemClickListener;
    }

    public interface OnDialogItemClickListener {
        void onClick(AdapterView<?> adapterView, View view, int i, long l);
    }
}