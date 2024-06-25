package com.example.study;

public interface payment {
    void type();
    void obtaintPayment();
    int cuenta = 0;
    default int salidasasd(int cuenta){
        return cuenta;
    }
}
