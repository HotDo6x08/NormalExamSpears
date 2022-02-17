package com.greenfoxacademy.normalexam.models;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "meals")
@NoArgsConstructor
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Type type;

    @ManyToOne
    private User user;

    public Meal(Long id, String title, Type type, User user) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.user = user;
    }

    public Meal(String title, Type type, User user) {
        this.title = title;
        this.type = type;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
