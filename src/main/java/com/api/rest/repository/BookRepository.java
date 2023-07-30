package com.api.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rest.modelos.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

	Book findByIsbn(String isbn);
	
}
