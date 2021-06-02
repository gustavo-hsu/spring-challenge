package com.br.meli.springchallenge.application.service;

import com.br.meli.springchallenge.domain.model.Category;
import com.br.meli.springchallenge.domain.model.Post;
import com.br.meli.springchallenge.dto.PostDTO;
import com.br.meli.springchallenge.dto.response.PostsResponse;
import com.br.meli.springchallenge.dto.response.PromotionCountResponse;

public interface ProductService {
    Post createPost(PostDTO postDTO);

    PostsResponse getPostsForUser(int userId, String dateAsc);

    Category createCategory(Category category);

    void createPromoPost(PostDTO postDTO);

    PromotionCountResponse getPromotionProductsCount(int userId);

    PostsResponse getPostsFromUser(int userId);
}
