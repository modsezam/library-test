package com.sda.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "borrow_history")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.book",
                joinColumns = @JoinColumn(name = "books_isbn13")),
        @AssociationOverride(name = "primaryKey.user",
                joinColumns = @JoinColumn(name = "users_id")) })
public class BorrowHistory implements Serializable {

    @EmbeddedId
    private BorrowHistoryId primaryKey = new BorrowHistoryId();

    @Column(name = "borrow_date")
    private Date borrowDate;

}
