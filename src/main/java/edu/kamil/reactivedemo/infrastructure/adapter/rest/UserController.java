package edu.kamil.reactivedemo.infrastructure.adapter.rest;

import edu.kamil.reactivedemo.domain.port.persistance.RepositoryPort;
import edu.kamil.reactivedemo.infrastructure.adapter.client.persistance.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    final private RepositoryPort repositoryPort;

    @PostMapping
    public Mono<Boolean> createUser(@RequestBody User user) {

        return repositoryPort.saveUser(user);
    }

    @GetMapping
    public Mono<User> getUser(@RequestParam final long id) {
        return repositoryPort.findUserById(id);
    }

    @PutMapping
    public Mono<Boolean> updateUser(@RequestParam String pesel,
                                 @RequestBody User user,
                                 @RequestHeader("Role") String requesterRole) {
        return repositoryPort.updateUser(pesel, user, requesterRole);
    }
}
