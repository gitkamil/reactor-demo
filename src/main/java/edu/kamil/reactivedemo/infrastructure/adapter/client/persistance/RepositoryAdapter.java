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
        return userService.saveUser(user);
    }

    @Override
    public Mono<User> findUserById(long id) {
        return userService.getUser(id);
    }

    public Mono<Boolean> updateUser(String pesel, User user, String requesterRole) {
        if (!"ADMIN".equals(requesterRole)) {
            return Mono.error(new IllegalAccessException("Only ADMIN can modify users"));
        }
        return userService.findByPesel(pesel)
                .flatMap(existingUser -> {
                    existingUser.setFirstName(user.getFirstName());
                    existingUser.setLastName(user.getLastName());
                    existingUser.setPesel(user.getPesel());
                    existingUser.setRole(user.getRole());

                    return userService.saveUser(existingUser);
                });
    }
}
