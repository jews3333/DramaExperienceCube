package com.example.dramaexperiencecube.dbmanager;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.dramaexperiencecube.dbmanager.table.DramaDB;

import java.util.List;

@Dao
public interface DramaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(DramaDB dramaDB);

    @Query("SELECT * from Drama ORDER BY id ASC")
    List<DramaDB> getDrama();

    @Update
    void update(DramaDB... dramaDB);

    @Delete
    void delete(DramaDB dramaDB);
}
