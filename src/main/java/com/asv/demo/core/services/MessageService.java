package com.asv.demo.core.services;

import com.asv.demo.adapters.repositories.ReactiveMongoMessageRepository;
import com.asv.demo.core.domain.Message;
import com.asv.demo.core.ports.MessageUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MessageService implements MessageUseCase {

    @Autowired
    ReactiveMongoMessageRepository reactiveMongoMessageRepository;
    @Override
    public Flux<Message> findAll() {
        return reactiveMongoMessageRepository.findAll();
    }

    @Override
    public Mono<Message> save(Message message) {
        return reactiveMongoMessageRepository.save(message);
    }
}
