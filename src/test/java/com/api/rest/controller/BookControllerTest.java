package com.api.rest.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.api.rest.controladores.BookController;
import com.api.rest.dto.BookDTO;
import com.api.rest.dto.MessageResponseDTO;
import com.api.rest.service.BookService;
import com.api.rest.utils.BookUtils;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private BookService bs;
	
	@InjectMocks
	private BookController bc;
	
	public static final String BOOK_URL_API = "/api/v1/book";
	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(bc)
				.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
				.setViewResolvers((viewName, locale) -> new MappingJackson2JsonView())
				.build();
	}
	
	@Test
	void testPostYCreaBook() throws Exception {
		BookDTO bookDTO = BookUtils.createFakeBookDTO();
		MessageResponseDTO expectedMessageResponse = MessageResponseDTO.builder()
				.message("Libro desde Test creado "+bookDTO.getId())
				.build();
		
		when(bs.guardaBook(bookDTO)).thenReturn(expectedMessageResponse);
		mockMvc.perform(post(BOOK_URL_API)
				.contentType(MediaType.APPLICATION_JSON)
				.content(BookUtils.asJsonString(bookDTO)))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.message", Is.is(expectedMessageResponse.getMessage())));
	}
	
	@Test
	void testPostInvalidIsbn() throws Exception {
		
		BookDTO bookDTO = BookUtils.createFakeBookDTO();
		
		bookDTO.setIsbn("Isbn Invalido");
		
		mockMvc.perform(post(BOOK_URL_API)
				.contentType(MediaType.APPLICATION_JSON)
				.content(BookUtils.asJsonString(bookDTO)))
				.andExpect(status().isBadRequest());
	}

}
