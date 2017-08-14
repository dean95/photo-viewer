package com.example.dean.photoviewer.domain.interactor.user;

import com.example.dean.photoviewer.data.database.entity.DbUser;
import com.example.dean.photoviewer.domain.repository.UserRepository;

public final class GetOneUserUseCase {

    private UserRepository userRepository;

    public GetOneUserUseCase(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public DbUser getUser(final String name) {
        return userRepository.getUserByName(name);
    }
}
