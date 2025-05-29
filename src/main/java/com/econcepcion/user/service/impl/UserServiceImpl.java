package com.econcepcion.user.service.impl;

import com.econcepcion.user.exception.EmailAlreadyExistsException;
import com.econcepcion.user.mapper.UserRequestDtoMapper;
import com.econcepcion.user.mapper.UserResponseDtoMapper;
import com.econcepcion.user.model.entity.User;
import com.econcepcion.user.model.request.UserRequestDto;
import com.econcepcion.user.model.response.UserResponseDto;
import com.econcepcion.user.repository.UserRepository;
import com.econcepcion.user.service.UserService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Locale;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRequestDtoMapper userRequestDtoMapper;
    private final UserResponseDtoMapper userResponseDtoMapper;
    private final MessageSource messageSource;

    public UserServiceImpl(UserRepository userRepository,
                           UserRequestDtoMapper userRequestDtoMapper,
                           UserResponseDtoMapper userResponseDtoMapper,
                           MessageSource messageSource) {
        this.userRepository = userRepository;
        this.userRequestDtoMapper = userRequestDtoMapper;
        this.userResponseDtoMapper = userResponseDtoMapper;
        this.messageSource = messageSource;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto, Locale locale) {

        validateEmailNotRegistered(userRequestDto.getEmail(), locale);

        User user = userRequestDtoMapper.toEntity(userRequestDto);

        initializeUserDefaults(user);

        associatePhones(user);

        User savedUser = userRepository.save(user);

        return userResponseDtoMapper.toDto(savedUser);
    }

    private void validateEmailNotRegistered(String email, Locale locale) {
        if (userRepository.isEmailRegistered(email)) {
            throw new EmailAlreadyExistsException("El correo ya está registrado");
        }
    }

    private void initializeUserDefaults(User user) {
        Date now = new Date();
        String token = UUID.randomUUID().toString();
        user.initializeDefaults(now, token);
    }

    private void associatePhones(User user) {
        if (user.getPhones() != null) {
            user.getPhones().forEach(phone -> phone.setUser(user));
        }
    }
}


