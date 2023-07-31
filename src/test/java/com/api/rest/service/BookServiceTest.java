package com.api.rest.service;

import static org.mockito.Mockito.when;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.api.rest.dto.BookDTO;
import com.api.rest.exception.BookNotFoundException;
import com.api.rest.modelos.Book;
import com.api.rest.repository.BookRepository;
import static com.api.rest.utils.BookUtils.createFakeBook;;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	@Mock
	private BookRepository bookRepo;
	
	@InjectMocks
	private BookService bs;
	
	@Test
	void whenGivenExistingId() throws BookNotFoundException {
		Book libroEsperado = createFakeBook();
		
		when(bookRepo.findById(libroEsperado.getId()))
		.thenReturn(Optional.of(libroEsperado));
		
		BookDTO bookDTO = bs.getBook(libroEsperado.getId());
		
		assertEquals(libroEsperado.getNombre(), bookDTO.getNombre());
		assertEquals(libroEsperado.getIsbn(), bookDTO.getIsbn());
		assertEquals(libroEsperado.getEditora(), bookDTO.getEditora());
	}
	
}
