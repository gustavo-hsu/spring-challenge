package com.br.meli.springchallenge.application.service;

import com.br.meli.springchallenge.application.converter.ProductConverter;
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
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private PostRepository postRepository;
    private CategoryRepository categoryRepository;
    private ProductConverter productConverter;
    private ProductRepository productRepository;
    private UserRepository userRepository;

    public ProductServiceImpl(
            PostRepository postRepository,
            CategoryRepository categoryRepository,
            ProductConverter productConverter,
            ProductRepository productRepository,
            UserRepository userRepository
    ) {
        this.postRepository = postRepository;
        this.productConverter = productConverter;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Post createPost(PostDTO postDTO) {
        Post post = productConverter.fromPostRequestToPostEntity(postDTO);
        return postRepository.save(post);
    }

    @Override
    public PostsResponse getPostsForUser(int userId, String order) {
        List<Post> postList = postRepository.getPostsByUserId(userId, setOrderByDate(order));
        return new PostsResponse(userId, postList);
    }

    @Override
    public PromotionCountResponse getPromotionProducts(int userId) {
        User user = userRepository.findById(userId).orElse(null);

        return new PromotionCountResponse(userId, user.getName(), productRepository.getNumberOfPromotionByUserId(userId));
    }

    @Override
    public Category createCategory(Category category) {
       return categoryRepository.save(category);
    }

    @Override
    public void createPromoPost(PostDTO postDTO) {
        Post post = productConverter.fromPostRequestToPostEntity(postDTO);
        postRepository.save(post);
    }

    private Sort setOrderByDate(String order) {
        return (order == null || order.toLowerCase().contains("asc")) ? Sort.by("date").ascending() : Sort.by("date").descending();
    }
}
