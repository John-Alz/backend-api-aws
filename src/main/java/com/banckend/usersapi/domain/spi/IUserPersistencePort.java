package com.banckend.usersapi.domain.spi;

import com.banckend.usersapi.domain.model.UserModel;

public interface IUserPersistencePort {

    void saveUser(UserModel userModel);
    UserModel getUserById(Long userId);



}
