package com.example.study.controller;

import com.example.study.model.Sorteo;
import com.example.study.service.SorteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sorteos")
public class SorteoController {

    private final SorteoService sorteoService;

    @Autowired
    public SorteoController(SorteoService sorteoService) {
        this.sorteoService = sorteoService;
    }

    @GetMapping
    public List<Sorteo> getAllSorteos() {
        return sorteoService.getAllSorteos();
    }
}

