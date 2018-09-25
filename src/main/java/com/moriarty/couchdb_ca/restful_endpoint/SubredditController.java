package com.moriarty.couchdb_ca.restful_endpoint;

import com.moriarty.couchdb_ca.db_repository.SubredditRepository;
import com.moriarty.couchdb_ca.entity.Subreddit;
import com.moriarty.couchdb_ca.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("r")
public class SubredditController {

    @Autowired
    private SubredditRepository subredditRepository;

    @GetMapping("/all")
    public List<Subreddit> getAllSubreddits() {
        return subredditRepository.getAll();
    }

    @GetMapping("/id={_id}")
    public Subreddit getUser(@PathVariable String _id) {
        return subredditRepository.get(_id);
    }

    @PostMapping("/")
    public Subreddit addUser(@RequestBody Subreddit user) {
        subredditRepository.add(user);
        return user;
    }

    @GetMapping("/name={name}")
    public List<Subreddit> updateUser(@PathVariable String name) {
        return subredditRepository.findByName(name);
    }

    @DeleteMapping("/{_id}")
    public void deleteUser(@PathVariable String _id) {
        Subreddit subreddit = subredditRepository.get(_id);
        subredditRepository.remove(subreddit);
    }
}
