package com.example.study;

import com.example.study.model.Sorteo;

import java.util.Arrays;
import java.util.List;

public class CombinatorialCondensationExample {

    public static int[] predictNextResult(List<Sorteo> sorteos) {
        int[] result = new int[6];

        // Calcular el pronóstico basado en los sorteos
        for (int i = 0; i < 6; i++) {
            int sum = 0;
            for (Sorteo sorteo : sorteos) {
                switch (i) {
                    case 0:
                        sum += sorteo.getN1();
                        break;
                    case 1:
                        sum += sorteo.getN2();
                        break;
                    case 2:
                        sum += sorteo.getN3();
                        break;
                    case 3:
                        sum += sorteo.getN4();
                        break;
                    case 4:
                        sum += sorteo.getN5();
                        break;
                    case 5:
                        sum += sorteo.getN6();
                        break;
                }
            }
            result[i] = sum / sorteos.size();
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}

