package com.gmail.kirilllapitsky.anonchat.repository;

import com.gmail.kirilllapitsky.anonchat.entity.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findTop30MessagesByIdBeforeOrderByIdDesc(Long id);

    Optional<Message> findById(Long id);

    Optional<Message> findTopByOrderByIdDesc();

    Optional<Message> findTopByOrderByIdAsc();

}

