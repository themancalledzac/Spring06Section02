package edens.zac.spring6webapp.services;

import edens.zac.spring6webapp.domain.Book;

// abstracting any Persistence logic from our controllers by placing it into a service
public interface BookService {

    Iterable<Book> findAll();

}
