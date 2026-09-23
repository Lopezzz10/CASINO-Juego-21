package com.krakedev.juegos.servicios;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Carta;
import com.krakedev.juegos.entidades.Jugador;

public class Juego21 {

	private ArrayList<Jugador> jugadores;
	private Dealer dealer;

	public Juego21() {
		this.jugadores = new ArrayList<>();
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public void inicializar() {
		this.dealer = new Dealer();
		this.cargarValores();
	}

	public void cargarValores() {
		for (Carta carta : dealer.getNaipe()) {
			String valor = carta.getValor();

			if (valor.equals("A")) {
				carta.setValorJuego(11);
			} else if (valor.equals("J") || valor.equals("Q") || valor.equals("K")) {
				carta.setValorJuego(10);
			} else {
				carta.setValorJuego(Integer.parseInt(valor));
			}
		}
	}

	public void agregarJugador(Jugador jugador) {
		this.jugadores.add(jugador);
	}

	public void repartirCarta(Jugador jugador) {
		Carta carta = dealer.entregarCarta();
		jugador.recibirCarta(carta);
	}

	public void calcularTotal() {
	    for (Jugador jugador : jugadores) {
	        int suma = 0;
	        for (Carta carta : jugador.getCartas()) {
	            suma += carta.getValorJuego();
	        }
	        jugador.setPuntajeCartas(suma);
	    }
	}

	public void repartirRonda() {
	    for (Jugador jugador : jugadores) {
	        repartirCarta(jugador);
	    }
	    calcularTotal();
	}
	
}