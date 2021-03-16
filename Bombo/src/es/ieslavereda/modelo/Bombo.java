package es.ieslavereda.modelo;

import java.util.ArrayList;

public class Bombo {

	ArrayList<Integer> sacados = new ArrayList<>();
	int valores;
	
	public Bombo() {
		
	}
	
	public int sacarBola(int valor) {
		
		int tema = 0;
		do {
			tema = (int)(Math.random() * (valor - 1) + 1);
		} while(sacados.contains(valor));
			
		
		sacados.add(tema);	
		
		return tema;
		
	}
	
	
	
}
