package com.example.dramaexperiencecube.data;

import java.util.ArrayList;

public class Drama {
    private String where = ""; // 상황
    private String time = ""; // 시간
    private String location = ""; // 장소
    private ArrayList<String> humans = new ArrayList<>(); // 등장인물 리스트
    private ArrayList<DramaScript> scripts = new ArrayList<>(); // 대본 리스트

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

    public ArrayList<String> getHumans() {
        return humans;
    }

    public void setHumans(ArrayList<String> humans) {
        this.humans = humans;
    }

    public ArrayList<DramaScript> getScripts() {
        return scripts;
    }

    public void setScripts(ArrayList<DramaScript> scripts) {
        this.scripts = scripts;
    }
}