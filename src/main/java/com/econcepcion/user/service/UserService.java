package com.econcepcion.user.service;

import com.econcepcion.user.model.request.*;
import com.econcepcion.user.model.response.UserResponseDto;


public interface UserService {

    UserResponseDto createUser(UserRequestDto userRequestDto);

}
