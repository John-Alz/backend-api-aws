package com.banckend.usersapi.domain.usecase;

import com.banckend.usersapi.domain.model.UserModel;
import com.banckend.usersapi.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserUseCaseTest {

    private IUserPersistencePort userPersistencePort;
    private UserUseCase userUseCase;

    @BeforeEach
    void setUp() {
        userPersistencePort = mock(IUserPersistencePort.class);
        userUseCase = new UserUseCase(userPersistencePort);
    }

    @Test
    void saveUser_ShouldCallPersistencePort() {
        // Arrange
        UserModel user = new UserModel(1L, "John", "11046723", "john@example.com");

        // Act
        userUseCase.saveUser(user);

        // Assert
        verify(userPersistencePort, times(1)).saveUser(user);
    }

    @Test
    void getUserById_ShouldReturnUserFromPersistencePort() {
        // Arrange
        Long userId = 1L;
        UserModel expectedUser = new UserModel(userId, "Jane", "20701234", "jane@example.com");
        when(userPersistencePort.getUserById(userId)).thenReturn(expectedUser);

        // Act
        UserModel actualUser = userUseCase.getUserById(userId);

        // Assert
        assertEquals(expectedUser, actualUser);
        verify(userPersistencePort, times(1)).getUserById(userId);
    }
}
