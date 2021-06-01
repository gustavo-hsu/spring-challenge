package com.br.meli.springchallenge.application;

import com.br.meli.springchallenge.domain.model.Post;
import com.br.meli.springchallenge.domain.model.User;
import com.br.meli.springchallenge.domain.repository.UserRepository;
import com.br.meli.springchallenge.dto.PostDTO;
import org.springframework.stereotype.Service;

@Service
public class ProductConverterImpl implements ProductConverter{
    private UserRepository userRepository;

    private ProductConverterImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Post fromPostRequestToPostEntity(PostDTO request) {
        User user = userRepository.findById(request.getUserId()).get();
        Post post = request.toPostEntity();
        post.setUser(user);

        return post;
    }
}
