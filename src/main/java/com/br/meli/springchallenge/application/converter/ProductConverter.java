package com.br.meli.springchallenge.application.converter;

import com.br.meli.springchallenge.domain.model.Post;
import com.br.meli.springchallenge.dto.PostDTO;

public interface ProductConverter {
    Post fromPostRequestToPostEntity(PostDTO request);
}