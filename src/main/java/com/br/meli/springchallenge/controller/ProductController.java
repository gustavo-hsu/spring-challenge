package com.br.meli.springchallenge.controller;

import com.br.meli.springchallenge.application.service.PostService;
import com.br.meli.springchallenge.dto.PostDTO;
import com.br.meli.springchallenge.dto.response.PostsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private PostService postService;

    public ProductController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/newpost")
    public ResponseEntity newPost(@RequestBody PostDTO postDTO){
        postService.createPost(postDTO);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity listPostsForUser(@PathVariable int userId, @RequestParam(required = false) String order){
        PostsResponse posts = postService.getPostsForUser(userId, order);

        return new ResponseEntity(posts, HttpStatus.OK);
    }
}
