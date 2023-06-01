package com.asv.demo.core.domain;

import com.asv.demo.adapters.controllers.MessageRequest;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Document(collection = "messages")
@Data
@Builder
public class Message {
    @Id
    private String id;
    private String text;
    private LocalDate createdAt;
}
