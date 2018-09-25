package com.moriarty.couchdb_ca.restful_endpoint;

import com.moriarty.couchdb_ca.db_repository.UserRepository;
import com.moriarty.couchdb_ca.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String getRoot() {
        return "Root";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    @GetMapping("/users/{_id}")
    public User getUser(@PathVariable String _id) {
        return userRepository.get(_id);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        System.out.println(user);
        userRepository.add(user);
        return user;
    }

    @PutMapping("/users/{_id}")
    public void updateUser(@PathVariable String _id) {
        User user = userRepository.get(_id);
        userRepository.update(user);
    }

    @DeleteMapping("/users/{_id}")
    public void deleteUser(@PathVariable String _id) {
        User user = userRepository.get(_id);
        userRepository.remove(user);
    }
}
