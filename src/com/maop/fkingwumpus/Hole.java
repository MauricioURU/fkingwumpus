package com.maop.fkingwumpus;


public class Hole extends Box {

	
	public void dangerBox(int position_y,int position_x) {
		Main.secure[Position_y][Position_x]=0;
		Main.visited[position_y][position_x]=0;
		Main.secure[Position_y+1][Position_x]=0;
		Main.secure[Position_y-1][Position_x]=0;
		Main.secure[Position_y][Position_x+1]=0;
		Main.secure[Position_y][Position_x-1]=0;
		Main.breeze[Position_y+1][Position_x]=1;
		Main.breeze[Position_y-1][Position_x]=1;
		Main.breeze[Position_y][Position_x+1]=1;
		Main.breeze[Position_y][Position_x-1]=1;
	}
}
