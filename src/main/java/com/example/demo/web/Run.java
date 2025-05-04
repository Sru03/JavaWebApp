package com.example.demo.web;
import com.example.demo.web.Location;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.springframework.stereotype.Repository;

public record Run(    //we can't change or set values but can only get the values
    Integer id,   
    String title, 
    LocalDateTime startedOn, 
    LocalDateTime completedOn, 
    Integer miles,
    Location location
   ) {

        public Run(Integer id, String title, LocalDateTime startedOn, LocalDateTime completedOn, Integer miles, Location location ) {
            this.id = id;
            this.title = title;
            this.startedOn = startedOn;
            this.completedOn = completedOn;
            this.miles = miles;
            this.location = location;
           
        }

}


