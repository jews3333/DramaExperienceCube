package com.example.dramaexperiencecube.dbmanager.table;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Human")
public class HumanDB {
    @PrimaryKey(autoGenerate = true)
    long id;
    long drama_id;
    String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
