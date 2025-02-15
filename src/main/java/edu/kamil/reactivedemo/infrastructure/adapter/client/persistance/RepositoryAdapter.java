package edu.kamil.reactivedemo.infrastructure.adapter.client.persistance;

import edu.kamil.reactivedemo.domain.port.persistance.RepositoryPort;
import edu.kamil.reactivedemo.infrastructure.adapter.client.persistance.model.User;
import edu.kamil.reactivedemo.infrastructure.adapter.client.persistance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
class RepositoryAdapter implements RepositoryPort {
    private final UserRepository userRepository;


    @Override
    public Mono<Boolean> saveUser(User user) {
        return userRepository.save(user).map(u -> true);
    }

    @Override
    public Mono<User> findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Mono<User> findUserByPesel(String pesel) {
        return userRepository.findByPesel(pesel);
    }
}
