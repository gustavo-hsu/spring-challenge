package com.br.meli.springchallenge.application.converter;

import com.br.meli.springchallenge.application.validator.UserValidator;
import com.br.meli.springchallenge.domain.model.Category;
import com.br.meli.springchallenge.domain.model.Post;
import com.br.meli.springchallenge.domain.model.User;
import com.br.meli.springchallenge.domain.repository.CategoryRepository;
import com.br.meli.springchallenge.domain.repository.UserRepository;
import com.br.meli.springchallenge.dto.PostDTO;
import com.br.meli.springchallenge.exceptions.ApiException;
import com.br.meli.springchallenge.exceptions.NotFoundApiException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostConverterImpl implements PostConverter {
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;
    private UserValidator userValidator;

    @Override
    public Post fromPostRequestToPostEntity(PostDTO request) throws ApiException {
        User user = userRepository.findById(request.getUserId()).orElse(null);
        Category category = categoryRepository.findById(request.getCategory()).orElse(null);

        validateRequest(request, user, category);

        Post post = request.toPostEntity();
        post.getProduct().setCategory(category);
        post.setUser(user);

        return post;
    }

    private void validateRequest(PostDTO request, User user, Category category) throws ApiException {
        userValidator.validateSeller(user);

        if(category == null) {
            throw new NotFoundApiException("Category with id " + request.getCategory() + " not found");
        }
    }
}
