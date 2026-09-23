package com.krakedev.juegos.test;

import com.krakedev.juegos.servicios.Dealer;

public class TestAleatorio {

    public static void main(String[] args) {
        Dealer dealer = new Dealer();
        int maximo = 10;

        boolean genero0 = false;
        boolean generoMaximo = false;
        boolean seExcedio = false;

        for (int i = 0; i < 100; i++) {
            int numero = dealer.generarAleatorio(maximo);
            System.out.println("Iteración " + (i + 1) + ": " + numero);

            if (numero == 0) {
                genero0 = true;
            }
            if (numero == maximo) {
                generoMaximo = true;
            }
            if (numero < 0 || numero > maximo) {
                seExcedio = true;
            }
        }

        System.out.println("\n--- Resultados de la verificación ---");
        System.out.println("¿Generó al menos un 0?: " + genero0);
        System.out.println("¿Generó al menos un " + maximo + " (máximo)?: " + generoMaximo);
        System.out.println("¿Se excedió del rango [0, " + maximo + "]?: " + seExcedio);
    }
}