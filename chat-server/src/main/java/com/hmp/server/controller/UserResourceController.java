package com.hmp.server.controller;

import com.hmp.server.response.UserApiResponse;
import com.hmp.server.dto.UserDto;
import com.hmp.server.enums.ResponseStatus;
import com.hmp.server.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserResourceController {
    private final UserService userService;

    public UserResourceController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserApiResponse> registerUser(@RequestBody @Valid UserDto userDto) {
        boolean saved = userService.createUser(userDto);
        if (saved) {
            return ResponseEntity.ok(UserApiResponse.ApiResponseBuilder()
                    .msg("Successfully saved")
                    .data(userDto)
                    .responseStatus(ResponseStatus.SUCCESS).build());
        } else {
            return ResponseEntity.ok(UserApiResponse.ApiResponseBuilder()
                    .msg("Failed to save. Check if the user already exists.")
                    .responseStatus(ResponseStatus.FAILURE).build());
        }
    }
}
