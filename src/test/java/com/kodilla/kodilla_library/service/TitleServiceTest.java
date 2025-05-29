package com.kodilla.kodilla_library.service;

import com.kodilla.kodilla_library.domain.BookCopy;
import com.kodilla.kodilla_library.domain.Title;
import com.kodilla.kodilla_library.repository.BookCopyRepository;
import com.kodilla.kodilla_library.repository.TitleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TitleServiceTest {

    @Autowired
    private TitleService titleService;

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private BookCopyRepository bookCopyRepository;

    @Test
    void shouldSaveTitle() {
        // given
        Title title = new Title(null, "Lalka", "B. Prus", 1890);

        // when
        Title savedTitle = titleService.saveTitle(title);

        // then
        assertNotNull(savedTitle.getId());
        assertEquals("Lalka", savedTitle.getTitle());
        Title fromDb = titleRepository.findById(savedTitle.getId()).orElseThrow();
        assertEquals("B. Prus", fromDb.getAuthor());
    }

    @Test
    void shouldReturnAvailableCopies() {
        // given
        Title title = titleRepository.save(new Title(null, "W pustyni i w puszczy", "H. Sienkiewicz", 1911));

        BookCopy copy1 = new BookCopy();
        copy1.setTitle(title);
        copy1.setStatus(BookCopy.Status.AVAILABLE);
        bookCopyRepository.save(copy1);

        BookCopy copy2 = new BookCopy();
        copy2.setTitle(title);
        copy2.setStatus(BookCopy.Status.AVAILABLE);
        bookCopyRepository.save(copy2);

        BookCopy copy3 = new BookCopy();
        copy3.setTitle(title);
        copy3.setStatus(BookCopy.Status.BORROWED);
        bookCopyRepository.save(copy3);

        // when
        long availableCount = titleService.getAvailableCopies(title.getId());

        // then
        assertEquals(2L, availableCount);
    }
}
