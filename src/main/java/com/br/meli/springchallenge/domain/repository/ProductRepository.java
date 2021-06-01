package com.br.meli.springchallenge.domain.repository;

import com.br.meli.springchallenge.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> { }
