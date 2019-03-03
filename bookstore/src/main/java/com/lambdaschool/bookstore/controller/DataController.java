package com.lambdaschool.bookstore.controller;

import com.lambdaschool.bookstore.model.Book;
import com.lambdaschool.bookstore.repository.AuthorRepository;
import com.lambdaschool.bookstore.repository.BookRepository;
import com.lambdaschool.bookstore.repository.SectionRepository;
import com.lambdaschool.bookstore.repository.UserRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Secured("ROLE_DATA")
@Api(value = "Endpoint for admin access to book, author and sections")
@RestController
@RequestMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
public class DataController {

    @Autowired
    AuthorRepository authorRepos;

    @Autowired
    BookRepository bookRepos;

    @Autowired
    SectionRepository sectionRepos;

    @ApiOperation(value = "Update book by id", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resources you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach can not be found")
    })
    @PutMapping("/{book/{id}")
    public Book updateBookById(@ApiParam(value="Param for updating Book body")@RequestBody Book updatedBook, @PathVariable long id) throws URISyntaxException {
        Optional<Book> newBook = bookRepos.findById(id);
        if (newBook.isPresent()) {
            updatedBook.setBookid(id);
            bookRepos.save(updatedBook);
            return updatedBook;
        } else {
            return null;
        }
    }

    @PostMapping("/books/{bookid}/{authid}")
    public void reAssignId(@PathVariable long bookid, @PathVariable long authorid) {
            bookRepos.insertIntoWrote(bookid, authorid);
    }


    @ApiOperation(value = "Delete book by id", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resources you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach can not be found")
    })
    @DeleteMapping("/book{id}")
    public Book deleteBookById(@ApiParam(value = "Param for id to delete")@PathVariable long id) {
        var foundBook = bookRepos.findById(id);
        if (foundBook.isPresent()) {
            bookRepos.deleteById(id);
            return foundBook.get();
        } else {
            return null;
        }
    }
}
