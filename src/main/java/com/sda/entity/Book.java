package com.sda.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long isbn13;
    private String title;
    private String subtitle;
    private String authors;
    private int pages;
    private int year;
    private int rating;
    private String description;
    @Column(name = "image_url")
    private String imageUrl;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "borrow_history")
    private Set<User> users;

    public Book(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    public void borrowBookByUser(User user){
        if (users == null){
            users = new HashSet<User>();
        }
        users.add(user);
    }

    public void returnBookByUser(User user){
        users.remove(user);
    }
}
