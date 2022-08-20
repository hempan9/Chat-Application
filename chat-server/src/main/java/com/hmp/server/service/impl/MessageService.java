package com.hmp.server.service.impl;

import com.hmp.server.dto.MessageDto;
import com.hmp.server.exception.UserNotFoundException;
import com.hmp.server.response.MessageApiResponse;

public interface MessageService {
    MessageApiResponse createNewMessage(MessageDto messageDto) throws UserNotFoundException;
    MessageDto findMessageById(String messageId);
}
