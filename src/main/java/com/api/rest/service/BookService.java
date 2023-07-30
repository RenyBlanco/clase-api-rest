package com.api.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.rest.dto.MessageResponseDTO;
import com.api.rest.modelos.Author;
import com.api.rest.modelos.Book;
import com.api.rest.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	public MessageResponseDTO guardaBook(Book book) {
		Book e = bookRepository.findByIsbn(book.getIsbn());
		if(e!=null) {
			System.out.println("Libro ya existe");
			return null;
		}
		Book savedBook = bookRepository.save(book);
		return MessageResponseDTO.builder().message("Creado con éxito, ID "+savedBook.getId()).build();
	}
	
	public List<Book> listaTodos(){
		return bookRepository.findAll();
	}
	
	public Book getBook(Long id) {
		return bookRepository.findById(id).orElse(null);
	}
	
	public void updBook(Book emp) {
		Book e = bookRepository.findById(emp.getId()).orElse(null);
		if(e!=null) {
			bookRepository.save(emp);
		}else {
			System.out.println("Libro No registrado");
		}
		
	}

	public void borraBook(Long id) {
		bookRepository.deleteById(id);
	}
}
