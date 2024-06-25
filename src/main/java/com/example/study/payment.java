package com.example.study;

import java.util.Optional;

public interface payment {
    void type();
    void obtaintPayment();

    int cuenta = 0;
    default int salidasasd(int cuenta){
        return cuenta;
    }
}
