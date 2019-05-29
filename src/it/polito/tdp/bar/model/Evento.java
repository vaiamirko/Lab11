package it.polito.tdp.bar.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Evento {
	
	private enum TIPO{
		ARRIVO_GRUPPO_CLIENTI,
		SERVIZIO_TAVOLO,
		SERVIZIO_BANCONE,
		USCITA_CLIENTE,
		
		
	}
	
	private LocalDateTime data;
	private int num_persone;
	private Duration durata;
	private int tolleranza;
	public TIPO Tipoevento;
	
	public Evento(LocalDateTime data, int num_persone, Duration durata, int tolleranza, TIPO tipoevento) {
		super();
		this.data = data;
		this.num_persone = num_persone;
		this.durata = durata;
		this.tolleranza = tolleranza;
		Tipoevento = tipoevento;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public int getNum_persone() {
		return num_persone;
	}
	public void setNum_persone(int num_persone) {
		this.num_persone = num_persone;
	}
	public Duration getDurata() {
		return durata;
	}
	public void setDurata(Duration durata) {
		this.durata = durata;
	}
	public int getTolleranza() {
		return tolleranza;
	}
	public void setTolleranza(int tolleranza) {
		this.tolleranza = tolleranza;
	}
	public TIPO getTipoevento() {
		return Tipoevento;
	}
	public void setTipoevento(TIPO tipoevento) {
		Tipoevento = tipoevento;
	}
	
	
	
	
	
	

}
