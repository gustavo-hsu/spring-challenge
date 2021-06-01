package com.br.meli.springchallenge.controller;

import com.br.meli.springchallenge.application.PostService;
import com.br.meli.springchallenge.domain.model.Post;
import com.br.meli.springchallenge.dto.PostDTO;
import com.br.meli.springchallenge.dto.PostsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private PostService postService;

    public ProductController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/newpost")
    public ResponseEntity newPost(@RequestBody PostDTO postDTO){
        Post post = postService.createPost(postDTO);

        return new ResponseEntity(post, HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity listPostsForUser(@PathVariable int userId){
        PostsResponse posts = postService.getPostsForUser(userId);

        return new ResponseEntity(posts, HttpStatus.OK);
    }
}
