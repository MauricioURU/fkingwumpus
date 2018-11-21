package com.maop.fkingwumpus;

import java.util.Random;

public class Human extends Box {
	

	Random ranNum= new Random();
	int option;
	int NewPositionx;
	int NewPositiony;
	boolean open=true;
	boolean NearNoVisited;
	int danger;
	
	
	public void foundWumpus(int Position_y,int Position_x) {
		if(Main.probMonster[Position_y+1][Position_x]>=0.66) {
			Main.iFoundTheWumpus=true;
		}
		else if(Main.probMonster[Position_y-1][Position_x]>=0.66) {
			Main.iFoundTheWumpus=true;
		}
		else if(Main.probMonster[Position_y][Position_x+1]>=0.66) {
			Main.iFoundTheWumpus=true;
		}
		else if(Main.probMonster[Position_y][Position_x-1]>=0.66) {
			Main.iFoundTheWumpus=true;
		}
	}
	
	public void foundWumpus2(int Position_y,int Position_x) {
		if(Main.probMonster[Position_y+1][Position_x]>=0.33 && Main.changed[Position_y-1][Position_x]==true && Main.changed[Position_y][Position_x+1]==true && Main.changed[Position_y][Position_x-1]==true ){
			Main.iFoundTheWumpus=true;
		}
		else if(Main.probMonster[Position_y-1][Position_x]>=0.33  && Main.changed[Position_y+1][Position_x]==true && Main.changed[Position_y][Position_x+1]==true && Main.changed[Position_y][Position_x-1]==true ) {
			Main.iFoundTheWumpus=true;
		}
		else if(Main.probMonster[Position_y][Position_x+1]>=0.33  && Main.changed[Position_y+1][Position_x]==true && Main.changed[Position_y-1][Position_x]==true && Main.changed[Position_y][Position_x-1]==true ) {
			Main.iFoundTheWumpus=true;
		}
		else if(Main.probMonster[Position_y][Position_x-1]>=0.33  && Main.changed[Position_y+1][Position_x]==true && Main.changed[Position_y-1][Position_x]==true && Main.changed[Position_y][Position_x+1]==true ) {
			Main.iFoundTheWumpus=true;
		}
	}
	
	public void foundTreasures(int Position_y,int Position_x) {
		if(Main.probGlitter[Position_y+1][Position_x]>=0.66) {
			Main.iFoundTreasure=true;
		}
		else if(Main.probGlitter[Position_y-1][Position_x]>=0.66) {
			Main.iFoundTreasure=true;
		}
		else if(Main.probGlitter[Position_y][Position_x+1]>=0.66) {
			Main.iFoundTreasure=true;
		}
		else if(Main.probGlitter[Position_y][Position_x-1]>=0.66) {
			Main.iFoundTreasure=true;
		}
	}
	
	public void someMonsters(int Position_y,int Position_x) {
		
		if(Main.visited[Position_y][Position_x]== 0 && Main.stench[Position_y][Position_x]== 1 ) {
			if(Main.visited[Position_y+1][Position_x]==0 && Main.changed[Position_y+1][Position_x]==false) {
			Main.probMonster[Position_y+1][Position_x]= Main.probMonster[Position_y+1][Position_x] + 0.33;
			}
			if(Main.visited[Position_y-1][Position_x]==0 &&  Main.changed[Position_y-1][Position_x]==false) {
			Main.probMonster[Position_y-1][Position_x]= Main.probMonster[Position_y-1][Position_x] + 0.33;
			}
			if(Main.visited[Position_y][Position_x+1]==0 && Main.changed[Position_y][Position_x+1]==false) {
			Main.probMonster[Position_y][Position_x+1]= Main.probMonster[Position_y][Position_x+1] + 0.33;
			}
			if(Main.visited[Position_y][Position_x-1]==0 && Main.changed[Position_y][Position_x-1]==false ) {
			Main.probMonster[Position_y][Position_x-1]= Main.probMonster[Position_y][Position_x-1] + 0.33;
			}
		}
		else if( Main.stench[Position_y][Position_x]==0){
			Main.probMonster[Position_y][Position_x]= 0;
			Main.changed[Position_y][Position_x]=true;
			Main.probMonster[Position_y+1][Position_x]= 0;
			Main.changed[Position_y+1][Position_x]=true;
			Main.probMonster[Position_y-1][Position_x]= 0;
			Main.changed[Position_y-1][Position_x]=true;
			Main.probMonster[Position_y][Position_x+1]= 0;
			Main.changed[Position_y][Position_x+1]=true;
			Main.probMonster[Position_y][Position_x-1]= 0;
			Main.changed[Position_y][Position_x-1]=true;
		}
		System.out.println("Abajo:" + Main.probMonster[Position_y+1][Position_x]);
		System.out.println("Arriba:" + Main.probMonster[Position_y-1][Position_x]);
		System.out.println("Derecha:" + Main.probMonster[Position_y][Position_x+1]);
		System.out.println("Izquierda:" + Main.probMonster[Position_y][Position_x-1] );
		System.out.println("Edor:" + Main.stench[Position_y][Position_x] );
	}
	
    public void someHoles(int Position_y,int Position_x) {
    	if(Main.visited[Position_y][Position_x]== 0 && Main.breeze[Position_y][Position_x]== 1 ) {
			if(Main.visited[Position_y+1][Position_x]==0) {
			Main.probHole[Position_y+1][Position_x]= Main.probHole[Position_y+1][Position_x] + 0.33;
			}
			if(Main.visited[Position_y-1][Position_x]==0) {
			Main.probHole[Position_y-1][Position_x]= Main.probHole[Position_y-1][Position_x] + 0.33;
			}
			if(Main.visited[Position_y][Position_x+1]==0) {
			Main.probHole[Position_y][Position_x+1]= Main.probHole[Position_y][Position_x+1] + 0.33;
			}
			if(Main.visited[Position_y][Position_x-1]==0) {
			Main.probHole[Position_y][Position_x-1]= Main.probHole[Position_y][Position_x-1] + 0.33;
			}
		}
		else if( Main.breeze[Position_y][Position_x]==0){
			Main.probHole[Position_y][Position_x]= 0;
			Main.probHole[Position_y+1][Position_x]= 0;
			Main.probHole[Position_y-1][Position_x]= 0;
			Main.probHole[Position_y][Position_x+1]= 0;
			Main.probHole[Position_y][Position_x-1]= 0;
		}
		System.out.println("Abajo:" + Main.probHole[Position_y+1][Position_x]);
		System.out.println("Arriba:" + Main.probHole[Position_y-1][Position_x]);
		System.out.println("Derecha:" + Main.probHole[Position_y][Position_x+1]);
		System.out.println("Izquierda:" + Main.probHole[Position_y][Position_x-1] );
		System.out.println("brisa:" + Main.breeze[Position_y][Position_x] );
		
	}
    
    public void chestGlitter(int position_y, int position_x){
    	if(Main.visited[Position_y][Position_x]== 0 && Main.glitter[Position_y][Position_x]== 1 ) {
			if(Main.visited[Position_y+1][Position_x]==0) {
			Main.probGlitter[Position_y+1][Position_x]= Main.probGlitter[Position_y+1][Position_x] + 0.33;
			}
			if(Main.visited[Position_y-1][Position_x]==0) {
			Main.probGlitter[Position_y-1][Position_x]= Main.probGlitter[Position_y-1][Position_x] + 0.33;
			}
			if(Main.visited[Position_y][Position_x+1]==0) {
			Main.probGlitter[Position_y][Position_x+1]= Main.probGlitter[Position_y][Position_x+1] + 0.33;
			}
			if(Main.visited[Position_y][Position_x-1]==0) {
			Main.probGlitter[Position_y][Position_x-1]= Main.probGlitter[Position_y][Position_x-1] + 0.33;
			}
			
    	}
		else if( Main.glitter[Position_y][Position_x]==0){
			Main.probGlitter[Position_y][Position_x]= 0;
			Main.probGlitter[Position_y+1][Position_x]= 0;
			Main.probGlitter[Position_y-1][Position_x]= 0;
			Main.probGlitter[Position_y][Position_x+1]= 0;
			Main.probGlitter[Position_y][Position_x-1]= 0;
		}
		System.out.println("Abajo:" + Main.probGlitter[Position_y+1][Position_x]);
		System.out.println("Arriba:" + Main.probGlitter[Position_y-1][Position_x]);
		System.out.println("Derecha:" + Main.probGlitter[Position_y][Position_x+1]);
		System.out.println("Izquierda:" + Main.probGlitter[Position_y][Position_x-1] );
		System.out.println("brillo:" + Main.glitter[Position_y][Position_x] );
		
	}
	
	public void danger(int position_y, int position_x) {

		if(Main.secure[position_y][position_x]==0){
			danger=1;
	}else {danger=0;}
}
	
	public void movoToSecure(int position_y,int position_x) {
		 boolean open=true;
			do {
		double a=Math.random();

		if(a>=0 && a<0.25) {
		if(Main.visited[position_y+1][position_x]==1 && (Main.secure[position_y+1][position_x]==1 || Main.secure[position_y+1][position_x]==2 )) {
			NewPositiony= position_y+1;
			NewPositionx=position_x;
			open=false;
		 }
		}
		
		else if(a>=0.25 && a<0.5) {
		 if(Main.visited[position_y-1][position_x]==1 && (Main.secure[position_y-1][position_x]==1 || Main.secure[position_y-1][position_x]==2  )) {
			NewPositiony= position_y-1;
			NewPositionx=position_x;
			open=false;
		 }
		}
		else if(a>=0.5 && a<0.75) {
		 if(Main.visited[position_y][position_x+1]==1 && (Main.secure[position_y][position_x+1]==1 || Main.secure[position_y][position_x+1]==2  ) ) {
			NewPositiony= position_y;
			NewPositionx=position_x+1;
			open=false;
		 }
		}
		
		else if(a>=0.75)
		 if(Main.visited[position_y][position_x-1]==1 && (Main.secure[position_y][position_x-1]==1 || Main.secure[position_y][position_x-1]==2  ) ) {
			NewPositiony= position_y;
			NewPositionx=position_x-1;
			open=false;
		}
			}while(open);
			open=true;
}
	
	public void someNoVisited(int position_y, int position_x) {
		if(Main.visited[position_y+1][position_x]==0 || Main.visited[position_y-1][position_x]==0 ||  Main.visited[position_y][position_x+1]==0 ||  Main.visited[position_y][position_x-1]==0  ) {
			NearNoVisited=true;
		}
		else {
			NearNoVisited=false;
		}
	}
	
	public void moveToNoVisited(int position_y, int position_x) {
		 boolean open=true;
		do{
		
			double a=Math.random();
			
			
			if(Main.visited[position_y+1][position_x]==0 && a>=0 && a<0.25 ) {
				NewPositiony= position_y+1;
				NewPositionx=position_x;
				open=false;
			}
			
			
			else if(Main.visited[position_y-1][position_x]==0 && a>=0.25 && a<0.5) {
				NewPositiony= position_y-1;
				NewPositionx=position_x;
				open=false;
			}
			
			
			else if(Main.visited[position_y][position_x+1]==0 && a>=0.5 && a<0.75) {
				NewPositiony= position_y;
				NewPositionx=position_x+1;
				open=false;
			}
			
			
			else if(Main.visited[position_y][position_x-1]==0 && a>=0.75) {
				NewPositiony= position_y;
				NewPositionx=position_x-1;
				open=false;
			}
			
		
	}while(open);
		open=true;
}
	
 	public void moveRan(int position_x, int position_y) {
		
		option= ranNum.nextInt(4);
		
		switch(option) {
		
		case 0: 
			if(position_y + 1 != 5) {
				NewPositiony= position_y+1;
				NewPositionx=position_x;
			}
			else{
				NewPositiony= position_y-1;
				NewPositionx=position_x;
				}
			break;
			
		case 1:	
			if(position_y - 1 !=0) {
				NewPositiony= position_y-1;
				NewPositionx=position_x;
			}
			else{
				NewPositiony= position_y+1;
				NewPositionx=position_x;
				}
			break;
			
		case 2:
			if(position_x + 1 !=5) {
				NewPositionx= position_x+1;
				NewPositiony=position_y;
			}
			else{
				NewPositionx= position_x-1;
				NewPositiony=position_y;
				}
			break;
		
		case 3:
			if(position_x - 1 !=0) {
				NewPositionx= position_x-1;
				NewPositiony=position_y;
			} 
			else{
			NewPositionx= position_x+1;
			NewPositiony=position_y;
			}
			
			break;
			
		default:
			NewPositionx= position_x;
			NewPositiony=position_y;
			break;
		}
	}
}