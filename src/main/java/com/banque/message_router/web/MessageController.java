package com.banque.message_router.web;

import com.banque.message_router.application.MessageService;
import com.banque.message_router.domain.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<String> createMessage(@RequestBody MessageDto messageDto) {

        messageService.saveMessage(messageDto);

        return ResponseEntity.ok("Message received");
    }
}
