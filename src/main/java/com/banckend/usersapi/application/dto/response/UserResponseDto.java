package com.banckend.usersapi.application.dto.response;

public record UserResponseDto(
         Long id,
         String name,
         String email
) {
}
