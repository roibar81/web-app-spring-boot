package com.roib.springboot.bootstrap;

import com.roib.springboot.domain.Author;
import com.roib.springboot.domain.Book;
import com.roib.springboot.domain.Publisher;
import com.roib.springboot.repositories.AuthorRepository;
import com.roib.springboot.repositories.BookRepository;
import com.roib.springboot.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
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
        publisher.setCity("St Publishing");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());

        Author john = new Author("John", "Maloney");
        Book firstBook = new Book("Learning Spring", "123123");
        john.getBooks().add(firstBook);
        firstBook.getAuthors().add(john);

        firstBook.setPublisher(publisher);
        publisher.getBooks().add(firstBook);

        authorRepository.save(john);
        bookRepository.save(firstBook);
        publisherRepository.save(publisher);

        Author guy = new Author("Guy", "Bold");
        Book guyBook = new Book("Learning DevOps", "123456");
        guy.getBooks().add(firstBook);
        guyBook.getAuthors().add(john);

        guyBook.setPublisher(publisher);
        publisher.getBooks().add(guyBook);

        authorRepository.save(guy);
        bookRepository.save(guyBook);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
    }
}
