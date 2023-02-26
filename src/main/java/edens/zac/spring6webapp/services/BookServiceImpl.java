package edens.zac.spring6webapp.services;

import edens.zac.spring6webapp.domain.Book;
import edens.zac.spring6webapp.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    // create an instance of the bookRepository
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // basic super simple implementation of a service
    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
