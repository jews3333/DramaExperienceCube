package com.example.dramaexperiencecube.dbmanager;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.dramaexperiencecube.dbmanager.table.HumanDB;

import java.util.List;

@Dao
public interface HumanDao {
    @Insert
    long insert(HumanDB humanDB);

    @Query("SELECT * from Human where drama_id == :drama_id")
    List<HumanDB> getDrama(long drama_id);

    @Update
    void update(HumanDB... humanDB);

    @Delete
    void delete(HumanDB... humanDB);

    @Query("Delete from Human where drama_id == :drama_id")
    void deleteAll(long drama_id);
}
