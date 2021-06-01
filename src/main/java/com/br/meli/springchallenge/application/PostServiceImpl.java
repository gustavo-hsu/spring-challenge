package com.br.meli.springchallenge.application;

import com.br.meli.springchallenge.domain.model.Post;
import com.br.meli.springchallenge.domain.repository.PostRepository;
import com.br.meli.springchallenge.domain.repository.ProductRepository;
import com.br.meli.springchallenge.dto.PostDTO;
import com.br.meli.springchallenge.dto.PostsResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private ProductRepository productRepository;
    private ProductConverter productConverter;

    public PostServiceImpl(PostRepository postRepository, ProductRepository productRepository, ProductConverter productConverter) {
        this.postRepository = postRepository;
        this.productRepository = productRepository;
        this.productConverter = productConverter;
    }

    @Override
    public Post createPost(PostDTO postDTO) {
        Post post = productConverter.fromPostRequestToPostEntity(postDTO);
        return postRepository.save(post);
    }

    @Override
    public PostsResponse getPostsForUser(int userId) {
       List<Post> postList = postRepository.getPostsByUserId(userId);

       PostsResponse posts = new PostsResponse(userId, postList);

       return posts;
    }
}
