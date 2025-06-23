package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author john = new Author();
        john.setFirstName("John");
        john.setLastName("Smith");
        john = authorRepository.save(john);

        Book lotf = new Book();
        lotf.setTitle("Lord of the Flies");
        lotf.setIsbn("123456");
        lotf.setAuthors(Set.of(john));
        lotf = bookRepository.save(lotf);

        Author jane = new Author();
        jane.setFirstName("Jane");
        jane.setLastName("Doe");
        jane = authorRepository.save(jane);

        Book whatIf = new Book();
        whatIf.setTitle("What If");
        whatIf.setIsbn("123457");
        whatIf.setAuthors(Set.of(jane));
        whatIf = bookRepository.save(whatIf);

        System.out.println("In bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
    }
}
