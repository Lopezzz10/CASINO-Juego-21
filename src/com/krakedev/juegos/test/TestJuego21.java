package com.krakedev.juegos.test;

import com.krakedev.juegos.entidades.Jugador;
import com.krakedev.juegos.servicios.Juego21;

public class TestJuego21 {

	public static void main(String[] args) {
		Juego21 juego = new Juego21();

		Jugador jugador1 = new Jugador();
		jugador1.setNickname("Jugador1");

		Jugador jugador2 = new Jugador();
		jugador2.setNickname("Jugador2");

		Jugador jugador3 = new Jugador();
		jugador3.setNickname("Jugador3");

		juego.agregarJugador(jugador1);
		juego.agregarJugador(jugador2);
		juego.agregarJugador(jugador3);

		juego.inicializar();

		System.out.println("Tamaño del naipe antes de repartir: " + juego.getDealer().getNaipe().size());

		juego.repartirRonda();

		System.out.println("\n--- Cartas repartidas a cada jugador ---");
		for (Jugador jugador : juego.getJugadores()) {
			jugador.imprimir();
			System.out.println("-----------------------");
		}

		System.out.println("\n--- Naipe restante (verificar que las cartas repartidas ya no están) ---");
		juego.getDealer().imprimirNaipe();

		System.out.println("\nTamaño del naipe después de repartir: " + juego.getDealer().getNaipe().size());
	}
}