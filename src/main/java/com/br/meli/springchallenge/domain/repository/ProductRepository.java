package com.br.meli.springchallenge.domain.repository;

import com.br.meli.springchallenge.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select count(*) from product pr join post p on p.product_id = pr.id" +
            " where pr.has_promo is true and p.user_id = ?1", nativeQuery = true)
    int getNumberOfPromotionByUserId(int userId);
}
