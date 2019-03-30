package com.realpacific.springboottodos.controllers;

import com.realpacific.springboottodos.entity.Response;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorldController {

    @GetMapping(path = "/{value}")
    Response getResponse(@PathVariable("value") String value) throws Exception {
        return new Response("Hello, " + value);
//        throw new Exception("Some error occurred");
    }
}
