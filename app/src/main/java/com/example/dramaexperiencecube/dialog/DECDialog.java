package com.example.dramaexperiencecube.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class DECDialog extends AlertDialog.Builder {
    private OnDialogButtonClickListener onDialogButtonClickListener;
    public AlertDialog dialog;

    public DECDialog(Context context) {
        this(context, "확인", "취소");
    }

    public DECDialog(Context context, String positive, String negative) {
        super(context);

        if (!positive.isEmpty()) {
            this.setPositiveButton(positive, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (onDialogButtonClickListener != null) onDialogButtonClickListener.onClick(true, dialog, which);
                    dialog.dismiss();
                }
            });
        }

        if (!negative.isEmpty()) {
            this.setNegativeButton(negative, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (onDialogButtonClickListener != null) onDialogButtonClickListener.onClick(false, dialog, which);
                    dialog.dismiss();
                }
            });
        }

        dialog = this.create();
    }

    public void setOnDialogButtonClickListener(OnDialogButtonClickListener onDialogButtonClickListener) {
        this.onDialogButtonClickListener = onDialogButtonClickListener;
    }

    public interface OnDialogButtonClickListener {
        void onClick(boolean positive, DialogInterface dialog, int which);
    }
}