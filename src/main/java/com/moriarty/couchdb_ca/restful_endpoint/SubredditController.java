package com.moriarty.couchdb_ca.restful_endpoint;

import com.moriarty.couchdb_ca.db_repository.SubredditRepository;
import com.moriarty.couchdb_ca.entity.Subreddit;
import com.moriarty.couchdb_ca.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("r")
public class SubredditController {

    @Autowired
    private SubredditRepository subredditRepository;

    @GetMapping("")
    public List<Subreddit> getAllSubreddits() {
        return subredditRepository.getAll();
    }

    @GetMapping("/{id}")
    public Subreddit getUser(@PathVariable String _id) {
        return subredditRepository.get(_id);
    }

    @PostMapping("")
    public Subreddit addSubreddit(@RequestBody Subreddit subreddit) {
        subredditRepository.add(subreddit);
        return subreddit;
    }

    @GetMapping("/name/{name}")
    public List<Subreddit> updateUser(@PathVariable String name) {
        return subredditRepository.findByName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        Subreddit subreddit = subredditRepository.get(id);
        subredditRepository.remove(subreddit);
    }
}
