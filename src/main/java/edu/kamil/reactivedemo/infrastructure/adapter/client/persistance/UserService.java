package edu.kamil.reactivedemo.infrastructure.adapter.client.persistance;

import edu.kamil.reactivedemo.infrastructure.adapter.client.persistance.model.User;
import edu.kamil.reactivedemo.infrastructure.adapter.client.persistance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
class UserService {
    private final UserRepository userRepository;

    Mono<Boolean> createUser(User user) {
        return userRepository.save(user).map(u -> true);
    }

    Mono<User> getUser(long id) {
        return userRepository.findById(id);
    }
}
