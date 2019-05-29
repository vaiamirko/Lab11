package it.polito.tdp.bar.model;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

import javafx.util.Duration;

public class Simulatore {
	
	//CREAZIONE CODA DEGLI EVENTI
	
	private PriorityQueue<Evento> queue;
	
	//gestione dei tavoli
	
	private PriorityQueue<Evento> codaTavoli;
	
	private List<Tavolo> listaTavoli;
	
	private Map<Integer,Tavolo> mappatavoli;
	
	
	
	
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
		//pulisco la coda
		queue.clear();
		//creo gli eventi arrivoclienti
		Evento eventoarrivo;
		//inizializzo i parametri iniziali
		num_TAVOLI_tipoA=2;
		num_TAVOLI_tipoB=4;
		 num_TAVOLI_tipoC=4;
		 num_TAVOLI_tipoD=5;
		 num_NUMERICLIENTIARRIVO=numeroclienti;
		 
		 Random random = new Random();
		 //inizializzo gli eventi iniziali
		 eventoarrivo=new Evento(LocalTime.now(), i, null, i, null);
		 
		 
		 for(int i=1;i<=2000;i++) {
			 eventoarrivo=new Evento(LocalTime.now().plusMinutes(Math.random()*10), (Math.random()*10)+1, Duration.minutes(60+Math.random()*60),Math.random() ,ARRIVO_GRUPPO_CLIENTI);
			 
		 }
	
		 
		 
	}
	
	public void run() {
		
		
		while(queue.poll()!=null) {
			
			Evento ev = queue.poll();
			
			switch ( ev.getTipoevento()) {
			
			case ARRIVO_GRUPPO_CLIENTI:
				
				numero_totale_clienti+=ev.getNum_persone();
				
				if(ev.getTolleranza()==0.0) {
					numero_clienti_insoddisfatti++;
				}else {
					int numBanconePossibili;
					int numTavoloPrioritari;
					numBanconePossibili=ev.getNum_persone()*ev.getTolleranza();
					numTavoloPrioritari=ev.getNum_persone()*ev.getTolleranza();
					if(this.ricercaTavoloPiccolo(ev.getNum_persone())!=null) {
						//se esiste un tavolo dispobibile
						
						//creo l'evento di servizio al tavolo
						queue.add(new Evento());
						//aggiorno la stitistica dei clienti soddisfatti
					
					}else {//non vengono soddisfatti i clienti e quindi li mando al bancone
						
						//creo l'evento di mandare al bancone...
						queue.add(new Evento());
						
						
					}
				
				}
				
				
				
				break;
				
			case SERVIZIO_TAVOLO:
				
				
			
				numero_clienti_soddisfatti = ev.getNum_persone()+numero_clienti_soddisfatti;
				break;
				
			case SERVIZIO_BANCONE:
				int numeroClietiTolleranti;
				numeroClietiTolleranti=ev.getNum_persone()*ev.getTolleranza();
				
				numero_clienti_soddisfatti+=numeroClietiTolleranti;
				
				break;
				
			
			
			
			}
			
		}
		
		
		
	}

public int totpostiTavoliliberi() {
	
	int s=num_TAVOLI_tipoA*10+num_TAVOLI_tipoB*8+num_TAVOLI_tipoC*6+num_TAVOLI_tipoD*4;
	//calcolo la sooma total3e dei tavoli
	
	return s;

}

public int metapostitavolo(Tavolo t) {
	int temporanea = (int) (t.getPosti_disponibili()*0.5);
	return temporanea;
}

public Tavolo ricercaTavoloPiccolo(int numPersone) {
	
	//trovo il minimo che è più grande 
	int min=10000000;
	/*
	for(Integer i : mappatavoli.keySet()) {
		if(i>=numPersone && mappatavoli.get(i).getNumeroTavoliDisponibili()>0 && numPersone>metapostitavolo(mappatavoli.get(i)))
			min=i;
	}
	*/
	for(Integer i : mappatavoli.keySet()) {
		if(i>=numPersone && mappatavoli.get(i).getNumeroTavoliDisponibili()>0 && numPersone>metapostitavolo(mappatavoli.get(i))) {
			
			Tavolo tav = new Tavolo();
			
			tav = mappatavoli.get(i);
			
			mappatavoli.get(i).occupatavolo();
			return tav;
		}
			
		
	}
		
	return null;
	
	
}

	
	

}
