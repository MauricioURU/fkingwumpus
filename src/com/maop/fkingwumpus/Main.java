package com.maop.fkingwumpus;

import java.io.IOException;

public class Main extends Box {
	
	static boolean Gameover;
	public static int secure[][] = new int[6][6];
	public static int visited[][] = new int[6][6];
	public static int stench[][] = new int[6][6];
    public static int breeze[][]= new int[6][6];
    public static boolean changed[][]= new boolean[6][6];
    public static double probMonster[][]= new double[6][6];
    public static double probHole[][]= new double[6][6];
	static boolean foundtreasure;
	static boolean dead;
	public static boolean iFoundTheWumpus=false;
	
	public static void main(String[] args) throws IOException {
		Gameover=true;
		// Objetos del mapa
		
		Human human = new Human();
		Monster wumpus = new Monster();
		Hole pit= new Hole();
		Hole pit2= new Hole();
		Treasure chest = new Treasure();
		
		int a = 1;
		
		for(int i = 0; a != i;){
		
		// Generador de posiciones ---> class Rnd Number
		
		RndNumber ranNum = new RndNumber();
		ranNum.rnd();
		
		
			// Posicion del Humano
		
			human.Position_x=1;
			human.Position_y=4;
		
			// Posicion del Wumpus
		
			wumpus.Position_x = ranNum.numerosx[0];
			wumpus.Position_y = ranNum.numerosy[0];
		
			// Posicion de los hollos
		
			pit.Position_x = ranNum.numerosx[1];
			pit.Position_y = ranNum.numerosy[1];
			pit2.Position_x = ranNum.numerosx[2];
			pit2.Position_y = ranNum.numerosy[2];
			
			// Posicion del tesoro
			
			chest.Position_x = ranNum.numerosx[3];
			chest.Position_y = ranNum.numerosy[3];
			
			// Comprueba si los objetos no estan en la misma posicion del humano
			
		if(pit.Position_x == human.Position_x && pit.Position_y == human.Position_y || pit2.Position_x == human.Position_x && pit2.Position_y == human.Position_y || wumpus.Position_x == human.Position_x && wumpus.Position_y == human.Position_y || chest.Position_x == human.Position_x && chest.Position_y == human.Position_y ) {
			a=1;
		}else {a=0;}
		
	}
		
		// Mapa	
	
		for(int y=0; y <= 5;y++) {
			
			for(int x=0; x <= 5;x++) {
				if(x==human.Position_x && y==human.Position_y){
					System.out.print(" H ");
					secure[y][x]= 1;
					visited[y][x]=1;
					changed[y][x]=true;
				}
				else if(x==wumpus.Position_x && y==wumpus.Position_y){
					System.out.print(" W ");
				}
				else if(x==pit.Position_x && y==pit.Position_y){
					System.out.print(" @ ");
				}
				else if(x==pit2.Position_x && y==pit2.Position_y){
					System.out.print(" @ ");
				}
				else if(x==chest.Position_x && y==chest.Position_y){
					System.out.print(" $ ");
					secure[y][x]= 2;
					visited[y][x]=0;
					changed[y][x]=false;
				}
			    else if(x==0) {
					System.out.print("= ");
					secure[y][x]= 3;
					visited[y][x]=1;
					changed[y][x]=true;
				}
				else if(x==5) {
					System.out.println(" =");
					secure[y][x]= 3;
					visited[y][x]=1;
					changed[y][x]=true;
				}
				else if(y== 0 || y==5) {
					System.out.print(" = ");
					secure[y][x]= 3;
					visited[y][x]=1;
					changed[y][x]=true;
				}
				else if(y !=0 || y!=5 ){
					System.out.print("   ");
					secure[y][x]= 2;
					visited[y][x]=0;
					breeze[y][x]=0;
					changed[y][x]=false;
				}
			}
		}
		
		// coloca las zonas seguras y las visitadas
		
		wumpus.dangerBox(wumpus.Position_y, wumpus.Position_x);
		pit.dangerBox(pit.Position_y,pit.Position_x);
		pit2.dangerBox(pit2.Position_y, pit2.Position_x);
		secure[4][1]= 1;
		visited[4][1]=0;
		
		System.out.println(" ");
		System.out.println("Huecos:");
		human.someHoles(human.Position_y, human.Position_x);
		System.out.println(" ");
		System.out.println("Wumpus:");
		human.someMonsters(human.Position_y, human.Position_x);
		visited[human.Position_y][human.Position_x]=1;
		
		do {
			try{ Thread.sleep(2000); } 
			catch(InterruptedException e ){ System.out.println("Thread Interrupted"); }
			
			System.out.println("---------------- ");
			
			
			
			
			human.danger(human.Position_y, human.Position_x);
			if(human.danger==1) {
				human.movoToSecure(human.Position_y, human.Position_x);
			}
			else if(human.danger==0) {
				human.someNoVisited(human.Position_y, human.Position_x);
				if(human.NearNoVisited){
					human.moveToNoVisited(human.Position_y, human.Position_x);
				}
				else{
					
					human.moveRan(human.Position_x, human.Position_y);
				}
			}
		
		
		// Actualiza la posicion del humano
		human.Position_x=human.NewPositionx;
		human.Position_y=human.NewPositiony;
		
		human.foundWumpus(human.Position_y, human.Position_x);
		human.foundWumpus2(human.Position_y, human.Position_x);
		if(iFoundTheWumpus) {
			wumpus.heFoundMe(wumpus.Position_y,wumpus.Position_x);
			pit.dangerBox(pit.Position_y,pit.Position_x);
			pit2.dangerBox(pit2.Position_y, pit2.Position_x);
		}
		
		// verifica si el humano murio o gano 
		if(human.Position_x==wumpus.Position_x && human.Position_y==wumpus.Position_y && secure[wumpus.Position_y][wumpus.Position_x]==0|| human.Position_x==pit.Position_x && human.Position_y==pit.Position_y || human.Position_x==pit2.Position_x && human.Position_y==pit2.Position_y) {
			Gameover=false;
			dead=true;
		}
		else if(human.Position_x==chest.Position_x && human.Position_y==chest.Position_y) {
			Gameover=false;
			foundtreasure=true;
		}
		
		
		// Actualiza el Mapa
		
		for(int y=0; y <= 5;y++) {
			
			for(int x=0; x <= 5;x++) {
				if(x==human.Position_x && y==human.Position_y){
					System.out.print(" H ");
				}
				else if(x==wumpus.Position_x && y==wumpus.Position_y){
					if(iFoundTheWumpus==false) {
					System.out.print(" W ");
					}else {System.out.print("   ");}
				}
				else if(x==pit.Position_x && y==pit.Position_y){
					System.out.print(" @ ");
				}
				else if(x==pit2.Position_x && y==pit2.Position_y){
					System.out.print(" @ ");
				}
				else if(x==chest.Position_x && y==chest.Position_y){
					System.out.print(" $ ");
				}
			    else if(x==0) {
					System.out.print("= ");
				}
				else if(x==5) {
					System.out.println(" =");
				}
				else if(y== 0 || y==5) {
					System.out.print(" = ");
				}
				else if(y !=0 || y!=5 ){
					System.out.print("   ");
					
					}
				}
			}
		System.out.println(" ");
		System.out.println("Huecos:");
		human.someHoles(human.Position_y, human.Position_x);
		System.out.println(" ");
		System.out.println("Wumpus:");
		human.someMonsters(human.Position_y, human.Position_x);
		// Actualiza las casilla
		visited[human.Position_y][human.Position_x]=1;
		
		}while(Gameover);
		if(dead) {
			System.out.println("\n -----------------MORISTE-----------------");
		}
		else if(foundtreasure) {
			System.out.println("\n -----------------GANASTE-------------------");
		}
	}
}