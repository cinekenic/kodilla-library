package com.kodilla.kodilla_library.service;

import com.kodilla.kodilla_library.domain.Reader;
import com.kodilla.kodilla_library.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;

    public Reader saveReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public Optional<Reader> getReader(Long id) {
        return readerRepository.findById(id);
    }

    public void deleteReader(Long id) {
        readerRepository.deleteById(id);
    }
}
