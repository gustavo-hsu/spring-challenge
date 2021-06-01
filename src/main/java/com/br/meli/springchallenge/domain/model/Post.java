package com.br.meli.springchallenge.domain.model;

import com.br.meli.springchallenge.dto.PostRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @OneToOne
    private Product product;

    private int category;

    private Double price;
}