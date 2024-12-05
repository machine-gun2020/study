package com.example.study.dto;


public class SorteoDtoN1 {
    @Override
    public String toString() {
        return String.valueOf(n1);
    }

    private int n1;

    // Constructor
    public SorteoDtoN1(int n1) {
        this.n1 = n1;
    }

    // Getters and setters
    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }
}

