package com.hmp.server.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;


@Getter
@Setter
@Builder(builderMethodName = "UserDtoBuilder")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private long userId;
    @NotEmpty
    @NotNull
    private String userName;
    @NotEmpty
    @NotNull
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
}
