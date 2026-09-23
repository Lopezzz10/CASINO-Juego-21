package com.krakedev.juegos.servicios;

import java.util.ArrayList;
import java.util.Random;

import com.krakedev.juegos.entidades.Carta;

public class Dealer {
	
	 private ArrayList<Carta> naipe;

	    public Dealer() {
	        this.naipe = new ArrayList<>();
	        this.generarNaipe();
	    }
	
	public ArrayList<Carta> getNaipe() {
		return naipe;
	}

	public void setNaipe(ArrayList<Carta> naipe) {
		this.naipe = naipe;
	}
	
	public void generarNaipe() {
		ArrayList<String> palos = new ArrayList<>();
        palos.add("T");
        palos.add("CN");
        palos.add("D");
        palos.add("CR");

        ArrayList<String> valores = new ArrayList<>();
        valores.add("A");
        valores.add("2");
        valores.add("3");
        valores.add("4");
        valores.add("5");
        valores.add("6");
        valores.add("7");
        valores.add("8");
        valores.add("9");
        valores.add("10");
        valores.add("J");
        valores.add("Q");
        valores.add("K");

        for (String palo : palos) {
            for (String valor : valores) {
                Carta carta = new Carta();
                carta.setValor(valor);
                carta.setPalo(palo);
                this.naipe.add(carta);
            }
        }
    }
	public void imprimirNaipe() {
	    for (Carta carta : naipe) {
	        carta.imprimir();
	    }
	}
	public int generarAleatorio(int maximo) {
	    Random random = new Random();
	    return random.nextInt(maximo + 1); // nextInt es exclusivo del límite superior, por eso +1
	}
	public Carta entregarCarta() {
	    int posicion = generarAleatorio(naipe.size() - 1);
	    Carta cartaElegida = naipe.get(posicion);
	    naipe.remove(posicion);
	    return cartaElegida;
	}
}