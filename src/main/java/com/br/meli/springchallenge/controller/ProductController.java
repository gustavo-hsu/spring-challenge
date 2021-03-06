package com.br.meli.springchallenge.controller;

import com.br.meli.springchallenge.application.service.ProductService;
import com.br.meli.springchallenge.domain.model.Category;
import com.br.meli.springchallenge.dto.PostDTO;
import com.br.meli.springchallenge.dto.response.PostsResponse;
import com.br.meli.springchallenge.dto.response.PromotionCountResponse;
import com.br.meli.springchallenge.exceptions.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @PostMapping("/newpost")
    public ResponseEntity createPost(@RequestBody PostDTO postDTO) throws ApiException {
        productService.createPost(postDTO);

        return new ResponseEntity("Post created with success!", HttpStatus.OK);
    }

    @PostMapping("/newpromopost")
    public ResponseEntity createPromoPost(@RequestBody PostDTO postDTO) throws ApiException {
        productService.createPromoPost(postDTO);

        return new ResponseEntity("Post created with success!", HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity listPostsForUser(@PathVariable int userId, @RequestParam(required = false) String order){
        PostsResponse posts = productService.getPostsForUser(userId, order);

        return new ResponseEntity(posts, HttpStatus.OK);
    }

    @GetMapping("/{userId}/countPromo")
    public ResponseEntity listPostsForUser(@PathVariable int userId) throws ApiException {
        PromotionCountResponse countResponse = productService.getPromotionProductsCount(userId);

        return new ResponseEntity(countResponse, HttpStatus.OK);
    }

    @GetMapping("/{userId}/list")
    public ResponseEntity listPostsFromUser(@PathVariable int userId){
        PostsResponse countResponse = productService.getPostsFromUser(userId);

        return new ResponseEntity(countResponse, HttpStatus.OK);
    }

    @PostMapping("/category")
    public ResponseEntity createCategory(@RequestBody Category category) {
        return new ResponseEntity(productService.createCategory(category), HttpStatus.CREATED);
    }
}
