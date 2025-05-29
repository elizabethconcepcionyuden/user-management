package com.econcepcion.user.controller.impl;

import com.econcepcion.user.mapper.UserRequestDtoMapper;
import com.econcepcion.user.mapper.UserResponseDtoMapper;
import com.econcepcion.user.model.entity.User;
import com.econcepcion.user.model.request.UserRequestDto;
import com.econcepcion.user.model.response.UserResponseDto;
import com.econcepcion.user.repository.UserRepository;
import com.econcepcion.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRequestDtoMapper userRequestDtoMapper;
    private final UserResponseDtoMapper userResponseDtoMapper;

    public UserServiceImpl(UserRepository userRepository,
                           UserRequestDtoMapper userRequestDtoMapper,
                           UserResponseDtoMapper userResponseDtoMapper) {
        this.userRepository = userRepository;
        this.userRequestDtoMapper = userRequestDtoMapper;
        this.userResponseDtoMapper = userResponseDtoMapper;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {

        User user = userRequestDtoMapper.toEntity(userRequestDto);

        Date now = new Date();
        String token = UUID.randomUUID().toString();
        user.initializeDefaults(now, token);

        if (user.getPhones() != null) {
            user.getPhones().forEach(phone -> phone.setUser(user));
        }

        User savedUser = userRepository.save(user);

        return userResponseDtoMapper.toDto(savedUser);
    }
}

