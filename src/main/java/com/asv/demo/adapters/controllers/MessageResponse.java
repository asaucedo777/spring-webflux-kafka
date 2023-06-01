package com.asv.demo.adapters.controllers;

import com.asv.demo.core.domain.Message;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
@Data
public class MessageResponse {
    private String id;
    private String text;
    private String createdAt;
    public MessageResponse(Message message) {
        this.id = message.getId();
        this.text = message.getText();
        this.createdAt = Optional.ofNullable(message.getCreatedAt()).orElse(LocalDate.now())
                .format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
