package com.api.rest.controladores;

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

import com.api.rest.dto.MessageResponseDTO;
import com.api.rest.modelos.Book;
import com.api.rest.service.BookService;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {
	
	@Autowired
	BookService bs;
	
	@PostMapping
	public MessageResponseDTO create(@RequestBody() Book book) {
		return bs.guardaBook(book);
	}
	
	@GetMapping
    public Iterable<Book> getClientes() {
    	return bs.listaTodos();
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
