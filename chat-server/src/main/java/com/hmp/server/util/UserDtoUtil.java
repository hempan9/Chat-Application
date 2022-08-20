package com.hmp.server.util;

import com.hmp.server.dto.UserDto;
import com.hmp.server.entity.UserEntity;
import org.springframework.beans.BeanUtils;

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
            BeanUtils.copyProperties(userDto, userEntity);
        }
        return userEntity;
    }
}
