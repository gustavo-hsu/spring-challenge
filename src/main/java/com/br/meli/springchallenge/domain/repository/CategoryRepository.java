package com.br.meli.springchallenge.domain.repository;

import com.br.meli.springchallenge.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> { }
