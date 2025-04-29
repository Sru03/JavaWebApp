package com.example.demo.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("/api/runs")
    List<Run> findAll() {
        return runRepository.findAll();
    }

    // @GetMapping("api/runs/{id}")
    //     Run findById(@PathVariable Integer id){
    //         return runRepository.findById(1);
    // }
    
    

}
