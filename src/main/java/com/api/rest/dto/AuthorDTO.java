package com.api.rest.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDTO {

	private Long id;
	
	@NotBlank
	@Size(max=50)
	private String nombre;
	
	@NotBlank
	@Size(max=50)
	private String apellido;
	
	@NotBlank
	@Size(max=80)
	private String email;
}
