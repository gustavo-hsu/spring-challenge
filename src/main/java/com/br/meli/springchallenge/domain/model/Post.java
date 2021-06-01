package com.br.meli.springchallenge.domain.model;

import com.br.meli.springchallenge.dto.DetailDTO;
import com.br.meli.springchallenge.dto.PostDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="post")
@NoArgsConstructor
@Setter
@Getter
public class Post {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private User user;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Product product;

    public PostDTO toPostDTO() {
        Product product = this.product;

        return new PostDTO(
                this.user.getId(),
                this.id,
                this.date,
                new DetailDTO(
                        product.getId(),
                        product.getProductName(),
                        product.getType(),
                        product.getBrand(),
                        product.getColor(),
                        product.getNotes()
                ),
                this.product.getCategory(),
                this.product.getPrice()
        );
    }
}