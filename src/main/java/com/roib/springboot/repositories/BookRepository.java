package com.roib.springboot.repositories;

import com.roib.springboot.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
