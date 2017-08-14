package com.example.dean.photoviewer.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.dean.photoviewer.data.database.entity.DbUser;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<DbUser> user);

    @Query("SELECT * FROM user WHERE name = (:name)")
    DbUser getUserByName(String name);

    @Query("DELETE FROM user")
    void deleteAll();
}
