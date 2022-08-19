package com.hmp.server;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hmp.server.dto.ResponseStatus;
import com.hmp.server.dto.UserDto;
import lombok.Builder;
import lombok.Data;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder(builderMethodName = "ApiResponseBuilder")
public class ApiResponse {
    private String error;
    private ResponseStatus responseStatus;
    private UserDto data;
    private Flux<UserDto> userDtos;
    private String msg;

}
