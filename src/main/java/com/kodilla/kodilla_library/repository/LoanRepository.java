package com.kodilla.kodilla_library.repository;

import com.kodilla.kodilla_library.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {}