package com.br.meli.springchallenge.application.converter;

import com.br.meli.springchallenge.domain.model.Post;
import com.br.meli.springchallenge.dto.PostDTO;
import com.br.meli.springchallenge.exceptions.ApiException;

public interface PostConverter {
    Post fromPostRequestToPostEntity(PostDTO request) throws ApiException;
}
