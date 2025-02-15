package edu.kamil.reactivedemo.infrastructure.adapter.rest;

import edu.kamil.reactivedemo.domain.port.persistance.RepositoryPort;
import edu.kamil.reactivedemo.domain.user.UserServicePort;
import edu.kamil.reactivedemo.infrastructure.adapter.client.persistance.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    final private UserServicePort userService;

    @PostMapping
    public Mono<Boolean> createUser(@RequestBody User user) {

        return userService.saveUser(user);
    }

    @GetMapping
    public Mono<User> getUser(@RequestParam final long id) {
        return userService.getUser(id);
    }

    @PutMapping
    public Mono<Boolean> updateUser(@RequestParam String pesel,
                                 @RequestBody User user,
                                 @RequestHeader("Role") String requesterRole) {
        return userService.updateUser(pesel, user, requesterRole);
    }
}
