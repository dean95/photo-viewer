package com.example.dean.photoviewer.domain.interactor.user;

import com.example.dean.photoviewer.data.database.entity.DbUser;
import com.example.dean.photoviewer.domain.repository.UserRepository;

import java.util.List;

public final class SaveUserDataUseCase {

    private final UserRepository userRepository;

    public SaveUserDataUseCase(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUserData(final List<DbUser> users) {
        userRepository.saveUserData(users);
    }
}
