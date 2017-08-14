package com.example.dean.photoviewer.domain.repository;

import com.example.dean.photoviewer.data.database.entity.DbUser;

import java.util.List;

public interface UserRepository {

    void saveUserData(List<DbUser> users);

    DbUser getUserByName(String name);
}
