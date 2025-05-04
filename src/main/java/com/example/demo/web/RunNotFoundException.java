package com.example.demo.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)//404 not found 
public class RunNotFoundException extends RuntimeException {

    public RunNotFoundException(){
        super("Run Not Found");
    
}

}