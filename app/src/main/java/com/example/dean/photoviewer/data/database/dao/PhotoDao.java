package com.example.dean.photoviewer.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.dean.photoviewer.data.database.entity.DbPhoto;

import java.util.List;

@Dao
public interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<DbPhoto> photos);

    @Query("SELECT * FROM photo")
    List<DbPhoto> getAll();

    @Query("SELECT * FROM photo WHERE _id = (:id)")
    DbPhoto getOne(String id);

    @Query("DELETE FROM photo")
    void deleteAll();
}
