package com.api.rest.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.dto.BookDTO;
import com.api.rest.dto.MessageResponseDTO;
import com.api.rest.modelos.Book;
import com.api.rest.service.BookService;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
	
	@Autowired
	BookService bs;
	
	@PostMapping
	public MessageResponseDTO create(@RequestBody() @Valid BookDTO bookDTO) {
		return bs.guardaBook(bookDTO);
	}
	
	@GetMapping
    public Iterable<BookDTO> getClientes() {
    	return bs.listaTodos();
    }
	
	@GetMapping("/{id}")
	public BookDTO getBook(@PathVariable("id") Long id) {
		return bs.getBook(id);
	}
	
	@DeleteMapping(path="{Id}")
	public ResponseEntity<String> borraCliente(@PathVariable("Id") Long id) {
		bs.borraBook(id);
		return ResponseEntity.ok("Eliminado con exito");
	}
	
	@PutMapping
	public ResponseEntity<String> actualizaCliente(@RequestBody() Book c) {
		bs.updBook(c);
		return ResponseEntity.ok("Actualizado con exito");
	}


}
