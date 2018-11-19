package com.maop.fkingwumpus;

public class Monster extends Box {
	
	public void dangerBox(int position_y,int position_x) {

		Main.secure[Position_y][Position_x]=0;
		Main.visited[Position_y][Position_x]=0;
		Main.secure[Position_y+1][Position_x]=0;
		Main.secure[Position_y-1][Position_x]=0;
		Main.secure[Position_y][Position_x+1]=0;
		Main.secure[Position_y][Position_x-1]=0;
		Main.stench[Position_y+1][Position_x]=1;
		Main.stench[Position_y-1][Position_x]=1;
		Main.stench[Position_y][Position_x+1]=1;
		Main.stench[Position_y][Position_x-1]=1;
	}
	
	public void heFoundMe(int position_y,int position_x){
		Main.stench[Position_y+1][Position_x]=0;
		Main.stench[Position_y-1][Position_x]=0;
		Main.stench[Position_y][Position_x+1]=0;
		Main.stench[Position_y][Position_x-1]=0;
		Main.secure[Position_y][Position_x]=1;
		Main.visited[Position_y][Position_x]=1;
		Main.secure[Position_y+1][Position_x]=1;
		Main.secure[Position_y-1][Position_x]=1;
		Main.secure[Position_y][Position_x+1]=1;
		Main.secure[Position_y][Position_x-1]=1;
	}
}
