package com.banckend.usersapi.application.handler;

import com.banckend.usersapi.application.dto.request.UserRequestDto;
import com.banckend.usersapi.application.dto.response.SuccesMessageResponseDto;
import com.banckend.usersapi.application.dto.response.UserResponseDto;

public interface IUserHandler {

    SuccesMessageResponseDto saveuser(UserRequestDto userRequestDto);

    UserResponseDto getUserById(Long userId);

}
