package com.hmp.server.controller;

import com.hmp.server.response.UserApiResponse;
import com.hmp.server.dto.UserDto;
import com.hmp.server.enums.ResponseStatus;
import com.hmp.server.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserResourceController {
    private final UserService userService;

    public UserResourceController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserApiResponse> registerUser(@RequestBody @Valid UserDto userDto) {
        boolean saved = userService.createUser(userDto);
        if (saved) {
            return ResponseEntity.ok(UserApiResponse.ApiResponseBuilder()
                    .msg("Successfully saved user: " + userDto.getUserName())
                    .responseStatus(ResponseStatus.SUCCESS).build());
        } else {
            return ResponseEntity.ok(UserApiResponse.ApiResponseBuilder()
                    .msg("Failed to save. Check if the user already exists.")
                    .responseStatus(ResponseStatus.FAILURE).build());
        }
    }

    @RequestMapping(value = "/find/{userName}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserApiResponse> getUserByUserName(@PathVariable String userName) {
        Optional<UserDto> user = userService.getUserByUserName(userName);
        if (user.isPresent()) {
            return ResponseEntity.ok(UserApiResponse.ApiResponseBuilder()
                    .data(user.get())
                    .msg("Successfully fetched user: " + user.get().getUserName())
                    .responseStatus(ResponseStatus.SUCCESS).build());
        } else {
            return ResponseEntity.ok(UserApiResponse.ApiResponseBuilder()
                    .msg("User Not found with name: " + userName)
                    .responseStatus(ResponseStatus.FAILURE).build());
        }
    }
}
