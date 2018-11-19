package com.maop.fkingwumpus;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RndNumber {
	
	public int numerosy[]= new int[4];
	public int numerosx[]= new int[4];
	Set<Integer> generados = new HashSet<>();
	Set<Integer> generados1 = new HashSet<>();
	Random Rnd= new Random();
	
	public void rnd() {
		
		for (int i = 0; i < 4; i++) {
	    int aleatorio = -1;
	    boolean generado = false;
	    while (!generado) {
	        int posible = 1 + Rnd.nextInt(4);
	        if (!generados.contains(posible)) {
	            generados.add(posible);
	            aleatorio = posible;
	            generado = true;
	        		}
	    		}
	    
	        numerosx[i] = aleatorio;
	    }
		
		for (int i = 0; i < 4; i++) {
		    int aleatorio = -1;
		    boolean generado = false;
		    while (!generado) {
		        int posible = 1 + Rnd.nextInt(4);
		        if (!generados1.contains(posible)) {
		            generados1.add(posible);
		            aleatorio = posible;
		            generado = true;
		        	}
		    	}
		    
		    numerosy[i] = aleatorio;
		}
	}	
}
