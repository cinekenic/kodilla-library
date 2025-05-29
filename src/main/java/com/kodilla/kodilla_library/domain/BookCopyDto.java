package com.kodilla.kodilla_library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookCopyDto {
   private Long id;
    Long titleId;
    String title;
    String author;
    int publicationYear;
    BookCopy.Status status;
}
