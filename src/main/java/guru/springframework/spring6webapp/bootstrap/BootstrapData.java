package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {

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
        Publisher spring = new Publisher();
        spring.setPublisherName("Spring Boot");
        spring.setAddress("9966 Apple road");
        spring.setCity("Los Angeles");
        spring.setState("CA");
        spring.setZip("963.852");
        spring = publisherRepository.save(spring);


        Author john = new Author();
        john.setFirstName("John");
        john.setLastName("Smith");
        john = authorRepository.save(john);

        Book lotf = new Book();
        lotf.setTitle("Lord of the Flies");
        lotf.setIsbn("123456");
        lotf.setAuthors(Set.of(john));
        lotf.setPublisher(spring);
        lotf = bookRepository.save(lotf);

        Author jane = new Author();
        jane.setFirstName("Jane");
        jane.setLastName("Doe");
        jane = authorRepository.save(jane);

        Book whatIf = new Book();
        whatIf.setTitle("What If");
        whatIf.setIsbn("123457");
        whatIf.setAuthors(Set.of(jane));
        whatIf.setPublisher(spring);
        whatIf = bookRepository.save(whatIf);

        System.out.println("In bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
