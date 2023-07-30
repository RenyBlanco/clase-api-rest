package com.api.rest.utils;


import com.api.rest.dto.BookDTO;
import com.api.rest.modelos.Book;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.javafaker.Faker;

import static com.api.rest.utils.AutorUtils.createFakeAuthor;
import static com.api.rest.utils.AutorUtils.createFakeAuthorFrom;
import static com.api.rest.utils.AutorUtils.createFakeAuthorDTO;

public class BookUtils {

	private static final Faker faker = Faker.instance();

    public static BookDTO createFakeBookDTO() {
        return BookDTO.builder()
                .id(faker.number().randomNumber())
                .nombre(faker.book().title())
                .pages(faker.number().numberBetween(0, 200))
                .chapters(faker.number().numberBetween(1, 20))
                .isbn("0-596-52068-9")
                .editora(faker.book().publisher())
                .authorDTO(createFakeAuthorDTO())
                .build();
    }

    public static Book createFakeBook() {
        return Book.builder()
                .id(faker.number().randomNumber())
                .nombre(faker.book().title())
                .pages(faker.number().numberBetween(0, 200))
                .chapters(faker.number().numberBetween(1, 20))
                .isbn("0-596-52068-9")
                .editora(faker.book().publisher())
                .author(createFakeAuthor())
                .build();
    }

    public static Book createFakeBookFrom(BookDTO bookDTO) {
        return Book.builder()
                .id(bookDTO.getId())
                .nombre(bookDTO.getNombre())
                .pages(bookDTO.getPages())
                .chapters(bookDTO.getChapters())
                .isbn(bookDTO.getIsbn())
                .editora(bookDTO.getEditora())
                .author(createFakeAuthorFrom(bookDTO.getAuthorDTO()))
                .build();
    }

    public static String asJsonString(BookDTO bookDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.registerModules(new JavaTimeModule());

            return objectMapper.writeValueAsString(bookDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
