package edens.zac.spring6webapp.services;

import edens.zac.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
