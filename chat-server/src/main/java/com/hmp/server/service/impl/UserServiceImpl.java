package com.hmp.server.service.impl;

import com.hmp.server.dao.UserDAO;
import com.hmp.server.dto.UserDto;
import com.hmp.server.entity.UserEntity;
import com.hmp.server.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Optional;

@Service
@Log4j2
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     *
     * @param userDto
     * @return
     */
    @Override
    public boolean createUser(UserDto userDto) {
        if (!existsByUserName(userDto)) {
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(userDto, userEntity);
            userDAO.save(userEntity);
            log.info("Successfully saved user: {}", userEntity);
            return true;
        } else {
            log.info("Cannot save already exists");
            return false;
        }

    }

    private boolean existsByUserName(final UserDto userDto) {
        if (userDto != null) {
            return (!CollectionUtils.isEmpty(userDAO.findByUserNameAndAndEmail(userDto.getUserName(), userDto.getEmail())))
                    ? true : false;
        }
        return false;
    }

    @Override
    public Optional<UserDto> getUserById(Long userId) {
        return Optional.of(userDAO.findById(userId).map(
                entity ->
                {
                    UserDto userDto = new UserDto();
                    BeanUtils.copyProperties(entity, userDto);
                    return userDto;
                })).get();
    }

}
