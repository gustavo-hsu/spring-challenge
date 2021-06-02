package com.br.meli.springchallenge.application.service;

import com.br.meli.springchallenge.application.converter.ProductConverter;
import com.br.meli.springchallenge.domain.model.Category;
import com.br.meli.springchallenge.domain.model.Post;
import com.br.meli.springchallenge.domain.repository.CategoryRepository;
import com.br.meli.springchallenge.domain.repository.PostRepository;
import com.br.meli.springchallenge.domain.repository.ProductRepository;
import com.br.meli.springchallenge.dto.PostDTO;
import com.br.meli.springchallenge.dto.response.PostsResponse;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private PostRepository postRepository;
    private CategoryRepository categoryRepository;
    private ProductConverter productConverter;

    public ProductServiceImpl(PostRepository postRepository, CategoryRepository categoryRepository, ProductConverter productConverter) {
        this.postRepository = postRepository;
        this.productConverter = productConverter;
        this.categoryRepository = categoryRepository;
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
    public Category createCategory(Category category) {
       return categoryRepository.save(category);
    }

    private Sort setOrderByDate(String order) {
        return order.equals("date_asc") ? Sort.by("date").ascending() : Sort.by("date").descending();
    }
}
