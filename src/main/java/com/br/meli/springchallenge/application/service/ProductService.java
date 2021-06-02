package com.br.meli.springchallenge.application.service;

import com.br.meli.springchallenge.domain.model.Category;
import com.br.meli.springchallenge.domain.model.Post;
import com.br.meli.springchallenge.dto.PostDTO;
import com.br.meli.springchallenge.dto.response.PostsResponse;

public interface ProductService {
    Post createPost(PostDTO postDTO);

    PostsResponse getPostsForUser(int userId, String dateAsc);

    Category createCategory(Category category);
}
