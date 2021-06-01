package com.br.meli.springchallenge.model;

import javax.persistence.*;

@Entity
@Table(name="follower")
public class Follower {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="from_user_id")
    private User from;

    @ManyToOne
    @JoinColumn(name="to_user_id")
    private User to;

    public Follower() {};

    public Follower(User from, User to) {
        this.from = from;
        this.to = to;
    }

    public int getId() {
        return this.from.getId();
    }

    public String getName() {
        return this.from.getName();
    }
}