package com.br.meli.springchallenge.domain.repository;

import com.br.meli.springchallenge.domain.model.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface FollowerRepository extends JpaRepository<Follower, Integer> {

    @Query(value = "SELECT * FROM follower f where f.follower_user_id = ?1 and f.following_user_id = ?2", nativeQuery = true)
    Follower findByIds(int userId, int userIdToFollow);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM follower f WHERE f.follower_user_id = ?1 and f.following_user_id = ?2", nativeQuery = true)
    void deleteByIds(int userId, int userIdToFollow);
}
