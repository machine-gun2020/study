package com.example.study.service;

import com.example.study.model.Sorteo;
import com.example.study.repository.SorteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SorteoService {

    private final SorteoRepository sorteoRepository;

    @Autowired
    public SorteoService(SorteoRepository sorteoRepository) {
        this.sorteoRepository = sorteoRepository;
    }

    public List<Sorteo> getAllSorteos() {
        return sorteoRepository.findAll();
    }
}

