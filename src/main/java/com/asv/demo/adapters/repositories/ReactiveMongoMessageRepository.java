package com.asv.demo.adapters.repositories;

import com.asv.demo.core.domain.Message;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveMongoMessageRepository
        extends ReactiveMongoRepository<Message, String> {
}
