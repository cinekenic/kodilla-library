package com.kodilla.kodilla_library.service;

import com.kodilla.kodilla_library.domain.Reader;
import com.kodilla.kodilla_library.repository.ReaderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ReaderServiceTest {


    @Autowired
    private ReaderService readerService;

    @Autowired
    private ReaderRepository readerRepository;

    @Test
    void shouldSaveReader() {
        // given
        Reader reader = new Reader(null, "Jan", "Test", LocalDate.now());

        // when
        Reader saved = readerService.saveReader(reader);

        // then
        Assertions.assertNotNull(saved.getId());
    }

    @Test
    void shouldFindReaderById() {
        // given
        Reader reader = new Reader(null, "Anna", "Nowak", LocalDate.now());
        Reader saved = readerRepository.save(reader);

        // when
        Optional<Reader> result = readerService.getReader(saved.getId());

        // then
        assertTrue(result.isPresent());
        assertEquals("Anna", result.get().getFirstName());
    }
}
