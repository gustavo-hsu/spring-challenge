package com.br.meli.springchallenge.domain.repository;

import com.br.meli.springchallenge.domain.model.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "select p from Post p where " +
            "p.user in " +
            "(select f.following from Follower f where f.follower.id = ?1) " +
            "AND p.date >= (CURRENT_DATE() - 14) "+
            "AND p.date <= CURRENT_DATE()")
    List<Post> getPostsByUserId(int userId, Sort sort);

    @Query(value = "select p from Post p join Product pr on p.product.id = pr.id where " +
            "p.user = (select u from User u where id = ?1) " +
            "and pr.hasPromo is true " +
            "order by p.date asc")
    List<Post> getPostsBySellerId(int userId);
}
