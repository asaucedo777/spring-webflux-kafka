package com.asv.demo.adapters.controllers;

import com.asv.demo.core.domain.Message;
import com.asv.demo.core.services.MessageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import javax.validation.Valid;
import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class MessageControllerTest {
    @Mock
    private MessageService messageService;
    @InjectMocks
    private MessageController underTest = new MessageController();
    @Test
    void findAll() {
        Message message1 = Message.builder().id("1").text("text1").createdAt(LocalDate.parse("2023-01-01")).build();
        Message message2 = Message.builder().id("2").text("text2").createdAt(LocalDate.parse("2023-01-02")).build();
        Message message3 = Message.builder().id("3").text("text3").createdAt(LocalDate.parse("2023-01-03")).build();
        Flux<Message> fluxJust = Flux.just(
            message1,
            message2,
            message3
        );
        Mockito.doReturn(fluxJust).when(messageService).findAll();
        this.underTest.findAll();
        StepVerifier.create(fluxJust)
                .expectNext(message1)
                .expectNext(message2)
                .expectNext(message3)
                .verifyComplete();
    }
    @Test
    void save() {
        @Valid MessageRequest messageRequest = MessageRequest.builder()
                .id("1")
                .text("text1")
                .createdAt("2023-01-01")
                .build();
        Message message1 = Message.builder().id("1").text("text1").createdAt(LocalDate.parse("2023-01-01")).build();
        Mono<Message> fluxJust = Mono.just(
                message1
        );
        Mockito.doReturn(fluxJust).when(messageService).save(any());
        this.underTest.save(messageRequest);
        StepVerifier.create(fluxJust)
                .expectNext(message1)
                .verifyComplete();
    }
}