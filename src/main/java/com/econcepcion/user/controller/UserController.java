package com.econcepcion.user.controller;

import com.econcepcion.user.model.request.*;
import com.econcepcion.user.model.response.UserResponseDto;
import com.econcepcion.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;



public interface UserController {
    ResponseEntity<UserResponseDto> create(@Valid @RequestBody UserRequestDto userRequestDto);

}

