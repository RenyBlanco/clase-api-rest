package com.api.rest.modelos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=60, nullable=false, unique=true)
	private String nombre;
	
	@Column(nullable=false)
	private String isbn;
	
	@Column(nullable=false)
	private int chapters;
	
	@Column(nullable=false)
	private int pages;
	
	@Column(nullable=false)
	private String editora;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name="author_id")
	private Author author;
}
