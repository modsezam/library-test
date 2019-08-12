package com.sda;

import com.sda.entity.Book;
import com.sda.entity.BorrowHistory;
import com.sda.entity.User;

import java.sql.Date;
import java.time.LocalDate;


public class Main {

    public static void main(String[] args) {

        DAO dao = new DAO();

        User user1 = new User("sd@wp.pl", "mod", "sezam");
        User user2 = new User("sd@wp.pl2", "mod2", "sezam2");


        Book book1 = new Book("title book", "subtitle book");
        Book book2 = new Book("title book2", "subtitle book2");

        BorrowHistory borrowHistory1 = new BorrowHistory();
        BorrowHistory borrowHistory2 = new BorrowHistory();

        borrowHistory1.setBorrowDate(Date.valueOf(LocalDate.now()));
        borrowHistory1.setBook(book1);
        borrowHistory1.setUser(user1);


//        book2.borrowBookByUser(user2);
//
//        dao.newObject(book1);
//        dao.newObject(book2);
////        dao.newObject(user2);
////        dao.delete(user2);
//
//        book1.returnBookByUser(user1);
//        book1.borrowBookByUser(user2);
//        book2.borrowBookByUser(user1);
//

        dao.newObject(book1);
        dao.newObject(book2);
        dao.newObject(user1);
        dao.newObject(borrowHistory1);

        dao.delete(book2);
    }
}
