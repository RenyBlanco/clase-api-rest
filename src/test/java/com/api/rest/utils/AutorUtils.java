package com.api.rest.utils;

import com.api.rest.dto.AuthorDTO;
import com.api.rest.modelos.Author;
import com.github.javafaker.Faker;

public class AutorUtils {

	private static final Faker faker = Faker.instance();

    public static AuthorDTO createFakeAuthorDTO() {
        return AuthorDTO.builder()
                .id(faker.number().randomNumber())
                .nombre(faker.book().author())
                .apellido(faker.book().author())
                .email(faker.book().author())
                .build();
    }

    public static Author createFakeAuthor() {
        return Author.builder()
        		.id(faker.number().randomNumber())
                .nombre(faker.book().author())
                .apellido(faker.book().author())
                .email(faker.book().author())
                .build();
    }

    public static Author createFakeAuthorFrom(AuthorDTO authorDTO) {
        return Author.builder()
                .id(authorDTO.getId())
                .nombre(authorDTO.getNombre())
                .apellido(authorDTO.getApellido())
                .email(authorDTO.getEmail())
                .build();
    }
}
