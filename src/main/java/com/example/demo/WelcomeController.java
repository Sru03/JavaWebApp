package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class WelcomeController {
  
   @GetMapping("/")
   public String home(){
    return "Welcome to home page";
   }


    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Spring Boot world";
    }
    
}
