package com.example.study.service;

import com.example.study.dto.AllCols;
import com.example.study.dto.ColsDto;
import com.example.study.dto.SorteoDtoN1;
import com.example.study.repository.SorteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SorteoService {

    private final SorteoRepository sorteoRepository;

    @Autowired
    public SorteoService(SorteoRepository sorteoRepository) {

        this.sorteoRepository = sorteoRepository;

    }

    public List<AllCols> getAllSorteos() {
        List<AllCols> allsorteos = sorteoRepository.findAll();
        return allsorteos;

    }

    public List<SorteoDtoN1> getN1() {
        return sorteoRepository.findN1();
    }

    public Optional<ColsDto> getNumerous(LocalDate fecha) {
        List<ColsDto> results = sorteoRepository.findByFecha(fecha);
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

}

