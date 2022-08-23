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
            messageDto.setMessage(messageEntity.getMessage());
            messageDto.setType(messageEntity.getType());
            messageDto.setCreatedDateTime(messageEntity.getCreatedDateTime());
            messageDto.setSize(messageEntity.getSize());
            messageDto.setUpdatedBy(messageEntity.getUpdatedBy().getUserName());
            messageDto.setCreatedDateTime(messageEntity.getCreatedDateTime());
            messageDto.setUpdatedDateTime(messageEntity.getUpdatedDateTime());
        }
        return messageDto;
    }

    public MessageEntity convertMessageDtoToEntity(final MessageDto messageDto) throws UserNotFoundException {
        MessageEntity messageEntity = null;
        if (messageDto != null) {
            messageEntity = new MessageEntity();
            messageEntity.setMessageId(messageDto.getMessageId());
            messageEntity.setMessage(messageDto.getMessage());
            messageEntity.setType(messageDto.getType());
            messageEntity.setSize(messageDto.getMessage().getBytes().toString());
            messageEntity.setUpdatedBy(setUpdatedByUserName(messageDto.getUpdatedBy()));
            messageEntity.setCreatedDateTime(LocalDateTime.now().toString());
            messageEntity.setUpdatedDateTime(LocalDateTime.now().toString());

        }
        return messageEntity;
    }


    private UserEntity setUpdatedByUserName(String userName) throws UserNotFoundException {
        Optional<UserDto> user = userService.getUserByUserName(userName);
        if (user.isPresent()) {
            return UserDtoUtil.convertUserDtoToEntity(user.get());
        } else {
            throw new UserNotFoundException("User Not found");
        }

    }
}
