package com.hmp.server.service;

import com.hmp.server.dto.UserDto;

import java.util.Optional;

public interface UserService {
    boolean createUser(UserDto user);
    Optional<UserDto> getUserByUserName(String userName);
}
