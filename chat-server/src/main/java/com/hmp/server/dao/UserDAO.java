package com.hmp.server.dao;

import com.hmp.server.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import reactor.core.publisher.Flux;

import java.util.List;

public interface UserDAO extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByUserNameAndAndEmail(String userName, String email);
    List<UserEntity> findByUserName(String userName);
}
