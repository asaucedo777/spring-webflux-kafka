package com.asv.demo.core.services;

import com.asv.demo.adapters.repositories.ReactiveMongoMessageRepository;
import com.asv.demo.core.domain.Message;
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
public class MessageServiceTest {
    @Mock
    private ReactiveMongoMessageRepository reactiveMongoMessageRepository;
    @InjectMocks
    private MessageService underTest = new MessageService();

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
        Mockito.doReturn(fluxJust).when(reactiveMongoMessageRepository).findAll();
        this.underTest.findAll();
        StepVerifier.create(fluxJust)
                .expectNext(message1)
                .expectNext(message2)
                .expectNext(message3)
                .verifyComplete();
    }

    @Test
    void save() {
        @Valid Message message = Message.builder()
                .id("1")
                .text("text1")
                .createdAt(LocalDate.parse("2023-01-01"))
                .build();
        Message message1 = Message.builder().id("1").text("text1").createdAt(LocalDate.parse("2023-01-01")).build();
        Mono<Message> fluxJust = Mono.just(
                message1
        );
        Mockito.doReturn(fluxJust).when(reactiveMongoMessageRepository).save(any());
        this.underTest.save(message);
        StepVerifier.create(fluxJust)
                .expectNext(message1)
                .verifyComplete();
    }
}