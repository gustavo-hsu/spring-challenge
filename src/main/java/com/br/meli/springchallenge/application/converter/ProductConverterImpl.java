package com.br.meli.springchallenge.application.converter;

import com.br.meli.springchallenge.domain.model.Category;
import com.br.meli.springchallenge.domain.model.Post;
import com.br.meli.springchallenge.domain.model.User;
import com.br.meli.springchallenge.domain.repository.CategoryRepository;
import com.br.meli.springchallenge.domain.repository.UserRepository;
import com.br.meli.springchallenge.dto.PostDTO;
import org.springframework.stereotype.Service;

@Service
public class ProductConverterImpl implements ProductConverter {
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;

    private ProductConverterImpl(UserRepository userRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Post fromPostRequestToPostEntity(PostDTO request) {
        User user = userRepository.findById(request.getUserId()).orElse(null);
        Category category = categoryRepository.findById(request.getCategory()).orElse(null);

        if (user == null) {
            throw new IllegalArgumentException("User with id " + request.getUserId() + " not found");
        }

        if(category == null) {
            throw new IllegalArgumentException("Category with id " + request.getCategory() + " not found");
        }

        Post post = request.toPostEntity();
        post.getProduct().setCategory(category);
        post.setUser(user);

        return post;
    }
}
