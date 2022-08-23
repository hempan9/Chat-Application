package com.hmp.server.service;

import com.hmp.server.dto.MessageDto;
import com.hmp.server.exception.UserNotFoundException;
import com.hmp.server.response.MessageApiResponse;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

public interface MessageService {
    MessageApiResponse createNewMessage(MessageDto messageDto) throws UserNotFoundException, ExecutionException, InterruptedException;
    Optional<MessageDto> findMessageById(Long messageId);
}
