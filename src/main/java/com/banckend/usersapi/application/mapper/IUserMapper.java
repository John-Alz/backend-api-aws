package com.banckend.usersapi.application.mapper;

import com.banckend.usersapi.application.dto.request.UserRequestDto;
import com.banckend.usersapi.application.dto.response.UserResponseDto;
import com.banckend.usersapi.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IUserMapper {

    UserModel toModel(UserRequestDto userRequestDto);
    UserResponseDto modelToResponse(UserModel userModel);

}
