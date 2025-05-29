package com.kodilla.kodilla_library.service;

import com.kodilla.kodilla_library.domain.Title;
import com.kodilla.kodilla_library.repository.BookCopyRepository;
import com.kodilla.kodilla_library.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TitleService {

    private final TitleRepository titleRepository;
    private final BookCopyRepository bookCopyRepository;

    public Title saveTitle(Title title) {
        return titleRepository.save(title);
    }

    public long getAvailableCopies(Long titleId) {
        return bookCopyRepository.countByTitleIdAndStatus(titleId, com.kodilla.kodilla_library.domain.BookCopy.Status.AVAILABLE);
    }
}


