package com.asv.demo.core.ports;

import com.asv.demo.core.domain.Message;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MessageUseCase {
    public Flux<Message> findAll();
    public Mono<Message> save(Message message);
}
