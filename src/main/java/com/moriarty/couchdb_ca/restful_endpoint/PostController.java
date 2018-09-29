package com.moriarty.couchdb_ca.restful_endpoint;

import com.moriarty.couchdb_ca.db_repository.PostRepository;
import com.moriarty.couchdb_ca.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("post")
public class PostController {

    @Autowired
    private PostRepository PostRepository;

    @GetMapping("")
    public List<Post> getAllPosts() {
        return PostRepository.getAll();
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable String _id) {
        return PostRepository.get(_id);
    }

    @PostMapping("")
    public Post addPost(@RequestBody Post Post) {
        PostRepository.add(Post);
        return Post;
    }

    @GetMapping("/name/{name}")
    public List<Post> updatePost(@PathVariable String name) {
        return PostRepository.findByTitle(name);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable String id) {
        Post Post = PostRepository.get(id);
        PostRepository.remove(Post);
    }
}
