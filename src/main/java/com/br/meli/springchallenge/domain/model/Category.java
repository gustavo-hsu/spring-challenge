package com.br.meli.springchallenge.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="category")
@Setter
@Getter
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue
    private int id;

    private String name;
}
