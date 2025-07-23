package com.banckend.usersapi.infrastructure.out.jpa.repository;

import com.banckend.usersapi.infrastructure.out.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRespository extends JpaRepository<UserEntity, Long> {
}
