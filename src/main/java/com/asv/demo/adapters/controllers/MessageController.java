package com.asv.demo.adapters.controllers;

import com.asv.demo.core.domain.Message;
import com.asv.demo.core.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/messages")
@Validated
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping()
    public Flux<MessageResponse> findAll() {
        return messageService.findAll()
                .map(MessageResponse::new);
    }

    @PostMapping()
    public Mono<MessageResponse> save(@Valid @RequestBody MessageRequest messageRequest) {
        Message message = Stream.of(messageRequest)
                .map(m -> Message.builder()
                    .id(m.getId())
                    .text(m.getText())
                    .createdAt(LocalDate.parse(
                            Optional.ofNullable(m.getCreatedAt()).orElse(LocalDate.now().toString()),
                            DateTimeFormatter.ISO_LOCAL_DATE)).build())
                .findFirst()
                .get();
        return messageService.save(message)
                .map(MessageResponse::new);
    }

}
