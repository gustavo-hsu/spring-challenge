package com.br.meli.springchallenge.controller;

import com.br.meli.springchallenge.application.service.ProductService;
import com.br.meli.springchallenge.domain.model.Category;
import com.br.meli.springchallenge.dto.PostDTO;
import com.br.meli.springchallenge.dto.response.PostsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/newpost")
    public ResponseEntity newPost(@RequestBody PostDTO postDTO){
        productService.createPost(postDTO);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity listPostsForUser(@PathVariable int userId, @RequestParam(required = false) String order){
        PostsResponse posts = productService.getPostsForUser(userId, order);

        return new ResponseEntity(posts, HttpStatus.OK);
    }

    @PostMapping("/category")
    public ResponseEntity createCategory(@RequestBody Category category) {
        return new ResponseEntity(productService.createCategory(category), HttpStatus.CREATED);
    }
}
