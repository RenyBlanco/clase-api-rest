package com.api.rest.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.api.rest.modelos.Author;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {
	

	private Long id;

	@NotBlank
	@Size(max=100)
	private String nombre;
	
	@NotBlank
	@Size(max=100)
	private String isbn;
	
	@NotNull
	private int chapters;
	
	@NotNull
	private int pages;
	
	@NotBlank
	@Size(max=100)
	private String editora;
	
	@Valid
	@NotNull
	private AuthorDTO authorDTO;
}
