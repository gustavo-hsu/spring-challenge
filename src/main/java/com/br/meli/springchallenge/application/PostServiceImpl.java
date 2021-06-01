package com.br.meli.springchallenge.application;

import com.br.meli.springchallenge.domain.model.Post;
import com.br.meli.springchallenge.domain.model.Product;
import com.br.meli.springchallenge.domain.repository.PostRepository;
import com.br.meli.springchallenge.domain.repository.ProductRepository;
import com.br.meli.springchallenge.dto.PostRequest;
import org.springframework.stereotype.Service;

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
    public Post createPost(PostRequest postRequest) {
        Post post = productConverter.fromPostRequestToPostEntity(postRequest);

        Product product = postRequest.toProductEntity();
        productRepository.save(product);

        return postRepository.save(post);
    }
}
