package com.br.meli.springchallenge.application.service;

import com.br.meli.springchallenge.domain.model.Category;
import com.br.meli.springchallenge.domain.model.Post;
import com.br.meli.springchallenge.dto.PostDTO;
import com.br.meli.springchallenge.dto.response.PostsResponse;
import com.br.meli.springchallenge.dto.response.PromotionCountResponse;
import com.br.meli.springchallenge.exceptions.BadRequestApiException;

public interface ProductService {
    Post createPost(PostDTO postDTO) throws BadRequestApiException;

    PostsResponse getPostsForUser(int userId, String dateAsc);

    Category createCategory(Category category);

    void createPromoPost(PostDTO postDTO) throws BadRequestApiException;

    PromotionCountResponse getPromotionProductsCount(int userId) throws BadRequestApiException;

    PostsResponse getPostsFromUser(int userId);
}
