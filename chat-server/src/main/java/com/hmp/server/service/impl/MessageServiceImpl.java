package com.hmp.server.service.impl;

import com.hmp.server.dao.MessageDAO;
import com.hmp.server.dto.MessageDto;
import com.hmp.server.entity.MessageEntity;
import com.hmp.server.enums.MessageStatusEnum;
import com.hmp.server.exception.UserNotFoundException;
import com.hmp.server.response.MessageApiResponse;
import com.hmp.server.util.MessageDtoUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class MessageServiceImpl implements MessageService {
    private final MessageDtoUtil messageDtoUtil;
    private final MessageDAO messageDAO;

    public MessageServiceImpl(MessageDtoUtil messageDtoUtil, MessageDAO messageDAO) {
        this.messageDtoUtil = messageDtoUtil;
        this.messageDAO = messageDAO;
    }

    @Override
    public MessageApiResponse createNewMessage(MessageDto messageDto) {
        MessageEntity messageEntity;
        MessageApiResponse apiResponse = null;
        if (messageDto != null) {
            log.info("Message: {}", messageDto);
            try {
                messageEntity = messageDtoUtil.convertMessageDtoToEntity(messageDto);
                if (messageEntity != null) {
                    log.debug("Saving message: {}", messageDto);
                    messageDAO.save(messageEntity);
                    apiResponse = MessageApiResponse.MessageResponseBuilder()
                            .messageStatus(MessageStatusEnum.SENT)
                            .msg("Message sent Successfully.")
                            .build();
                }
            } catch (UserNotFoundException ufe) {
                log.error("Exception occurred: {}", ufe.getMessage());
                apiResponse = MessageApiResponse.MessageResponseBuilder()
                        .error(ufe.getMessage())
                        .msg("Check the userId")
                        .build();
            }


        }

        return apiResponse;
    }

    @Override
    public Optional<MessageDto> findMessageById(Long messageId) {
        return messageDAO.findById(messageId).map(
                messageEntity -> messageDtoUtil.convertMessageEntityToDto(messageEntity)
        );
    }
}
