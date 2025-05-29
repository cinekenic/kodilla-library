package com.kodilla.kodilla_library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class  TitleDto {
    private Long id;
    private String title;
    private String author;
    private int publicationYear;
}
