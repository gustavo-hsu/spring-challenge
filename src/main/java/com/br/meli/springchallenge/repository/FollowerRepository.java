package com.br.meli.springchallenge.repository;

import com.br.meli.springchallenge.model.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FollowerRepository extends JpaRepository<Follower, Integer> {

    @Query(value = "SELECT * FROM follower f where f.from_user_id = ?1 and f.to_user_id = ?2", nativeQuery = true)
    Follower findByIds(int userId, int userIdToFollow);
}
