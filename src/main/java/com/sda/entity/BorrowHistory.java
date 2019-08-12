package com.sda.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.omg.PortableInterceptor.USER_EXCEPTION;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "borrow_history")
public class BorrowHistory implements Serializable {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Book book;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private User user;

    private Date borrowDate;

    public BorrowHistory(Book book, User user) {
        this.user = user;
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorrowHistory that = (BorrowHistory) o;
        return Objects.equals(book.getIsbn13(), that.book.getIsbn13()) &&
                Objects.equals(user.getEmail(), that.user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(book.getIsbn13(), user.getEmail());
    }
}
