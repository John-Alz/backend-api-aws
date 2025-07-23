package com.banckend.usersapi.domain.api;

import com.banckend.usersapi.domain.model.UserModel;

public interface IUserServicePort {

    void saveUser(UserModel userModel);

    UserModel getUserById(Long userId);

}
