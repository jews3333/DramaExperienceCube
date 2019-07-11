package com.example.dramaexperiencecube.adapter;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dramaexperiencecube.MainActivity;
import com.example.dramaexperiencecube.PlayReadingActivity;
import com.example.dramaexperiencecube.R;
import com.example.dramaexperiencecube.data.DramaScript;

import java.util.ArrayList;
import java.util.List;

public class ScriptAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    private OnClickItemListener onClickItemListener;
    private ArrayList<DramaScript> scripts;
    private boolean highlightSelection = false;
    private int selectedPos = RecyclerView.NO_POSITION;

    public interface OnClickItemListener {
        public void onClickItem(View item, int position);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView item;

        MyViewHolder(View view){
            super(view);
            item = view.findViewById(R.id.text_item);
        }
    }


    public ScriptAdapter(ArrayList<DramaScript> scripts){
        this.scripts = scripts;
    }

    public ScriptAdapter(ArrayList<DramaScript> scripts, boolean highlightSelection) {
        this(scripts);
        this.highlightSelection = highlightSelection;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row, parent, false);
        return new MyViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolder myViewHolder = (MyViewHolder) holder;
        final TextView item = myViewHolder.item;

        DramaScript script = scripts.get(position);
        item.setText(script.getHuman() + " : " + script.getScript());

        boolean hasAudioPath = !script.getAudioPath().equals("");
        boolean isHighlighted = highlightSelection ? selectedPos == position : hasAudioPath;
        item.setTextColor(isHighlighted ? Color.parseColor("#ffffff") : Color.parseColor("#30ffffff"));


        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickItemListener != null) onClickItemListener.onClickItem(item, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return scripts.size();
    }

    public void setOnClickItemListener(OnClickItemListener listener) {
        onClickItemListener = listener;
    }

    public void updateSelection(int position) {
        notifyItemChanged(selectedPos);
        selectedPos = position;
        notifyItemChanged(selectedPos);
    }

}