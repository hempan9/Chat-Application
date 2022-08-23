package com.hmp.server.controller;

import com.hmp.server.dto.MessageDto;
import com.hmp.server.enums.MessageStatusEnum;
import com.hmp.server.exception.UserNotFoundException;
import com.hmp.server.response.MessageApiResponse;
import com.hmp.server.service.MessageService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

/**
 * @author: hobject
 * date: 8/19/22
 * description: controller class for message
 **/
@RestController
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(value = "/saveMessage", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MessageApiResponse> sendMessage(@RequestBody MessageDto messageDto) throws UserNotFoundException, ExecutionException, InterruptedException {
        return messageService.createNewMessage(messageDto) != null ?
                ResponseEntity.ok(messageService.createNewMessage(messageDto))
                : ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/findMessage/{messageId}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public MessageApiResponse findMessageByMessageId(@PathVariable Long messageId) {
        Optional<MessageDto> response = messageService.findMessageById(messageId);
        return response.isPresent() ?
                MessageApiResponse.MessageResponseBuilder()
                        .msg("Successfully fetched message using messageId: " + messageId)
                        .messageStatus(MessageStatusEnum.SEEN)
                        .messages(response.get())
                        .build()
                : MessageApiResponse.MessageResponseBuilder()
                .error("Error occurred while fetching ")
                .messageStatus(MessageStatusEnum.FAILED)
                .msg("Check if the messageId is correct: " + messageId)
                .build();

    }
}
