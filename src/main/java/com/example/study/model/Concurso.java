package com.example.study.model;

import java.time.LocalDate;
import java.util.List;

public class Concurso {
    private int id;
    private List<Integer> resultados;
    private LocalDate fecha;
    private long bolsa;

    public Concurso(int id, List<Integer> resultados, LocalDate fecha, long bolsa) {
        this.id = id;
        this.resultados = resultados;
        this.fecha = fecha;
        this.bolsa = bolsa;
    }

    // Getters y toString()
    public int getId() {
        return id;
    }

    public List<Integer> getResultados() {
        return resultados;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public long getBolsa() {
        return bolsa;
    }

    @Override
    public String toString() {
        return "Concurso{" +
                "id=" + id +
                ", resultados=" + resultados +
                ", fecha=" + fecha +
                ", bolsa=" + bolsa +
                '}';
    }
}