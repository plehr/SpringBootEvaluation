package de.plehr;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class UserController {
    private UserRepository userRespository;

    public UserController(UserRepository userRespository) {
        this.userRespository = userRespository;
    }

    @PostMapping(value = "/id", consumes = { "application/json" })
    @ResponseBody
    User insertUser(@RequestHeader HttpHeaders httpHeaders, @RequestBody User user) {
        return userRespository.save(user);
    }

    @GetMapping(value = "/id", consumes = { "application/json" })
    @ResponseBody
    Iterable<User> getAllUser() {
        return userRespository.findAll();
    }

    @GetMapping(value = "/id/{id}", consumes = { "application/json" })
    @ResponseBody
    Iterable<User> getUser(@PathVariable long id, @RequestHeader HttpHeaders httpHeaders) {
        return userRespository.findById(id);
    }
}
