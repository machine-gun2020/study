package com.example.study.repository;

import com.example.study.dto.ColsDto;
import com.example.study.dto.SorteoDtoN1;
import com.example.study.model.Sorteo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SorteoRepository extends JpaRepository<Sorteo, Integer> {


    @Query("SELECT new com.example.study.dto.SorteoDtoN1(s.n1) FROM Sorteo s")
    List<SorteoDtoN1> findN1();

    @Query("SELECT new com.example.study.dto.ColsDto(s.fecha, s.n1, s.n2, s.n3, s.n4, s.n5, s.n6) " +
            "FROM Sorteo s WHERE s.fecha = :fecha")
    List<ColsDto> findByFecha(@Param("fecha") LocalDate fecha);

    @Query("SELECT new com.example.study.dto.ColsDto(s.fecha, s.n1, s.n2, s.n3, s.n4, s.n5, s.n6) " +
            "FROM Sorteo s WHERE s.fecha BETWEEN :startDate AND :endDate order by fecha desc")
    List<ColsDto> findRecordsBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}

