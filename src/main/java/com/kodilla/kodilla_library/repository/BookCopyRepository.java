package com.kodilla.kodilla_library.repository;

import com.kodilla.kodilla_library.domain.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCopyRepository extends JpaRepository<BookCopy, Long> {
    long countByTitleIdAndStatus(Long titleId, BookCopy.Status status);
}