package com.example.dramaexperiencecube.record;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
import android.widget.EditText;

public class InputAlert {
    private AlertDialog.Builder builder;
    public String value = "";

    private OnPressOkListener onPressOkListener;
    public interface OnPressOkListener {
        void onPressOk(String value);
    }

    public InputAlert(Context context, String title) {
        builder = new AlertDialog.Builder(context);
        builder.setTitle(title);

        // Set up the input
        final EditText input = new EditText(context);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                value = input.getText().toString();
                onPressOkListener.onPressOk("/" + value);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
    }

    public void setOnPressOkListener(OnPressOkListener listener) {
        onPressOkListener = listener;
    }

    public void show() {
        builder.show();
    }
}
