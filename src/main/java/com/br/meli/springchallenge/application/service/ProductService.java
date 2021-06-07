package com.br.meli.springchallenge.application.service;

import com.br.meli.springchallenge.domain.model.Category;
import com.br.meli.springchallenge.domain.model.Post;
import com.br.meli.springchallenge.dto.PostDTO;
import com.br.meli.springchallenge.dto.response.PostsResponse;
import com.br.meli.springchallenge.dto.response.PromotionCountResponse;
import com.br.meli.springchallenge.exceptions.ApiException;

public interface ProductService {
    Post createPost(PostDTO postDTO) throws ApiException;

    PostsResponse getPostsForUser(int userId, String dateAsc);

    Category createCategory(Category category);

    void createPromoPost(PostDTO postDTO) throws ApiException;

    PromotionCountResponse getPromotionProductsCount(int userId) throws ApiException;

    PostsResponse getPostsFromUser(int userId);
}
