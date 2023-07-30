package com.api.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.api.rest.dto.BookDTO;
import com.api.rest.modelos.Book;

@Mapper
public interface BookMapper {
	
	BookMapper INSTANCE = Mappers.getMapper(BookMapper.class); 
	
	Book toModel(BookDTO bookDTO);
	
	BookDTO toDTO(Book book);
}
