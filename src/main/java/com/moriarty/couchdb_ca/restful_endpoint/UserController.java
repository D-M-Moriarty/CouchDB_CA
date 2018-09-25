package com.moriarty.couchdb_ca.restful_endpoint;

import com.moriarty.couchdb_ca.db_repository.UserRepository;
import com.moriarty.couchdb_ca.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    @GetMapping("/id={_id}")
    public User getUser(@PathVariable String _id) {
        return userRepository.get(_id);
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user) {
        userRepository.add(user);
        return user;
    }

    @GetMapping("/name={name}")
    public List<User> updateUser(@PathVariable String name) {
        return userRepository.findByName(name);
    }

    @GetMapping("/get_name_cust")
    public String updateUser() {
        return userRepository.getNameCust();
    }

    @DeleteMapping("/{_id}")
    public void deleteUser(@PathVariable String _id) {
        User user = userRepository.get(_id);
        userRepository.remove(user);
    }
}
