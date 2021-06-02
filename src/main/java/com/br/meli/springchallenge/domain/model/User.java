package com.br.meli.springchallenge.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;

    private boolean isSeller = true;

    @Nullable
    @OneToMany(mappedBy="follower")
    private List<Follower> followers;

    @Nullable
    @OneToMany(mappedBy="following")
    private List<Follower> following;

    public User(String name) {
        this.name = name;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String name, boolean isSeller) {
        this.name = name;
        this.isSeller = isSeller;
    }

    public List<Follower> setFollowersOrderByName(String order) {
        if (order == null || order.toLowerCase().contains("asc")) {
            this.followers.sort(Comparator.comparing(Follower::getFollowerName));
        } else {
            this.followers.sort(Comparator.comparing(Follower::getFollowerName).reversed());
        }

        return this.followers;
    }

    public List<Follower> setFollowingOrderByName(String order) {
        if (order == null || order.toLowerCase().contains("asc")) {
            this.following.sort(Comparator.comparing(Follower::getFollowingName));
        } else {
            this.following.sort(Comparator.comparing(Follower::getFollowingName).reversed());
        }

        return following;
    }



    public int countFollowers() {
        return this.followers.size();
    }
}
