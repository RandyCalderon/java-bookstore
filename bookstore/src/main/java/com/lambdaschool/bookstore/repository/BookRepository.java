package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "INSERT INTO wrote VALUES (:bookid, :authid)", nativeQuery = true)
    Book insertIntoWrote(@Param("bookid") long bookid, @Param("authid")long authid);
}
