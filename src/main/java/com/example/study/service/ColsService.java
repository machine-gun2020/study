package com.example.study.service;

import com.example.study.dto.ColsDto;
import com.example.study.repository.SorteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ColsService {
    @Autowired
    private SorteoRepository sorteoRepository;

    public Optional<ColsDto> getRecordByDate(LocalDate fecha) {
        List<ColsDto> results = sorteoRepository.findByFecha(fecha);
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    public List<ColsDto> getRecordsBetweenDates(LocalDate startDate, LocalDate endDate) {
        return sorteoRepository.findRecordsBetweenDates(startDate, endDate);
    }

}
