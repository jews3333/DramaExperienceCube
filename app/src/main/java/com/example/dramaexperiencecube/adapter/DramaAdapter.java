package com.example.dramaexperiencecube.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dramaexperiencecube.MyPlanActivity;
import com.example.dramaexperiencecube.R;
import com.example.dramaexperiencecube.data.Drama;
import com.example.dramaexperiencecube.data.DramaScript;
import com.example.dramaexperiencecube.dbmanager.DramaRoomDB;
import com.example.dramaexperiencecube.dbmanager.table.DramaDB;
import com.example.dramaexperiencecube.dbmanager.table.DramaScriptDB;
import com.example.dramaexperiencecube.dbmanager.table.HumanDB;

import java.util.ArrayList;
import java.util.List;

public class DramaAdapter extends RecyclerView.Adapter<DramaAdapter.DramaViewHolder> {
    private ArrayList<DramaDB> items = new ArrayList<>();
    private DramaRoomDB dramaRoomDB;
    private Context context;

    private final int START_ACTIVITY = 100;
    private final int GET_DATA = 200;

    public void setItems(ArrayList<DramaDB> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public class DramaViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;


        public DramaViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.text_item);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Message msg = mHandler.obtainMessage();
                    msg.obj = getAdapterPosition();
                    msg.what = GET_DATA;
                    mHandler.sendMessage(msg);
                }
            });
        }
    }

    @NonNull
    @Override
    public DramaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.context = viewGroup.getContext();
        View view = (View) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_drama, viewGroup, false);
        DramaViewHolder dramaViewHolder = new DramaViewHolder(view);

        return dramaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DramaViewHolder viewHolder, int i) {
        viewHolder.tvTitle.setText(items.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case START_ACTIVITY:
                    Drama drama = (Drama) msg.obj;
                    startReadingActivity(drama, msg.arg1);
                    break;
                case GET_DATA:
                    new SelectAsyncTask((int) msg.obj).execute();

            }
        }
    };

    private void startReadingActivity(Drama drama, int id) {
//        Intent intent = new Intent(context, ReadingActivity.class);
//        intent.putExtra("where", drama.getWhere());
//        intent.putExtra("time", drama.getTime());
//        intent.putExtra("location", drama.getLocation());
//        intent.putStringArrayListExtra("humans", drama.getHumans());
//        intent.putParcelableArrayListExtra("scripts", drama.getScripts());

        Intent intent = new Intent(context, MyPlanActivity.class);
        intent.putExtra("EditMode", true);
        intent.putExtra("Drama", drama);
        intent.putExtra("ID", id);

        context.startActivity(intent);
    }

    private class SelectAsyncTask extends AsyncTask<Void, Void, Void> {
        private int position;

        public SelectAsyncTask(int position) {
            this.position = position;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dramaRoomDB = DramaRoomDB.getDatabase(context);
            DramaDB dbItem = items.get(position);
            List<HumanDB> humanDBS = dramaRoomDB.humanDao().getDrama(dbItem.getId());
            List<DramaScriptDB> scriptDBS = dramaRoomDB.scriptDao().getDrama(dbItem.getId());
            Drama drama = new Drama();
            drama.setWhere(dbItem.getWhere());
            drama.setTime(dbItem.getTime());
            drama.setLocation(dbItem.getLocation());
            ArrayList<String> human = new ArrayList<>();
            for (HumanDB hu : humanDBS) {
                human.add(hu.getName());
            }
            drama.setHumans(human);

            ArrayList<DramaScript> scripts = new ArrayList<>();
            for (DramaScriptDB script : scriptDBS) {
                DramaScript item = new DramaScript();
                item.setHuman(script.getHuman());
                item.setAudioPath(script.getAudioPath());
                item.setScript(script.getScript());
                scripts.add(item);
            }

            drama.setScripts(scripts);

            Message msg = mHandler.obtainMessage();
            msg.what = START_ACTIVITY;
            msg.obj = drama;
            msg.arg1 = (int) dbItem.getId();
            mHandler.sendMessage(msg);

            return null;
        }
    }
}
