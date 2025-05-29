package com.kodilla.kodilla_library.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private BookCopy bookCopy;

    @ManyToOne
    private Reader reader;

    private LocalDate loanDate;
    private LocalDate returnDate;
}


