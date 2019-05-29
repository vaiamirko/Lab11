package it.polito.tdp.bar.model;

import java.time.LocalTime;
import java.util.PriorityQueue;
import java.util.Random;

import javafx.util.Duration;

public class Simulatore {
	
	//CREAZIONE CODA DEGLI EVENTI
	
	private PriorityQueue<Evento> queue;
	
	//parametri della simulazione
	
	private int num_TAVOLI_tipoA;
	private int num_TAVOLI_tipoB;
	private int num_TAVOLI_tipoC;
	private int num_TAVOLI_tipoD;
	private int num_NUMERICLIENTIARRIVO;
	
	
	
	//statistiche simulazione
	
	private int numero_totale_clienti;
	private int numero_clienti_soddisfatti;
	private int numero_clienti_insoddisfatti;
	
	
	public void init(int numeroeventi)
	{
		Evento eventoarrivo;
		//inizializzo i parametri iniziali
		num_TAVOLI_tipoA=2;
		num_TAVOLI_tipoB=4;
		 num_TAVOLI_tipoC=4;
		 num_TAVOLI_tipoD=5;
		 num_NUMERICLIENTIARRIVO=numeroclienti;
		 //inizializzo gli eventi iniziali
		 eventoarrivo=new Evento(LocalTime.now(), i, null, i, null);
		 
		 
		 for(int i=1;i<=2000;i++) {
			 eventoarrivo=new Evento(LocalTime.now().plusMinutes(Math.random()*10), (Math.random()*10)+1, Duration.minutes(Math.random(60,120)),Math.random() ,ARRIVO_GRUPPO_CLIENTI);
			 
		 }
	
		 
		 
	}
	
	public void run() {
		
		
		while(queue.poll()!=null) {
			
			Evento ev = queue.poll();
			switch ( ev.getTipoevento()) {
			
			case ARRIVO_GRUPPO_CLIENTI:
				
				break;
				
			case SERVIZIO_TAVOLO:
				break;
				
			case SERVIZIO_BANCONE:
				break;
				
			
			
			
			}
			
		}
		
		
		
	}

public int totpostiTavoliliberi() {
	
	int s=num_TAVOLI_tipoA*10+num_TAVOLI_tipoB*8+num_TAVOLI_tipoC*6+num_TAVOLI_tipoD*4;
	//calcolo la sooma total3e dei tavoli
	
	return s;

}

	
	

}
