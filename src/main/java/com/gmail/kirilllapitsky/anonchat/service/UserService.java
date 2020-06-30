package com.gmail.kirilllapitsky.anonchat.service;

import com.gmail.kirilllapitsky.anonchat.entity.User;
import com.gmail.kirilllapitsky.anonchat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Long register() {
        User user = new User();
        userRepository.save(user);
        return user.getId();
    }
}
