package com.hmp.server.controller;

import com.hmp.server.dto.MessageDto;
import com.hmp.server.response.MessageApiResponse;
import com.hmp.server.service.impl.MessageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
public MessageApiResponse sendMessage(@RequestBody MessageDto messageDto){
return null;
    }
}
