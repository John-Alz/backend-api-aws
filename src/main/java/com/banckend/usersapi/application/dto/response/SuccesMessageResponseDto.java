package com.banckend.usersapi.application.dto.response;

import java.time.LocalDateTime;

public record SuccesMessageResponseDto(String message, LocalDateTime time) {
}
