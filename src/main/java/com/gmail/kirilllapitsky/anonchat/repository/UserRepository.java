package com.gmail.kirilllapitsky.anonchat.repository;

import com.gmail.kirilllapitsky.anonchat.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findById(Long id);
}
