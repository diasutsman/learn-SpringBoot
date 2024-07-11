package io.github.diasutsman.runnerz.user;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface UserHttpClient {

    @GetExchange("/users")
    public List<User> findAll();

    @GetExchange("/users/{id}")
    public User findById(@PathVariable Integer id);
}
