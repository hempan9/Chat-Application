package com.hmp.server.dao;

import com.hmp.server.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

public interface UserDAO extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByUserNameAndAndEmail(String userName, String email);
    Optional<List<UserEntity>> findByUserName(String userName);
}
