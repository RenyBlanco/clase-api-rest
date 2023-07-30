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

import com.api.rest.modelos.Author;
import com.api.rest.service.EmpleadoService;

@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadoController {
	
	@Autowired
	EmpleadoService es;
	
	@GetMapping
    public Iterable<Author> getClientes() {
    	return es.listaEmpleados();
    }
	
	@PostMapping
	public ResponseEntity<String> createCliente(@RequestBody() Author c) {
		es.grabaEmpleado(c);
		return ResponseEntity.ok("Creado con exito");
	}
	
	@DeleteMapping(path="{Id}")
	public ResponseEntity<String> borraCliente(@PathVariable("Id") Long id) {
		es.borraEmpleado(id);
		return ResponseEntity.ok("Eliminado con exito");
	}
	
	@PutMapping
	public ResponseEntity<String> actualizaCliente(@RequestBody() Author c) {
		es.updEmpleado(c);
		return ResponseEntity.ok("Actualizado con exito");
	}


}
