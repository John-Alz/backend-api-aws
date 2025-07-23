package com.banckend.usersapi.application.dto.request;

public record UserRequestDto(
         String name,
         String identityNumber,
         String email
) {
}
