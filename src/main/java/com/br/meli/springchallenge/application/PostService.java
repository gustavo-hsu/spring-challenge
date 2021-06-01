package com.br.meli.springchallenge.application;

import com.br.meli.springchallenge.domain.model.Post;
import com.br.meli.springchallenge.dto.PostRequest;

public interface PostService {
    Post createPost(PostRequest postRequest);
}
