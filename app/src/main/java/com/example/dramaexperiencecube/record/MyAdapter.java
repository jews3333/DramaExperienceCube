package com.example.dramaexperiencecube.record;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dramaexperiencecube.R;

import java.io.File;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private OnClickItemListener onClickItemListener;
    public interface OnClickItemListener {
        public void onClickItem(View item);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView item;

        MyViewHolder(View view){
            super(view);
            item = view.findViewById(R.id.text_item);
        }
    }

    private File[] filelist;
    public MyAdapter(File[] foodInfoArrayList){
        this.filelist = foodInfoArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.item.setText(filelist[position].getName());

        myViewHolder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemListener.onClickItem(myViewHolder.item);
            }
        });



    }

    @Override
    public int getItemCount() {
        return filelist.length;
    }

    public void setOnClickItemListener(OnClickItemListener listener) {
        onClickItemListener = listener;
    }
}