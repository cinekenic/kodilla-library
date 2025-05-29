package com.kodilla.kodilla_library.service;

import com.kodilla.kodilla_library.domain.BookCopy;
import com.kodilla.kodilla_library.domain.Loan;
import com.kodilla.kodilla_library.domain.Reader;
import com.kodilla.kodilla_library.repository.BookCopyRepository;
import com.kodilla.kodilla_library.repository.LoanRepository;
import com.kodilla.kodilla_library.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookCopyRepository copyRepository;
    private final ReaderRepository readerRepository;

    public Optional<Loan> borrowBook(Long bookCopyId, Long readerId) {
        Optional<BookCopy> copyOpt = copyRepository.findById(bookCopyId);
        Optional<Reader> readerOpt = readerRepository.findById(readerId);

        if (copyOpt.isEmpty() || readerOpt.isEmpty()) return Optional.empty();

        BookCopy copy = copyOpt.get();
        if (copy.getStatus() != BookCopy.Status.AVAILABLE) return Optional.empty();

        copy.setStatus(BookCopy.Status.BORROWED);
        copyRepository.save(copy);

        Loan loan = new Loan();
        loan.setBookCopy(copy);
        loan.setReader(readerOpt.get());
        loan.setLoanDate(LocalDate.now());

        return Optional.of(loanRepository.save(loan));
    }

    public Optional<Loan> returnBook(Long loanId) {
        Optional<Loan> loanOpt = loanRepository.findById(loanId);
        if (loanOpt.isEmpty()) return Optional.empty();

        Loan loan = loanOpt.get();
        loan.setReturnDate(LocalDate.now());

        BookCopy copy = loan.getBookCopy();
        copy.setStatus(BookCopy.Status.AVAILABLE);
        copyRepository.save(copy);

        return Optional.of(loanRepository.save(loan));
    }
}
