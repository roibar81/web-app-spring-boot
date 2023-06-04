package com.roib.springboot.repositories;

import com.roib.springboot.domain.Book;
import com.roib.springboot.domain.Publisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
