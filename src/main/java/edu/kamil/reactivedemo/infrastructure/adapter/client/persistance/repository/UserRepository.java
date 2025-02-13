package edu.kamil.reactivedemo.infrastructure.adapter.client.persistance.repository;

import edu.kamil.reactivedemo.infrastructure.adapter.client.persistance.model.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends R2dbcRepository<User, Long> {
    Mono<User> findByName(String name);
}
