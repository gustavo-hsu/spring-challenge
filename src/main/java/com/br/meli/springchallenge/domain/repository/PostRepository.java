package com.br.meli.springchallenge.domain.repository;

import com.br.meli.springchallenge.domain.model.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "select p from Post p where " +
            "p.user in " +
            "(select f.follower from Follower f where f.following.id = ?1) " +
            "AND p.date >= (CURRENT_DATE() - 14) "+
            "AND p.date <= CURRENT_DATE()")
    List<Post> getPostsByUserId(int userId, Sort sort);
}
