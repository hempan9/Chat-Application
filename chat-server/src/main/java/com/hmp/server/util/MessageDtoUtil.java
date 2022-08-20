package com.hmp.server.util;

import com.hmp.server.dto.MessageDto;
import com.hmp.server.dto.UserDto;
import com.hmp.server.entity.MessageEntity;
import com.hmp.server.entity.UserEntity;
import com.hmp.server.exception.UserNotFoundException;
import com.hmp.server.service.UserService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author: hobject
 * date: 8/19/22
 * description: Message entity to message dto and dto
 * to entity converter utility class
 **/
@Component
public class MessageDtoUtil {

    private final UserService userService;

    public MessageDtoUtil(UserService userService) {
        this.userService = userService;
    }


    public MessageDto convertMessageEntityToDto(final MessageEntity messageEntity) {
        MessageDto messageDto = null;
        if (messageEntity != null) {
            messageDto = new MessageDto();
            messageDto.setMessageId(messageEntity.getMessageId());
            messageDto.setCreatedByUserId(messageEntity.getCreatedBy().getUserId());
            messageDto.setMessage(messageEntity.getMessage());
            messageDto.setType(messageEntity.getType());
            messageDto.setCreatedDateTime(messageEntity.getCreatedDateTime());
            messageDto.setSize(messageEntity.getSize());
        }
        return messageDto;
    }

    public MessageEntity convertMessageDtoToEntity(final MessageDto messageDto) throws UserNotFoundException {
        MessageEntity messageEntity = null;
        if (messageDto != null) {
            messageEntity = MessageEntity.MessageEntityBuilder()
                    .message(messageDto.getMessage())
                    .type(messageDto.getType())
                    .createdBy(setCreatedByUser(messageDto.getCreatedByUserId()))
                    .size(String.valueOf(messageDto.getMessage().getBytes().length))
                    .createdDateTime(LocalDateTime.now())
                    .build();

        }
        return messageEntity;
    }


    private UserEntity setCreatedByUser(Long userId) throws UserNotFoundException {
        Optional<UserDto> user = userService.getUserById(userId.longValue());
        if (user.isPresent()) {
            return UserDtoUtil.convertUserDtoToEntity(user.get());
        } else {
            throw new UserNotFoundException("User Not found");
        }

    }
}
