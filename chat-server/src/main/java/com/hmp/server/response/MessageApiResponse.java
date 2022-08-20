package com.hmp.server.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class MessageApiResponse {
    private MessageStatusEnum messageStatus;
    private String error;
    private Flux<MessageDto> messages;
    private String msg;

}
