package com.api.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.rest.modelos.Author;

public interface EmpleadoRepository extends JpaRepository<Author, Long>{
	Author findByEmail(String email);
}
