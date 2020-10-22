package com.gmail.kirilllapitsky.anonchat.controller;

import com.gmail.kirilllapitsky.anonchat.dto.MessageDto;
import com.gmail.kirilllapitsky.anonchat.entity.Message;
import com.gmail.kirilllapitsky.anonchat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MessageController {
    private final SimpMessagingTemplate template;
    private final MessageService messageService;

    @Autowired
    MessageController(SimpMessagingTemplate template, MessageService messageService) {
        this.template = template;
        this.messageService = messageService;
    }

    @GetMapping("getBeforeId")
    List<Message> getMessagesBeforeId(@RequestParam Long id) {
        return messageService.getMessage(id);
    }

    @GetMapping("getMessages")
    List<Message> getMessages() {
        return messageService.getMessages();
    }

    @GetMapping("getFirstMessage")
    Message getFirstMessage() {
        return messageService.getFirstMessage();
    }

    @MessageMapping("/send/message")
    void saveMessage(MessageDto messageDto) {
        Message message = messageService.saveMessage(messageDto);
        this.template.convertAndSend("/message", message);

    }
}
