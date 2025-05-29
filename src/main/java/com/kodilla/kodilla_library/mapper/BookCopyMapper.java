package com.kodilla.kodilla_library.mapper;

import com.kodilla.kodilla_library.domain.BookCopy;
import com.kodilla.kodilla_library.domain.BookCopyDto;
import com.kodilla.kodilla_library.domain.Title;
import com.kodilla.kodilla_library.domain.TitleDto;

public class BookCopyMapper {

    public static TitleDto toDto(Title title) {
        return new TitleDto(
                title.getId(),
                title.getTitle(),
                title.getAuthor(),
                title.getPublicationYear()
        );
    }

    public static BookCopy toEntity(BookCopyDto dto, Title title) {
        BookCopy copy = new BookCopy();
        copy.setId(dto.getId());
        copy.setTitle(title);
        copy.setStatus(dto.getStatus());
        return copy;
    }
}
