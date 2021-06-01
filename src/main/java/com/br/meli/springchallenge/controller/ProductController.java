package com.br.meli.springchallenge.controller;

import com.br.meli.springchallenge.application.PostService;
import com.br.meli.springchallenge.application.UserService;
import com.br.meli.springchallenge.domain.model.Post;
import com.br.meli.springchallenge.domain.model.Product;
import com.br.meli.springchallenge.domain.model.User;
import com.br.meli.springchallenge.dto.FollowerCountResponse;
import com.br.meli.springchallenge.dto.FollowerListResponse;
import com.br.meli.springchallenge.dto.FollowingListResponse;
import com.br.meli.springchallenge.dto.PostRequest;
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
    public ResponseEntity newPost(@RequestBody PostRequest postRequest){
        Post post = postService.createPost(postRequest);

        return new ResponseEntity(post, HttpStatus.OK);
    }
}
