package com.sda.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@NoArgsConstructor
@Entity
@Table(name="book")
public class Book {
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

    @OneToMany(mappedBy = "book")
    private Set<BorrowHistory> borrowHistories;

    public Book(String title, String subtitle, BorrowHistory... borrowHistories) {
        this.title = title;
        this.subtitle = subtitle;
        for(BorrowHistory bookPublisher : borrowHistories) bookPublisher.setBook(this);
        this.borrowHistories = Stream.of(borrowHistories).collect(Collectors.toSet());
    }


    public Book(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }
}
