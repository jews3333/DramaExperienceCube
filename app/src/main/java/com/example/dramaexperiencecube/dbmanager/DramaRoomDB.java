package com.example.dramaexperiencecube.dbmanager;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.dramaexperiencecube.dbmanager.table.DramaDB;
import com.example.dramaexperiencecube.dbmanager.table.DramaScriptDB;
import com.example.dramaexperiencecube.dbmanager.table.HumanDB;

@Database(entities = {DramaDB.class, HumanDB.class, DramaScriptDB.class}, version = 1)
public abstract class DramaRoomDB extends RoomDatabase {

    private static volatile DramaRoomDB INSTANCE;

    public abstract DramaDao DramaDao();
    public abstract HumanDao humanDao();
    public abstract ScriptDao scriptDao();

    static public DramaRoomDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DramaRoomDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DramaRoomDB.class, "drama_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
