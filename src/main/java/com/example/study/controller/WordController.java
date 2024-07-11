package com.example.study.controller;

import com.example.study.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static com.example.study.service.ExampleService.executeMethod;

@RestController
public class WordController {

    


    @Autowired
    ExampleService exampleService;
    @GetMapping("/receiveWord")
    public String receiveWord(@RequestParam String word) {
        return "Received word: " + word;
    }
    @GetMapping("/execute")
    public ResponseEntity<String> execute(@RequestParam(required = false) String idioma,
                                          @RequestParam(required = false) String word) {
        if (idioma == null || idioma.isEmpty() || word == null || word.isEmpty()) {
            return new ResponseEntity<>("Both 'idioma' and 'word' parameters are required and must not be empty.", HttpStatus.BAD_REQUEST);
        }

        // Call your method to process the parameters
        String result = executeMethod(idioma, word);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
