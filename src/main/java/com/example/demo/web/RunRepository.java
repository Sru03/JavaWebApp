package com.example.demo.web;

import java.util.Optional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import java.lang.*;


import jakarta.annotation.PostConstruct;
import org.springframework.util.Assert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;

@Repository
public class RunRepository {

       private static final Logger log = LoggerFactory.getLogger(RunRepository.class);
       private final JdbcClient jdbcClient;

       // jdbc api dependency injection 
       public RunRepository (JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient; // it is going to auto configure a jdbc client 
       }

       public List<Run> findAll(){
        return jdbcClient.sql("select * from run")
                .query(Run.class)
                .list();
       }

       public Optional <Run> findById(Integer id){
        return jdbcClient.sql("SELECT id, title, started_on, completed_on, miles, location FROM Run WHERE id = :id")
               .param("id", id)
               .query(Run.class)
               .optional();
       }

       public void create(Run run){
        var updated = jdbcClient.sql("INSERT INTO Run (id, title, started_on, complated_on, miles, location) VALUES(?,?,?,?,?,?)")
        .params(List.of(run.id(), run.title(), run.startedOn(), run.completedOn(),run.miles(), run.location().toString()))
        .update();
        
        Assert.state(updated == 1, "Failed to create run" + run.title());;

       }

       public void update(Run run, Integer id){
        var updated = jdbcClient.sql("update run set title = ?, started_on = ?, completed_on =?, miles =?, location = ? where id = ?")
                .params(List.of(run.title(),run.startedOn(), run.completedOn(), run.miles(), run.location().toString(), id))
                .update();

                Assert.state(updated == 1, "Failed to update run" + run.title());

       }

      































    // private List<Run> runs = new ArrayList();

    // List<Run> findAll() {
    //     return runs;
    // }

    // Optional <Run> findById(Integer id){
    //     return runs.stream()
    //            .filter(run -> run.id() == id)
    //            .findFirst();            
    // }

    // //to create run 
    //  void create(Run run){
    //     runs.add(run);
    //  }

    //  //updating the run by passing run and id 
    //  void update(Run run, Integer id){
    //     Optional<Run> existingRun = findById(id);
    //     if(existingRun.isPresent()){
    //         runs.set(runs.indexOf(existingRun.get()),run);
    //     }
    //  }

    //  //delete the run by passing id
    //  void delete(Integer id){
    //     runs.removeIf(run -> run.id().equals(id));

    //  }


    // @PostConstruct
    // private void init() {
    //     runs.add(new Run(1,
    //             "Monday Morning Run",
    //             LocalDateTime.now(),
    //             LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
    //             3,
    //             Location.INDOOR));

    //     runs.add(new Run(2,
    //             "Wednesday Evening Run",
    //             LocalDateTime.now(),
    //             LocalDateTime.now().plus(60, ChronoUnit.MINUTES),
    //             6,
    //             Location.INDOOR));

    // }

  

}
