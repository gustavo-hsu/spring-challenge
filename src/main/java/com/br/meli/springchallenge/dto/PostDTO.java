package com.br.meli.springchallenge.dto;

import com.br.meli.springchallenge.domain.model.Post;
import com.br.meli.springchallenge.domain.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude
public class PostDTO {
    private int userId;
    private int idPost;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date;
    private DetailDTO detail;
    private int category;
    private Double price;

    public PostDTO(int userId, int idPost, Date date, DetailDTO detail, int category, Double price) {
        this.userId = userId;
        this.idPost = idPost;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public Post toPostEntity() {
        Post post = new Post();
        Product product = this.toProductEntity();

        post.setDate(this.date);
        post.setProduct(product);

        return post;
    }

    public Product toProductEntity() {
        Product product =
                new Product(
                        this.detail.getProductId(),
                        this.detail.getProductName(),
                        this.detail.getType(),
                        this.detail.getBrand(),
                        this.detail.getColor(),
                        this.detail.getNotes(),
                        this.category,
                        this.price
                );

        return product;
    }
}
