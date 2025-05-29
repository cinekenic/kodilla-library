package com.kodilla.kodilla_library.mapper;

import com.kodilla.kodilla_library.domain.Title;
import com.kodilla.kodilla_library.domain.TitleDto;
import org.springframework.stereotype.Service;

@Service
public class TitleMapper {

    public static TitleDto toDto(Title title) {
        return new TitleDto(
                title.getId(),
                title.getTitle(),
                title.getAuthor(),
                title.getPublicationYear()
        );
    }

    public static Title toEntity(TitleDto dto) {
        Title title = new Title();
        title.setId(dto.getId());
        title.setTitle(dto.getTitle());
        title.setAuthor(dto.getAuthor());
        title.setPublicationYear(dto.getPublicationYear());
        return title;
    }
}
