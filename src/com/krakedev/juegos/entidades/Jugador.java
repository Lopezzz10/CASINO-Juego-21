package com.krakedev.juegos.entidades;

import java.util.ArrayList;

public class Jugador {

	private String nickname;
	private ArrayList<Carta> cartas = new ArrayList<>();

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public ArrayList<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}

	public void recibirCarta(Carta carta) {
		this.cartas.add(carta);
	}
}