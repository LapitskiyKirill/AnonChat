package com.gmail.kirilllapitsky.anonchat.service;

import com.gmail.kirilllapitsky.anonchat.dto.MessageDto;
import com.gmail.kirilllapitsky.anonchat.entity.Message;
import com.gmail.kirilllapitsky.anonchat.entity.User;
import com.gmail.kirilllapitsky.anonchat.repository.MessageRepository;
import com.gmail.kirilllapitsky.anonchat.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public MessageService(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    public Message saveMessage(MessageDto messageDto) {
        User user = userRepository.findById(messageDto.user_id).get();
        Message message = new Message(user, messageDto.value);
        return messageRepository.save(message);
    }

    public List<Message> getMessage(Long id) {
        return messageRepository.findTop30MessagesByIdBeforeOrderByIdDesc(id);
    }

    public List<Message> getMessages() {
        Message message = messageRepository.findTopByOrderByIdDesc().get();
        List<Message> messages = messageRepository.findTop30MessagesByIdBeforeOrderByIdDesc(message.getId());
        messages.add(0, message);
        return messages;
    }

    public Message getFirstMessage() {
        return messageRepository.findTopByOrderByIdAsc().get();
    }
}
