package edu.newhaven.smoka2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(path="greeting")
    public String printGreeting()
    {
        return "Hello World!!";
    }
}
