package com.banckend.usersapi.application.handler.impl;

import com.banckend.usersapi.application.dto.request.UserRequestDto;
import com.banckend.usersapi.application.dto.response.SuccesMessageResponseDto;
import com.banckend.usersapi.application.dto.response.UserResponseDto;
import com.banckend.usersapi.application.handler.IUserHandler;
import com.banckend.usersapi.application.mapper.IUserMapper;
import com.banckend.usersapi.application.utils.ApplicationConstants;
import com.banckend.usersapi.domain.api.IUserServicePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
@Transactional
public class UserHandler implements IUserHandler {

    private final IUserServicePort userServicePort;
    private final IUserMapper userMapper;

    @Override
    public SuccesMessageResponseDto saveuser(UserRequestDto userRequestDto) {
        userServicePort.saveUser(userMapper.toModel(userRequestDto));
        return new SuccesMessageResponseDto(ApplicationConstants.SAVE_USER_MESSAGE, LocalDateTime.now());
    }

    @Override
    public UserResponseDto getUserById(Long userId) {
        return userMapper.modelToResponse(userServicePort.getUserById(userId));
    }
}
