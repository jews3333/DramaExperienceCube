package com.example.dramaexperiencecube.dbmanager.table;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Drama")
public class DramaDB {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String title;
    private String where; // 상황
    private String time; // 시간
    private String location; // 장소
//    private ArrayList<String> humans = new ArrayList<>(); // 등장인물 리스트
//    private ArrayList<DramaScript> scripts = new ArrayList<>(); // 대본 리스트


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
