package com.example.demo.web;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;


public record Run(    //we can't change or set values but can only get the values
    Integer id,   
    @NotEmpty String title, 
    LocalDateTime startedOn, 
    LocalDateTime completedOn, 
    @Positive Integer miles,
    Location location
   ) {


        //To prevent users from entering wrong details as input
        //this is to check if completedOn is after before startedOn which is not valid 
    
        public Run {
            if(!completedOn.isAfter(startedOn)){
                throw new IllegalArgumentException("Completed On must be after Started On");
            }

        }



}


