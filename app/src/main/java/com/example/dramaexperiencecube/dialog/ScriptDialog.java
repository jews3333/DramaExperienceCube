package com.example.dramaexperiencecube.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

public class ScriptDialog extends DECDialog {
    private OnDialogButtonClickListener onDialogButtonClickListener;

    public ScriptDialog(Context context, ArrayList<String> humans) {
        super(context);

        // 텍스트 설정
        this.setTitle("대본 입력");

        // parent 레이아웃 설정
        LinearLayout parent = new LinearLayout(context);
        parent.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        parent.setOrientation(LinearLayout.VERTICAL);

        // 스피너, 에딧텍스트 초기화
        final Spinner spinner = new Spinner(context);
        final EditText editText = new EditText(context);

        // 스피너에 사용할 어레이 어댑터 선언
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, humans);
        spinner.setAdapter(arrayAdapter);

        parent.addView(spinner);
        parent.addView(editText);

        this.setView(parent);

        super.setOnDialogButtonClickListener(new DECDialog.OnDialogButtonClickListener() {
            @Override
            public void onClick(boolean positive, DialogInterface dialog, int which) {
                if (positive) {
                    String selectedItem = spinner.getSelectedItem().toString();
                    String script = editText.getText().toString();
                    onDialogButtonClickListener.onClick(selectedItem, script);
                }
            }
        });
    }

    public void setOnDialogButtonClickListener(OnDialogButtonClickListener onDialogButtonClickListener) {
        this.onDialogButtonClickListener = onDialogButtonClickListener;
    }

    public interface OnDialogButtonClickListener {
        void onClick(String selectedHuman, String script);
    }
}