package com.hmp.server.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.hmp.server.dto.MessageDto;
import com.hmp.server.enums.MessageStatusEnum;
import lombok.Builder;
import lombok.Data;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * @author: Hemanta Pant
 * date: 8/19/22
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder(builderMethodName = "MessageResponseBuilder")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageApiResponse {
    private MessageStatusEnum messageStatus;
    private String error;
    private MessageDto messages;
    private String msg;

}
