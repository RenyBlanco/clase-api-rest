package com.api.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.rest.modelos.Author;
import com.api.rest.repository.EmpleadoRepository;

@Service
public class EmpleadoService {
	
	@Autowired
	EmpleadoRepository empRepository;
	
	public ResponseEntity<String> grabaEmpleado(Author emp) {
		Author e = empRepository.findByEmail(emp.getEmail());
		if(e==null) {
			empRepository.save(emp);
		}else {
			return ResponseEntity.ok("Registro Ya Existe");
		}
		return ResponseEntity.ok("Grabado");
	}
	
	public List<Author> listaEmpleados(){
		return empRepository.findAll();
	}
	
	public Author getEmpleado(Long id) {
		return empRepository.findById(id).orElse(null);
	}
	
	public void updEmpleado(Author emp) {
		Author e = empRepository.findById(emp.getId()).orElse(null);
		if(e!=null) {
			empRepository.save(emp);
		}else {
			System.out.println("Usuario No registrado");
		}
		
	}

	public void borraEmpleado(Long id) {
		empRepository.deleteById(id);
	}
}
