package com.banckend.usersapi.infrastructure.configuration;

import com.banckend.usersapi.domain.api.IUserServicePort;
import com.banckend.usersapi.domain.spi.IUserPersistencePort;
import com.banckend.usersapi.domain.usecase.UserUseCase;
import com.banckend.usersapi.infrastructure.out.jpa.adapter.UserJpaAdapter;
import com.banckend.usersapi.infrastructure.out.jpa.mapper.IUserEntityMapper;
import com.banckend.usersapi.infrastructure.out.jpa.repository.IUserRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IUserRespository userRespository;
    private final IUserEntityMapper userEntityMapper;

    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserJpaAdapter(userRespository, userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort());
    }

}
