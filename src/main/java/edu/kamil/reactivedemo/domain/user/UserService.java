package edu.kamil.reactivedemo.domain.user;

import edu.kamil.reactivedemo.domain.port.persistance.RepositoryPort;
import edu.kamil.reactivedemo.infrastructure.adapter.client.persistance.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
class UserService implements UserServicePort {
    private final RepositoryPort repositoryPort;

    @Override
   public Mono<Boolean> saveUser(User user) {
        return repositoryPort.saveUser(user).map(u -> true);
    }

   public Mono<User> getUser(long id) {
        return repositoryPort.findUserById(id);
    }

   public Mono<Boolean> updateUser(String pesel, User user, String requesterRole) {
                if (!"ADMIN".equals(requesterRole)) {
            return Mono.error(new IllegalAccessException("Only ADMIN can modify users"));
        }
        return repositoryPort.findUserByPesel(pesel)
                .flatMap(existingUser -> {
                    existingUser.setFirstName(user.getFirstName());
                    existingUser.setLastName(user.getLastName());
                    existingUser.setPesel(user.getPesel());
                    existingUser.setRole(user.getRole());

                    return repositoryPort.saveUser(existingUser);
                });
    }
}
