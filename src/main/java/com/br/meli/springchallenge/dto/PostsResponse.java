package com.br.meli.springchallenge.dto;

import com.br.meli.springchallenge.domain.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class PostsResponse {
    private int userId;
    private List<PostDTO> posts;

    public PostsResponse(int userId, List<Post> posts) {
        this.userId = userId;

        List<PostDTO> postsDTO = new ArrayList<>();
        for(Post post: posts) {
            postsDTO.add(post.toPostDTO());
        }

        this.posts = postsDTO;
    }
}
