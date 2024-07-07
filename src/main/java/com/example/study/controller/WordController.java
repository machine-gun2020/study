package com.example.study.controller;

import com.example.study.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class WordController {

    @Autowired
    ExampleService exampleService;
    @GetMapping("/receiveWord")
    public String receiveWord(@RequestParam String word) {
        return "Received word: " + word;
    }
    @GetMapping("/execute")
        public String execute(@RequestParam String idioma, String word) {
        return exampleService.executeMethod(idioma, word);
    }
}