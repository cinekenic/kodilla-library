package com.kodilla.kodilla_library.controller;

import com.kodilla.kodilla_library.domain.BookCopy;
import com.kodilla.kodilla_library.domain.Loan;
import com.kodilla.kodilla_library.domain.Reader;
import com.kodilla.kodilla_library.repository.BookCopyRepository;
import com.kodilla.kodilla_library.repository.LoanRepository;
import com.kodilla.kodilla_library.repository.ReaderRepository;
import com.kodilla.kodilla_library.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping
    public ResponseEntity<Loan> borrowBook(
            @RequestParam Long bookCopyId,
            @RequestParam Long readerId) {

        return loanService.borrowBook(bookCopyId, readerId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{loanId}/return")
    public ResponseEntity<Loan> returnBook(@PathVariable Long loanId) {
        return loanService.returnBook(loanId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
