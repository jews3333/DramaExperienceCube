package com.example.dramaexperiencecube.dbmanager.table;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Script")
public class DramaScriptDB {
    @PrimaryKey(autoGenerate = true)
    long id;
    long drama_id;
    private String human;
    private String script;
    private String audioPath = "";

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDrama_id() {
        return drama_id;
    }

    public void setDrama_id(long drama_id) {
        this.drama_id = drama_id;
    }

    public String getHuman() {
        return human;
    }

    public void setHuman(String human) {
        this.human = human;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }
}