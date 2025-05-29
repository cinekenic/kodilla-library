package com.kodilla.kodilla_library.domain;

import java.time.LocalDate;

public class LoanDto {
    Long id;
    Long readerId;
    String readerName;
    LocalDate loanDate;
    LocalDate returnDate;
}
