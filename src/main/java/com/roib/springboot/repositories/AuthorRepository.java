package com.roib.springboot.repositories;

import com.roib.springboot.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
