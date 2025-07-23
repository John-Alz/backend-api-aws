package com.banckend.usersapi.infrastructure.out.jpa.adapter;

import com.banckend.usersapi.domain.model.UserModel;
import com.banckend.usersapi.domain.spi.IUserPersistencePort;
import com.banckend.usersapi.infrastructure.exception.NoDataFoundException;
import com.banckend.usersapi.infrastructure.out.jpa.entity.UserEntity;
import com.banckend.usersapi.infrastructure.out.jpa.mapper.IUserEntityMapper;
import com.banckend.usersapi.infrastructure.out.jpa.repository.IUserRespository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRespository userRespository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public void saveUser(UserModel userModel) {
        userRespository.save(userEntityMapper.toEntity(userModel));
    }

    @Override
    public UserModel getUserById(Long userId) {
        UserEntity userFound = userRespository.findById(userId).orElse(null);
        if (userFound == null) {
            throw new NoDataFoundException();
        }
        return userEntityMapper.toModel(userFound);
    }
}
