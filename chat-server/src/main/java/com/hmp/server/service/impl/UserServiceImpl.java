package com.hmp.server.service.impl;

import com.hmp.server.dao.UserDAO;
import com.hmp.server.dto.UserDto;
import com.hmp.server.entity.UserEntity;
import com.hmp.server.service.UserService;
import com.hmp.server.util.UserDtoUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * @param userDto
     * @return
     */
    @Override
    public boolean createUser(UserDto userDto) {
        if (!existsByUserName(userDto)) {
            UserEntity userEntity = UserDtoUtil.convertUserDtoToEntity(userDto);
            userDAO.save(userEntity);
            log.info("Successfully saved user: {}", userEntity);
            return true;
        } else {
            log.info("Cannot save already exists");
            return false;
        }

    }

    @Override
    public Optional<UserDto> getUserByUserName(String userName) {
        Optional<List<UserEntity>> users = userDAO.findByUserName(userName);
        log.info("User list size with username: {} is: {}", userName +users);
        return users.get().size()>0 ?
                Optional.of(UserDtoUtil.convertUserEntityToDto(users.get().get(0))) :
                Optional.empty();


    }


    private boolean existsByUserName(final UserDto userDto) {
        if (userDto != null) {
            return (!CollectionUtils.isEmpty(userDAO.findByUserNameAndAndEmail(userDto.getUserName(), userDto.getEmail())))
                    ? true : false;
        }
        return false;
    }


}
