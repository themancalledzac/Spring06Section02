package edens.zac.spring6webapp.bootstrap;

import edens.zac.spring6webapp.domain.Author;
import edens.zac.spring6webapp.domain.Book;
import edens.zac.spring6webapp.domain.Publisher;
import edens.zac.spring6webapp.repositories.AuthorRepository;
import edens.zac.spring6webapp.repositories.BookRepository;
import edens.zac.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Will get picked up and run every time that Spring Boot starts up.
 * <br>
 * If it finds a class in the context that implements CommandLineRunner, it's going to execute that.
 */
@Component
public class BootstrapData implements CommandLineRunner {

    /**
     * It's best practice to declare components from the Spring Context as FINAL so they can't be changed.
     */
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;

    }

    @Override
    public void run(String... args) throws Exception {

        Author martin = new Author();
        martin.setFirstName("Martin");
        martin.setLastName("Short");

        Book forWhomTheBe = new Book();
        forWhomTheBe.setTitle("For Whom the Bell To");
        forWhomTheBe.setIsbn("123456");

        Publisher headGuy = new Publisher();
        headGuy.setPublisherName("Head Guy");
        headGuy.setCity("Seattle");

        Author martinSaved = authorRepository.save(martin);
        Book forWhomTheBeSaved = bookRepository.save(forWhomTheBe);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Dev without EJB");
        noEJB.setIsbn("5463728");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        martinSaved.getBooks().add(forWhomTheBeSaved);
        rodSaved.getBooks().add(noEJBSaved);
        forWhomTheBeSaved.getAuthors().add(martinSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("My Publisher");
        publisher.setAddress("123 Main");
        Publisher savePublisher = publisherRepository.save(publisher);

        forWhomTheBeSaved.setPublisher(savePublisher);
        noEJBSaved.setPublisher(savePublisher);

        authorRepository.save(rodSaved);
        authorRepository.save(martinSaved);
        bookRepository.save(forWhomTheBeSaved);
        bookRepository.save(noEJBSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());


        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
