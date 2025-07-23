package com.banckend.usersapi.infrastructure.out.jpa.mapper;

import com.banckend.usersapi.domain.model.UserModel;
import com.banckend.usersapi.infrastructure.out.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IUserEntityMapper {

    UserEntity toEntity(UserModel userModel);
    UserModel toModel(UserEntity userEntity);

}
