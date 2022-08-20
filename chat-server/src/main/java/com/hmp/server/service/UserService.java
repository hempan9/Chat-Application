package com.hmp.server.service;

import com.hmp.server.dto.UserDto;
import com.hmp.server.entity.UserEntity;
import reactor.core.publisher.Mono;

public interface UserService {
    boolean createUser(UserDto user);

    Mono<UserDto> getUserById(Long userId);
}
