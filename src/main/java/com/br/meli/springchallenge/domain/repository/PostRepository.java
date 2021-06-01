package com.br.meli.springchallenge.domain.repository;

import com.br.meli.springchallenge.domain.model.Post;
import com.br.meli.springchallenge.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "select * from post p where " +
            "p.user_id in " +
            "(select f.to_user_id from follower f where f.from_user_id = ?1)",
            nativeQuery = true)
    List<Post> getPostsByUserId(int userId);
}
