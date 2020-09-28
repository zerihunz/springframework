package nguru.springframework.spring5webapp2.bootstrap;

import nguru.springframework.spring5webapp2.domain.Author;
import nguru.springframework.spring5webapp2.domain.Book;
import nguru.springframework.spring5webapp2.domain.Publisher;
import nguru.springframework.spring5webapp2.repositories.AuthorRepository;
import nguru.springframework.spring5webapp2.repositories.BookRepository;
import nguru.springframework.spring5webapp2.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component     //Adding this annotation tells spring to treat this as a spring managed component.
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author dan = new Author("Dan", "Brown");
        Book df = new Book("Digital Fortress", "123456789");
        dan.getBooks().add(df);
        df.getAuthors().add(dan);

        df.setPublisher(publisher);
        publisher.getBooks().add(df);

        authorRepository.save(dan);
        bookRepository.save(df);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "8789w78er");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
        System.out.println(df);
        System.out.println(dan);
    }
}
