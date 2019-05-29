package it.polito.tdp.bar.model;

import java.util.Comparator;

public class Tavolo implements Comparator<Tavolo>{
	
	private int posti_disponibili;
	//private int posti_occupati;
	private int numeroTavoliDisponibili;
	
	
	public int getPosti_disponibili() {
		return posti_disponibili;
	}
	public void setPosti_disponibili(int posti_disponibili) {
		this.posti_disponibili = posti_disponibili;
	}
	
	public int getNumeroTavoliDisponibili() {
		return numeroTavoliDisponibili;
	}
	public void setNumeroTavoliDisponibili(int numeroTavoliDisponibili) {
		this.numeroTavoliDisponibili = numeroTavoliDisponibili;
	}
	@Override
	public int compare(Tavolo o1, Tavolo o2) {
		// TODO Auto-generated method stub
		return o1.posti_disponibili-o2.posti_disponibili;
	}
	
	
	public void occupatavolo() {
		this.numeroTavoliDisponibili--;
	}
	
	public void liberatavolo() {
		this.numeroTavoliDisponibili++;
	}
	
	

}
