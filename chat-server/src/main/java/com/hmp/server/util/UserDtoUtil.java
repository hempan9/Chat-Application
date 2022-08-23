package com.hmp.server.util;

import com.hmp.server.dto.UserDto;
import com.hmp.server.entity.UserEntity;

import java.time.LocalDateTime;

/**
 * @author: hobject
 * date: 8/19/22
 * description:  User entity to message dto and dto  * to entity converter utility class
 **/
public class UserDtoUtil {
    private UserDtoUtil () throws IllegalAccessException {
        throw new IllegalAccessException("Cannot instantiate userDtoUtil class.");
    }

    public static UserEntity convertUserDtoToEntity(UserDto userDto){
        UserEntity userEntity = null;
        if (userDto!=null){
            userEntity = new UserEntity();
            userEntity.setUserId(userDto.getUserId());
            userEntity.setUserName(userDto.getUserName());
            userEntity.setEmail(userDto.getEmail());
            userEntity.setPhone(userDto.getPhone());
            userEntity.setFirstName(userDto.getFirstName());
            userEntity.setLastName(userDto.getLastName());
            userEntity.setCreatedDateTime(LocalDateTime.now().toString());
            userEntity.setUpdatedDateTime(LocalDateTime.now().toString());
        }
        return userEntity;
    }
    public static UserDto convertUserEntityToDto(UserEntity userEntity){
        UserDto userDto = null;
        if (userEntity!=null){
            userDto = new UserDto();
            userDto.setUserId(userEntity.getUserId());
            userDto.setUserName(userEntity.getUserName());
            userDto.setEmail(userEntity.getEmail());
            userDto.setFirstName(userEntity.getFirstName());
            userDto.setLastName(userEntity.getLastName());
            userDto.setPhone(userEntity.getPhone());
            userDto.setCreatedDateTime(userEntity.getCreatedDateTime());
            userDto.setUpdatedDateTime(userEntity.getUpdatedDateTime());
        }
        return userDto;
    }
}
