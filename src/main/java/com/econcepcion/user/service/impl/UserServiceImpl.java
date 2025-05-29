package com.econcepcion.user.service.impl;

import com.econcepcion.user.exception.EmailAlreadyExistsException;
import com.econcepcion.user.mapper.UserMapper;
import com.econcepcion.user.model.entity.Phone;
import com.econcepcion.user.model.entity.User;
import com.econcepcion.user.model.request.PhoneRequestDto;
import com.econcepcion.user.model.request.UserRequestDto;
import com.econcepcion.user.model.response.UserResponseDto;
import com.econcepcion.user.repository.UserRepository;
import com.econcepcion.user.security.jwt.JwtUtils;
import com.econcepcion.user.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;


    public UserServiceImpl(UserRepository userRepository,
                           AuthenticationManager authenticationManager,
                           UserMapper userMapper,
                           JwtUtils jwtUtils,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.userMapper =userMapper;
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        validateRequest(userRequestDto);
        User user = buildUserEntity(userRequestDto);
        User savedUser = userRepository.save(user);
        return userMapper.toDtoResponse(savedUser);
    }

    private User buildUserEntity(UserRequestDto userRequestDto) {
        Date now = new Date();
        User user = userMapper.fromDto(userRequestDto);

        if (user.getId() == null) {
            user.setId(UUID.randomUUID());
        }

        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setCreated(now);
        user.setModified(now);
        user.setLastLogin(now);
        user.setIsActive(true);
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        user.setToken(jwtUtils.generateToken(userRequestDto.getEmail()));

        if (userRequestDto.getPhones() != null) {
            user.setPhones(mapPhonesToEntities(userRequestDto.getPhones(),user));
            user.getPhones().forEach(phone -> phone.setUser(user));
        }

        return user;
    }
    private List<Phone> mapPhonesToEntities(List<PhoneRequestDto> phoneRequestDtos, User user) {
        if (phoneRequestDtos == null) {
            return Collections.emptyList();
        }

        return phoneRequestDtos.stream()
                .map(dto -> {
                    Phone phone = new Phone();
                    phone.setNumber(dto.getNumber());
                    phone.setCityCode(dto.getCityCode());
                    phone.setCountryCode(dto.getCountryCode());
                    phone.setUser(user);
                    return phone;
                })
                .collect(Collectors.toList());
    }
    private void validateRequest(UserRequestDto userRequestDto) {
        if (this.userRepository.existsByEmail(userRequestDto.getEmail())) {
            throw new EmailAlreadyExistsException("El correo ya está registrado");
        }
    }
}




