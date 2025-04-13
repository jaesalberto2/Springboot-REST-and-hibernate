package com.alberto.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DemoRestController {

    @RequestMapping("/hello")
    public String sayhello() {
        return "Hello, World!";
    }

    @RequestMapping("/goodbye")
    public String sayGoodbye() {
        return "Goodbye, World!";
    }

}
