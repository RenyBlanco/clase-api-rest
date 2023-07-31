package com.api.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.dto.BookDTO;
import com.api.rest.dto.MessageResponseDTO;
import com.api.rest.exception.BookNotFoundException;
import com.api.rest.mapper.BookMapper;
import com.api.rest.modelos.Book;
import com.api.rest.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	private final BookMapper bookMapper = BookMapper.INSTANCE; 
	
	/* private static final BookMapper bookMapper = Mappers.getMapper(BookMapper.class); */
	
	public MessageResponseDTO guardaBook(BookDTO bookDTO) {
		
		Book bookToSave = bookMapper.toModel(bookDTO);
		
		// Revisa si existe el libro
		Book e = bookRepository.findByIsbn(bookDTO.getIsbn()); 
		if(e!=null) {
		  System.out.println("Libro ya existe"); 
		  return null; 
		}
		
		Book savedBook = bookRepository.save(bookToSave);
		return MessageResponseDTO.builder().message("Creado con éxito, ID "+savedBook.getId()).build();
	}
	
	public List<BookDTO> listaTodos(){
		List<Book> listado = bookRepository.findAll();
		return bookMapper.toDTO(listado);
	}
	
	public BookDTO getBook(Long id) throws BookNotFoundException {
		Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
		return bookMapper.toDTO(book);
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
