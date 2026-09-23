package com.krakedev.juegos.test;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Jugador;
import com.krakedev.juegos.servicios.Juego21;

public class TestJuego21 {

	public static void main(String[] args) {

		// ===================== PRUEBA 1: ejecutar jugar() una vez =====================
		System.out.println("========== PRUEBA 1: jugar() ==========");

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

		ArrayList<Jugador> ganadores = juego.jugar();

		System.out.println("\n--- Cartas y puntaje final de cada jugador ---");
		for (Jugador jugador : juego.getJugadores()) {
			jugador.imprimir();
			System.out.println("Puntaje total: " + jugador.getPuntajeCartas());
			System.out.println("-----------------------");
		}

		System.out.println("\n--- Ganadores ---");
		if (ganadores.isEmpty()) {
			System.out.println("Nadie llegó a 21 en las 3 rondas.");
		} else {
			for (Jugador jugador : ganadores) {
				System.out.println(jugador.getNickname() + " ganó con " + jugador.getPuntajeCartas() + " puntos");
			}
		}

		// ===================== PRUEBA 2: repetir 10 veces =====================
		System.out.println("\n\n========== PRUEBA 2: repetir jugar() 10 veces ==========");

		for (int i = 0; i < 10; i++) {
			System.out.println("\n--- Partida N° " + (i + 1) + " ---");

			// Reiniciar puntaje y cartas de cada jugador antes de volver a jugar
			for (Jugador jugador : juego.getJugadores()) {
				jugador.getCartas().clear();
				jugador.setPuntajeCartas(0);
			}

			// Reiniciar el dealer (mazo completo de nuevo)
			juego.inicializar();

			ArrayList<Jugador> ganadoresRonda = juego.jugar();

			for (Jugador jugador : juego.getJugadores()) {
				System.out.println(jugador.getNickname() + " -> puntaje: " + jugador.getPuntajeCartas()
						+ " | cantidad de cartas: " + jugador.getCartas().size());
			}

			if (ganadoresRonda.isEmpty()) {
				System.out.println("Resultado: nadie ganó en esta partida.");
			} else {
				System.out.println("Resultado: ganador(es) -> ");
				for (Jugador jugador : ganadoresRonda) {
					System.out.println("   " + jugador.getNickname() + " con " + jugador.getPuntajeCartas() + " puntos");
				}
			}
		}
	}
}