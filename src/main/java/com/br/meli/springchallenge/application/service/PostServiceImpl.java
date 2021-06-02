package com.br.meli.springchallenge.application.service;

import com.br.meli.springchallenge.application.converter.ProductConverter;
import com.br.meli.springchallenge.domain.model.Post;
import com.br.meli.springchallenge.domain.repository.PostRepository;
import com.br.meli.springchallenge.domain.repository.ProductRepository;
import com.br.meli.springchallenge.dto.PostDTO;
import com.br.meli.springchallenge.dto.response.PostsResponse;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private ProductConverter productConverter;

    public PostServiceImpl(PostRepository postRepository, ProductRepository productRepository, ProductConverter productConverter) {
        this.postRepository = postRepository;
        this.productConverter = productConverter;
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

    private Sort setOrderByDate(String order) {
        return order.equals("date_asc") ? Sort.by("date").ascending() : Sort.by("date").descending();
    }
}
