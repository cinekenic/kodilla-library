package com.kodilla.kodilla_library.mapper;

import com.kodilla.kodilla_library.domain.Reader;
import com.kodilla.kodilla_library.domain.ReaderDto;

public class ReaderMapper {

    public static ReaderDto toDto(Reader reader) {
        return new ReaderDto(
                reader.getId(),
                reader.getFirstName(),
                reader.getLastName(),
                reader.getAccountCreated()
        );
    }

    public static Reader toEntity(ReaderDto dto) {
        Reader reader = new Reader();
        reader.setId(dto.getId());
        reader.setFirstName(dto.getFirstName());
        reader.setLastName(dto.getLastName());
        reader.setAccountCreated(dto.getAccountCreated());
        return reader;
    }
}
