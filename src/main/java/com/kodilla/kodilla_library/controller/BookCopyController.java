package com.kodilla.kodilla_library.controller;

import com.kodilla.kodilla_library.domain.BookCopy;
import com.kodilla.kodilla_library.domain.Title;
import com.kodilla.kodilla_library.repository.BookCopyRepository;
import com.kodilla.kodilla_library.repository.TitleRepository;
import com.kodilla.kodilla_library.service.BookCopyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/copies")
@RequiredArgsConstructor
public class BookCopyController {

    private final BookCopyService bookCopyService;

    @PostMapping
    public ResponseEntity<BookCopy> addCopy(@RequestParam Long titleId) {
        return bookCopyService.addCopy(titleId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<BookCopy> updateStatus(
            @PathVariable Long id,
            @RequestParam BookCopy.Status status) {

        return bookCopyService.changeStatus(id, status)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
