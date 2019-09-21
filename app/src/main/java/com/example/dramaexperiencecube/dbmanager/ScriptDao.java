package com.example.dramaexperiencecube.dbmanager;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.dramaexperiencecube.dbmanager.table.DramaScriptDB;

import java.util.List;

@Dao
public interface ScriptDao {
    @Insert
    long insert(DramaScriptDB scriptDB);

    @Query("SELECT * from Script where drama_id == :drama_id")
    List<DramaScriptDB> getDrama(long drama_id);

    @Update
    void update(DramaScriptDB... scriptDB);

    @Delete
    void delete(DramaScriptDB scriptDB);

    @Query("Delete from Script where drama_id == :drama_id")
    void deleteAll(long drama_id);
}
