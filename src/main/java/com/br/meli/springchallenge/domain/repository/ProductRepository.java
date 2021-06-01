package com.br.meli.springchallenge.domain.repository;

import com.br.meli.springchallenge.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> { }
