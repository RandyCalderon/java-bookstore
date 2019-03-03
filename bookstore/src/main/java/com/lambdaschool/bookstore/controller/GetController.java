package com.lambdaschool.bookstore.controller;

import com.lambdaschool.bookstore.model.Author;
import com.lambdaschool.bookstore.model.Book;
import com.lambdaschool.bookstore.model.Section;
import com.lambdaschool.bookstore.repository.AuthorRepository;
import com.lambdaschool.bookstore.repository.BookRepository;
import com.lambdaschool.bookstore.repository.SectionRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Endpoints for author,users,and section", description = "Get and update endpoints")
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class GetController {

    @Autowired
    AuthorRepository authorRepos;

    @Autowired
    BookRepository bookRepos;

    @Autowired
    SectionRepository sectionRepos;

    @ApiOperation(value = "List all Authors", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resources you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach can not be found")
    })

    @GetMapping("/authors")
    public List<Author> listAllAuthors() {
        return authorRepos.findAll();
    }

    @ApiOperation(value = "List all Books", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resources you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach can not be found")
    })

    @GetMapping("/books")
    public List<Book> listAllBooks() {
        return bookRepos.findAll();
    }

    @ApiOperation(value = "List all Sections", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resources you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach can not be found")
    })
    @GetMapping("/sections")
    public List<Section> listAllSections() {
        return sectionRepos.findAll();
    }
}
