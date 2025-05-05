package com.example.demo.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class RunRepositoryTest {
  

    RunRepository repository;
    @BeforeEach
    void setUp(){
        repository = new RunRepository();
        repository.create(new Run (1,
        "Monday Morning run",
        LocalDateTime.now(), 
        LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
        3,
        Location.INDOOR  ));

        repository.create(new Run (2,
        "Wednesday Evening run",
        LocalDateTime.now(), 
        LocalDateTime.now().plus(60, ChronoUnit.MINUTES),
        6,
        Location.INDOOR  ));
    }

    @Test
    void shouldFindAllRuns(){
        List<Run> runs = repository.findAll();
        assertEquals(2, runs.size(), "Should returned 2 runs");

    }
}
