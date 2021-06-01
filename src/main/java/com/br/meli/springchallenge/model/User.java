package com.br.meli.springchallenge.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NoArgsConstructor
public class User {
//    @Id
//    @GeneratedValue
//    private Integer id;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @OneToMany(mappedBy = "user_follower")
//    private List<UserFollower> followers;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;

    @Nullable
    @OneToMany(mappedBy="to")
    private List<Follower> followers;

    @Nullable
    @OneToMany(mappedBy="from")
    @Fetch(FetchMode.JOIN)
    private List<Follower> following;


    public User(String name) {
        this.name = name;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int countFollowers() {
        return this.followers.size();
    }
}
