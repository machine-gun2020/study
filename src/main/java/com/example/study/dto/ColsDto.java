package com.example.study.dto;

import java.time.LocalDate;

public class ColsDto {
    private LocalDate fecha;
    private int n1;
    private int n2;
    private int n3;
    private int n4;
    private int n5;
    private int n6;






    @Override
    public String toString() {
        return  "Fecha=" + fecha +
                ", n1=" + String.valueOf(n1) +
                ", n2=" + String.valueOf(n2) +
                ", n3=" + String.valueOf(n3) +
                ", n4=" + String.valueOf(n4) +
                ", n5=" + String.valueOf(n5) +
                ", n6=" + String.valueOf(n6) ;
    }

    public ColsDto(LocalDate fecha, int n1, int n2, int n3, int n4, int n5, int n6) {
        this.fecha = fecha;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
        this.n5 = n5;
        this.n6 = n6;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public int getN3() {
        return n3;
    }

    public void setN3(int n3) {
        this.n3 = n3;
    }

    public int getN4() {
        return n4;
    }

    public void setN4(int n4) {
        this.n4 = n4;
    }

    public int getN5() {
        return n5;
    }

    public void setN5(int n5) {
        this.n5 = n5;
    }

    public int getN6() {
        return n6;
    }

    public void setN6(int n6) {
        this.n6 = n6;
    }


}
