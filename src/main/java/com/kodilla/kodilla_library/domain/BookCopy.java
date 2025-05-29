package com.kodilla.kodilla_library.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Title title;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        AVAILABLE, BORROWED, DAMAGED, LOST
    }
}
