package com.hmp.server.dao;

import com.hmp.server.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageDAO extends JpaRepository<MessageEntity, Long> {
}
