package com.example.dean.photoviewer.data.repository;

import com.example.dean.photoviewer.data.database.db.AppDatabase;
import com.example.dean.photoviewer.data.database.entity.DbUser;
import com.example.dean.photoviewer.domain.repository.UserRepository;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final AppDatabase database;

    public UserRepositoryImpl(final AppDatabase database) {
        this.database = database;
    }

    @Override
    public void saveUserData(final List<DbUser> users) {
        database.userDao().insertAll(users);
    }

    @Override
    public DbUser getUserByName(final String name) {
        return database.userDao().getUserByName(name);
    }
}
