package com.example.study.controller;

import com.example.study.CombinatorialCondensationExample;
import com.example.study.dto.ColsDto;
import com.example.study.dto.SorteoDtoN1;
import com.example.study.model.Sorteo;
import com.example.study.service.ColsService;
import com.example.study.service.SorteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sorteos")
public class SorteoController {

    private final SorteoService sorteoService;

    @Autowired
    private ColsService colsService;


    @Autowired
    public SorteoController(SorteoService sorteoService) {
        this.sorteoService = sorteoService;
    }

    @GetMapping
    public List<Sorteo> getAllSorteos() {

        return sorteoService.getAllSorteos();

    }
    @GetMapping("/n1")
    public List<SorteoDtoN1> getN1() {
        return sorteoService.getN1();
    }

    @GetMapping("/predict")
    public int[] predictNextResult() {
        List<Sorteo> sorteos = sorteoService.getAllSorteos();
        return CombinatorialCondensationExample.predictNextResult(sorteos);
    }


    @GetMapping("/getRecordByDate")
    public ResponseEntity<Object> getRecordByDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {

        if (fecha == null) {
            return new ResponseEntity<>("Fecha parameter is required and must not be empty.", HttpStatus.BAD_REQUEST);
        }

        Optional<ColsDto> record = colsService.getRecordByDate(fecha);
        if (record.isPresent()) {
            return new ResponseEntity<>(record.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Record not found", HttpStatus.NOT_FOUND);
        }
    }

}

