package com.banckend.usersapi.domain.usecase;

import com.banckend.usersapi.domain.api.IUserServicePort;
import com.banckend.usersapi.domain.model.UserModel;
import com.banckend.usersapi.domain.spi.IUserPersistencePort;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveUser(UserModel userModel) {
        userPersistencePort.saveUser(userModel);
    }

    @Override
    public UserModel getUserById(Long userId) {
        return userPersistencePort.getUserById(userId);
    }
}
