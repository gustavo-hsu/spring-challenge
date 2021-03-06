package com.br.meli.springchallenge.application.service;

import com.br.meli.springchallenge.application.converter.PostConverter;
import com.br.meli.springchallenge.application.validator.UserValidator;
import com.br.meli.springchallenge.domain.model.Category;
import com.br.meli.springchallenge.domain.model.Post;
import com.br.meli.springchallenge.domain.model.User;
import com.br.meli.springchallenge.domain.repository.CategoryRepository;
import com.br.meli.springchallenge.domain.repository.PostRepository;
import com.br.meli.springchallenge.domain.repository.ProductRepository;
import com.br.meli.springchallenge.domain.repository.UserRepository;
import com.br.meli.springchallenge.dto.PostDTO;
import com.br.meli.springchallenge.dto.response.PostsResponse;
import com.br.meli.springchallenge.dto.response.PromotionCountResponse;
import com.br.meli.springchallenge.exceptions.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private PostRepository postRepository;
    private CategoryRepository categoryRepository;
    private PostConverter postConverter;
    private ProductRepository productRepository;
    private UserRepository userRepository;
    private UserValidator userValidator;

    @Override
    public Post createPost(PostDTO postDTO) throws ApiException {
        Post post = postConverter.fromPostRequestToPostEntity(postDTO);
        return postRepository.save(post);
    }

    @Override
    public PostsResponse getPostsForUser(int userId, String order) {
        List<Post> postList = postRepository.getPostsByUserId(userId, setOrderByDate(order));
        return new PostsResponse(userId, postList);
    }

    @Override
    public PromotionCountResponse getPromotionProductsCount(int userId) throws ApiException {
        User user = userRepository.findById(userId).orElse(null);

        userValidator.validate(user);

        return new PromotionCountResponse(userId, user.getName(), productRepository.getNumberOfPromotionByUserId(userId));
    }

    @Override
    public PostsResponse getPostsFromUser(int userId) {
        List<Post> postList = postRepository.getPostsBySellerId(userId);
        return new PostsResponse(userId, postList);
    }

    @Override
    public Category createCategory(Category category) {
       return categoryRepository.save(category);
    }

    @Override
    public void createPromoPost(PostDTO postDTO) throws ApiException {
        Post post = postConverter.fromPostRequestToPostEntity(postDTO);
        postRepository.save(post);
    }

    private Sort setOrderByDate(String order) {
        return (order == null || order.toLowerCase().contains("desc")) ? Sort.by("date").descending() : Sort.by("date").ascending();
    }
}
