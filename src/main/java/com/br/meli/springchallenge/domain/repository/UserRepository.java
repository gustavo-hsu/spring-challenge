package com.br.meli.springchallenge.domain.repository;

import com.br.meli.springchallenge.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> { }
