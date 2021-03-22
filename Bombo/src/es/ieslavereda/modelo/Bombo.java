package es.ieslavereda.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class Bombo {

	LinkedList<Integer> bolas = new LinkedList<>();
	
	
	
	public Bombo() {
		
		
		
	}
	
	public int sacarBola(int valor) {
		
		
		
		Collections.shuffle(bolas);
		
	

		return bolas.poll();
		
	
		

		
	}
	
	public LinkedList<Integer> rellenar(int valor) {
		
		bolas.removeAll(bolas);
	
		for(int i = 0; i < valor; i++) {
			
			bolas.add(i +1);
			
		}
	
		
		return bolas;
	}
	
	
	
}
