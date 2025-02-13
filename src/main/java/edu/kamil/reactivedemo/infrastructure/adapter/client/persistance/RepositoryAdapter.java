package edu.kamil.reactivedemo.infrastructure.adapter.client.persistance;

import edu.kamil.reactivedemo.domain.port.persistance.RepositoryPort;
import edu.kamil.reactivedemo.infrastructure.adapter.client.persistance.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
class RepositoryAdapter implements RepositoryPort {
    private final UserService userService;

    @Override
    public Mono<Boolean> saveUser(User user) {
        return userService.createUser(user);
    }

    @Override
    public Mono<User> findUserById(long id) {
        return userService.getUser(id);
    }

}
