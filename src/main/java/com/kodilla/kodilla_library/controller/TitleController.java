package com.kodilla.kodilla_library.controller;

import com.kodilla.kodilla_library.domain.BookCopy;
import com.kodilla.kodilla_library.domain.Title;
import com.kodilla.kodilla_library.repository.BookCopyRepository;
import com.kodilla.kodilla_library.repository.TitleRepository;
import com.kodilla.kodilla_library.service.TitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/titles")
@RequiredArgsConstructor
public class TitleController {

    private final TitleService titleService;

    @PostMapping
    public Title addTitle(@RequestBody Title title) {
        return titleService.saveTitle(title);
    }

    @GetMapping("/{id}/available-count")
    public long getAvailableCopies(@PathVariable Long id) {
        return titleService.getAvailableCopies(id);
    }
}
