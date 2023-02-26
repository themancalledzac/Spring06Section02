package edens.zac.spring6webapp.controllers;

import edens.zac.spring6webapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * On Runtime, when Spring sees that we require a BooKService, it'll create a Spring Bean that implements the BookServiceImpl, as an implementation of BookService.
 */
@Controller
public class BookController {

    // By creating a bookService not the implementation of the service, later on down the road we can run multiple implementations, using Spring's Dependency Injection.
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books", bookService.findAll());

        return "books";
    }
}
