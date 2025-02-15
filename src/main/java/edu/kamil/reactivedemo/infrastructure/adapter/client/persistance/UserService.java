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

    Mono<Boolean> saveUser(User user) {
        return userRepository.save(user).map(u -> true);
    }

    Mono<User> getUser(long id) {
        return userRepository.findById(id);
    }

    Mono<User> findByPesel(String pesel) {
        return userRepository.findByPesel(pesel);
    }
}
