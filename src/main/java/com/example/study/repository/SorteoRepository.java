package com.example.study.repository;

import com.example.study.model.Sorteo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SorteoRepository extends JpaRepository<Sorteo, Integer> {

}

