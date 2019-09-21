package com.example.dramaexperiencecube.data;

import android.os.Parcel;
import android.os.Parcelable;

public class DramaScript implements Parcelable {
    private String human = "";
    private String script = "";
    private String audioPath = "";

    public DramaScript() {}

    private DramaScript(Parcel parcel) {
        readFromParcel(parcel);
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(human);
        dest.writeString(script);
        dest.writeString(audioPath);
    }

    private void readFromParcel(Parcel in) {
        human = in.readString();
        script = in.readString();
        audioPath = in.readString();
    }

    public static final Creator<DramaScript> CREATOR = new Creator<DramaScript>(){
        @Override
        public DramaScript createFromParcel(Parcel source) {
            return new DramaScript(source);
        }

        @Override
        public DramaScript[] newArray(int size) {
            return new DramaScript[size];
        }
    };
}