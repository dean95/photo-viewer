package com.example.dean.photoviewer.data.database.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.dean.photoviewer.data.database.dao.PhotoDao;
import com.example.dean.photoviewer.data.database.dao.UserDao;
import com.example.dean.photoviewer.data.database.entity.DbPhoto;
import com.example.dean.photoviewer.data.database.entity.DbUser;

@Database(entities = {DbUser.class, DbPhoto.class}, version = AppDatabase.DB_VERSION)
public abstract class AppDatabase extends RoomDatabase {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "app-database";

    public abstract PhotoDao photoDao();

    public abstract UserDao userDao();
}
