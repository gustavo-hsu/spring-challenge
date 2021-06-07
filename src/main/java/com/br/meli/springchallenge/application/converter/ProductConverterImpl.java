package com.br.meli.springchallenge.application.converter;

import com.br.meli.springchallenge.application.validator.UserValidator;
import com.br.meli.springchallenge.domain.model.Category;
import com.br.meli.springchallenge.domain.model.Post;
import com.br.meli.springchallenge.domain.model.User;
import com.br.meli.springchallenge.domain.repository.CategoryRepository;
import com.br.meli.springchallenge.domain.repository.UserRepository;
import com.br.meli.springchallenge.dto.PostDTO;
import com.br.meli.springchallenge.exceptions.ApiException;
import com.br.meli.springchallenge.exceptions.BadRequestApiException;
import com.br.meli.springchallenge.exceptions.NotFoundApiException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductConverterImpl implements ProductConverter {
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;

    @Override
    public Post fromPostRequestToPostEntity(PostDTO request) throws ApiException {
        User user = userRepository.findById(request.getUserId()).orElse(null);
        Category category = categoryRepository.findById(request.getCategory()).orElse(null);

        if (user == null) {
            throw new NotFoundApiException("User with id " + request.getUserId() + " not found");
        }

        if (!user.isSeller()) {
            throw new BadRequestApiException("User with id " + request.getUserId() + " is not a seller and can not publish posts");
        }

        if(category == null) {
            throw new BadRequestApiException("Category with id " + request.getCategory() + " not found");
        }

        Post post = request.toPostEntity();
        post.getProduct().setCategory(category);
        post.setUser(user);

        return post;
    }
}
