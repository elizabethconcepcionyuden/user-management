package com.econcepcion.user.mapper;

import com.econcepcion.user.model.entity.User;
import com.econcepcion.user.model.request.UserRequestDto;
import com.econcepcion.user.model.response.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserRequestDto toDto(User user);
    User fromDto(UserRequestDto dto);
    UserResponseDto toDtoResponse(User user);
}
