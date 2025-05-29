package com.kodilla.kodilla_library.service;

import com.kodilla.kodilla_library.domain.BookCopy;
import com.kodilla.kodilla_library.repository.BookCopyRepository;
import com.kodilla.kodilla_library.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookCopyService {

    private final BookCopyRepository copyRepository;
    private final TitleRepository titleRepository;

    public Optional<BookCopy> addCopy(Long titleId) {
        return titleRepository.findById(titleId)
                .map(title -> {
                    BookCopy copy = new BookCopy();
                    copy.setTitle(title);
                    copy.setStatus(BookCopy.Status.AVAILABLE);
                    return copyRepository.save(copy);
                });
    }

    public Optional<BookCopy> changeStatus(Long copyId, BookCopy.Status status) {
        return copyRepository.findById(copyId)
                .map(copy -> {
                    copy.setStatus(status);
                    return copyRepository.save(copy);
                });
    }
}
