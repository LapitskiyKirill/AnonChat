package com.gmail.kirilllapitsky.anonchat.dto;

public class MessageDto {
    public Long user_id;
    public String value;

    public MessageDto() {
    }

    public MessageDto(Long user_id, String value) {
        this.user_id = user_id;
        this.value = value;
    }
}

