package com.asv.demo.configuration;

import com.asv.demo.adapters.repositories.ReactiveMongoMessageRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories(basePackageClasses = ReactiveMongoMessageRepository.class)
public class MongoDBConfiguration {
}
