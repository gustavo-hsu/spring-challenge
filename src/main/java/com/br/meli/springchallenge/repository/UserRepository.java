package com.br.meli.springchallenge.repository;

import com.br.meli.springchallenge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT count(*) " +
            "FROM user " +
            "JOIN follower " +
            "ON user.id = follower.to_user_id " +
            "WHERE user.id = ?1", nativeQuery = true)
    int getNumberOfFollowersById(int userId);
}
