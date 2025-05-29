package com.econcepcion.user.mapper;

import com.econcepcion.user.model.entity.User;
import com.econcepcion.user.model.response.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResponseDtoMapper extends GenericMapper<User, UserResponseDto> {
}
