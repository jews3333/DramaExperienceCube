package com.example.dramaexperiencecube.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Drama implements Parcelable {
    private String where = ""; // 상황
    private String time = ""; // 시간
    private String location = ""; // 장소
    private ArrayList<String> humans = new ArrayList<>(); // 등장인물 리스트
    private ArrayList<DramaScript> scripts = new ArrayList<>(); // 대본 리스트

    public Drama() {

    }

    protected Drama(Parcel in) {
        where = in.readString();
        time = in.readString();
        location = in.readString();
        humans = in.createStringArrayList();
        scripts = in.createTypedArrayList(DramaScript.CREATOR);
    }

    public static final Creator<Drama> CREATOR = new Creator<Drama>() {
        @Override
        public Drama createFromParcel(Parcel in) {
            return new Drama(in);
        }

        @Override
        public Drama[] newArray(int size) {
            return new Drama[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(where);
        parcel.writeString(time);
        parcel.writeString(location);
        parcel.writeStringList(humans);
        parcel.writeTypedList(scripts);
    }
}