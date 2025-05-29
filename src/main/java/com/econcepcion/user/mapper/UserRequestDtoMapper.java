package com.econcepcion.user.mapper;

import com.econcepcion.user.model.request.UserRequestDto;
import com.econcepcion.user.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRequestDtoMapper extends GenericMapper<User, UserRequestDto> {
}
