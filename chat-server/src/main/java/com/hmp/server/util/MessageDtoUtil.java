package com.hmp.server.util;

import com.hmp.server.dto.MessageDto;
import com.hmp.server.dto.UserDto;
import com.hmp.server.entity.MessageEntity;
import com.hmp.server.entity.UserEntity;
import com.hmp.server.exception.UserNotFoundException;
import com.hmp.server.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

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
            BeanUtils.copyProperties(messageEntity, messageDto);
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
                    .size(messageDto.getSize())
                    .createdDateTime(LocalDateTime.now())
                    .build();

        }
        return messageEntity;
    }


    private UserEntity setCreatedByUser(Long userId) throws UserNotFoundException {
        Mono<UserDto> user = userService.getUserById(userId.longValue()).switchIfEmpty(Mono.empty());
        UserEntity userEntity = UserDtoUtil.convertUserDtoToEntity(user.block());
        if (userEntity ==null){
            throw new UserNotFoundException("User Not found");
        }
        else {
            return userEntity;
        }

    }
}
