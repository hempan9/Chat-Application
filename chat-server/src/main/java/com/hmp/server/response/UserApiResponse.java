package com.hmp.server.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.hmp.server.dto.UserDto;
import com.hmp.server.enums.ResponseStatus;
import lombok.Builder;
import lombok.Data;
import reactor.core.publisher.Flux;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder(builderMethodName = "ApiResponseBuilder")
public class UserApiResponse {
    private String error;
    private ResponseStatus responseStatus;
    private UserDto data;
    private Flux<UserDto> userDtos;
    private String msg;

}
