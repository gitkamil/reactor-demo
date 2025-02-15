package edu.kamil.reactivedemo.domain.user;

import edu.kamil.reactivedemo.infrastructure.adapter.client.persistance.model.User;
import reactor.core.publisher.Mono;

public interface UserServicePort {
    Mono<Boolean> saveUser(User user);
    Mono<User> getUser(long id);
    Mono<Boolean> updateUser(String pesel, User user, String requesterRole);
}
