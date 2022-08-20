package com.hmp.server.service.impl;

import com.hmp.server.dto.MessageDto;
import com.hmp.server.entity.MessageEntity;
import com.hmp.server.exception.UserNotFoundException;
import com.hmp.server.response.MessageApiResponse;
import com.hmp.server.util.MessageDtoUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MessageServiceImpl implements MessageService {
    private final MessageDtoUtil messageDtoUtil;

    public MessageServiceImpl(MessageDtoUtil messageDtoUtil) {
        this.messageDtoUtil = messageDtoUtil;
    }

    @Override
    public MessageApiResponse createNewMessage(MessageDto messageDto) throws UserNotFoundException {
        MessageEntity message;
        if (messageDto != null) {
            log.info("Message: {}", messageDto);
            message = messageDtoUtil.convertMessageDtoToEntity(messageDto);


        }

        return null;
    }

    @Override
    public MessageDto findMessageById(String messageId) {
        return null;
    }
}
