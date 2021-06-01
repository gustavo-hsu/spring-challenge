package com.br.meli.springchallenge.application;

import com.br.meli.springchallenge.domain.model.Post;
import com.br.meli.springchallenge.dto.PostDTO;
import com.br.meli.springchallenge.dto.PostsResponse;

public interface PostService {
    Post createPost(PostDTO postDTO);

    PostsResponse getPostsForUser(int userId);
}
