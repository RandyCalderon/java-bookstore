package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
