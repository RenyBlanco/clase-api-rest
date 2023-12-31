package com.api.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.api.rest.dto.BookDTO;
import com.api.rest.modelos.Book;

@Mapper
public interface BookMapper {
	
	BookMapper INSTANCE = Mappers.getMapper(BookMapper.class); 
	
	Book toModel(BookDTO bookDTO);
	
	BookDTO toDTO(Book book);

	List<BookDTO> toDTO(List<Book> listado);
}
