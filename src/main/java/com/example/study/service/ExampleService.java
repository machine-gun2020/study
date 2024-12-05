package com.example.study.service;

import com.example.study.StudyApplication;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    public static String executeMethod(String idioma, String word) {

        return "Received word: " + idioma + " | " + word;

    }
}
