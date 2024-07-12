package com.example.study.repository;

import com.example.study.dto.SorteoDtoN1;
import com.example.study.model.Sorteo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SorteoRepository extends JpaRepository<Sorteo, Integer> {

    @Query("SELECT new com.example.study.dto.SorteoDtoN1(s.n1) FROM Sorteo s")
    List<SorteoDtoN1> findN1();

}

