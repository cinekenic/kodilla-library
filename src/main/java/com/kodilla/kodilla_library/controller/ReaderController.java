package com.kodilla.kodilla_library.controller;

import com.kodilla.kodilla_library.domain.Reader;
import com.kodilla.kodilla_library.repository.ReaderRepository;
import com.kodilla.kodilla_library.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/readers")
@RequiredArgsConstructor
public class ReaderController {

    private final ReaderService readerService;

    @PostMapping
    public Reader addReader(@RequestBody Reader reader) {
        reader.setAccountCreated(LocalDate.now());
        return readerService.saveReader(reader);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reader> getReader(@PathVariable Long id) {
        return readerService.getReader(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
