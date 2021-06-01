package com.br.meli.springchallenge.domain.repository;

import com.br.meli.springchallenge.domain.model.Post;
import com.br.meli.springchallenge.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Integer> { }
