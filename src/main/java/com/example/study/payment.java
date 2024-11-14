package com.example.study;

import java.util.Optional;

public interface payment {
    void type();
    void obtaintPayment();
    String returnPayment();


    default int salidasasd(int cuenta){
        return cuenta;
    }
}
