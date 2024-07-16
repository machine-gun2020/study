package com.example.study.service;

import com.example.study.dto.ColsDto;
import com.example.study.dto.SorteoDtoN1;
import com.example.study.model.Sorteo;
import com.example.study.repository.SorteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    public List<Sorteo> getAllSorteos() {

        return sorteoRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));

    }

    public List<SorteoDtoN1> getN1() {
        return sorteoRepository.findN1();
    }

    public Optional<ColsDto> getNumerous(LocalDate fecha) {
        List<ColsDto> results = sorteoRepository.findByFecha(fecha);
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

}

