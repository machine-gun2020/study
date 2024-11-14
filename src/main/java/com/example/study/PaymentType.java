package com.example.study;

public class PaymentType implements payment{

    @Override
    public void type() {
        System.out.println("Este");
    }

    @Override
    public void obtaintPayment() {
        System.out.println("Obtaint Payment");
    }

    @Override
    public String returnPayment() {
        return "Saul";
    }
}
