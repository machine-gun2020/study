package com.example.study;

import com.example.study.dto.ColsDto;
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

    public static String calculate(List<ColsDto> records) {
        // Implementa el cálculo que deseas realizar con la lista de registros
        // Por ahora, solo devolveré un string que concatena la representación de los registros para fines ilustrativos
        int[] resultb = new int[6];

        // Calcular el pronóstico basado en los sorteos
        for (int i = 0; i < 6; i++) {
            int sum = 0;
            for (ColsDto sorteo : records) {
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
            resultb[i] = sum / records.size();
        }
        System.out.println(Arrays.toString(resultb));

        //StringBuilder result = new StringBuilder();

        return resultb.toString();
    }
}

