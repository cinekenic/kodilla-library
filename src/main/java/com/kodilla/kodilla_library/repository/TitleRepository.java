package com.kodilla.kodilla_library.repository;
import com.kodilla.kodilla_library.domain.Title;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TitleRepository extends JpaRepository<Title, Long> {}