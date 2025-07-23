package com.banckend.usersapi.infrastructure.input.rest;

import com.banckend.usersapi.application.dto.request.UserRequestDto;
import com.banckend.usersapi.application.dto.response.SuccesMessageResponseDto;
import com.banckend.usersapi.application.dto.response.UserResponseDto;
import com.banckend.usersapi.application.handler.IUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserHandler userHandler;

    @PostMapping()
    public ResponseEntity<SuccesMessageResponseDto> saveUser(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userHandler.saveuser(userRequestDto));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long userId) {
        UserResponseDto userResponseDto = userHandler.getUserById(userId);
        return ResponseEntity.ok(userResponseDto);
    }
}
