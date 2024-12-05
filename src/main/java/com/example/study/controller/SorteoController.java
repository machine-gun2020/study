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
import java.util.stream.Collectors;

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
            return ResponseEntity
                    .badRequest()
                    .body("Fecha parameter is required and must not be empty.");
        }

        return colsService.getRecordByDate(fecha)
                .map(record -> ResponseEntity.ok().body((Object) record))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body((Object) "Record not found"));
    }

    @GetMapping("/getRecordsBetweenDates")
    public ResponseEntity<?> getRecordsBetweenDates(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        if (startDate == null || endDate == null) {
            return new ResponseEntity<>("Both 'startDate' and 'endDate' parameters are required and must not be empty.", HttpStatus.BAD_REQUEST);
        }

        List<ColsDto> records = colsService.getRecordsBetweenDates(startDate, endDate);

        if (records.isEmpty()) {
            return new ResponseEntity<>("No records found between the given dates.", HttpStatus.NOT_FOUND);
        }

        String result = CombinatorialCondensationExample.calculate(records);

        String formattedOutput = records.stream()
                .map(ColsDto::toString)
                .collect(Collectors.joining("\r\n"));

        return new ResponseEntity<>(formattedOutput, HttpStatus.OK);
    }

}

