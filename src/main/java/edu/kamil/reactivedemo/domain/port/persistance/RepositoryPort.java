package edu.kamil.reactivedemo.domain.port.persistance;

import edu.kamil.reactivedemo.infrastructure.adapter.client.persistance.model.User;
import reactor.core.publisher.Mono;

public interface RepositoryPort  {
    Mono<Boolean> saveUser(User user);
    Mono<User> findUserById(long id);
    Mono<User> findUserByPesel(String pesel);
}