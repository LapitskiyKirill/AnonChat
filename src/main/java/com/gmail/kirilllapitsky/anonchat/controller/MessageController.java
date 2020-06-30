package com.gmail.kirilllapitsky.anonchat.controller;

import com.gmail.kirilllapitsky.anonchat.dto.MessageDto;
import com.gmail.kirilllapitsky.anonchat.entity.Message;
import com.gmail.kirilllapitsky.anonchat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("save")
    void save(@RequestBody MessageDto messageDto) {
        messageService.saveMessage(messageDto);
    }

    @GetMapping("getBeforeId")
    List<Message> getMessagesBeforeId(@RequestParam Long id) {
        return messageService.getMessage(id);
    }

    @GetMapping("getMessages")
    List<Message> getMessages() {
        return messageService.getMessages();
    }
}
