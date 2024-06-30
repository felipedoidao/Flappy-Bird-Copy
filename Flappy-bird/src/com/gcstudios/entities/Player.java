package com.gcstudios.entities;

import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;


public class Player extends Entity{
	
	public boolean isPressed = false;
	int lostTime = 0;
	public double grav = 0.1;
	
	public Player(int x, int y, int width, int height,double speed,BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}
	
	public void tick(){
		speed += grav;
		if(!isPressed){
			y+=speed;
	
		}else{
			isPressed = false;
			speed = 0;
			y-=20 ;
		}
		

		if(this.getY()+16 > Game.HEIGHT){
			Game.lost = true;
		}
		

		for(int i = 0; i < Game.entities.size(); i++){
			Entity e = Game.entities.get(i);
			if(e != this){
				if(Entity.isColidding(e, this)){
					Game.lost = true;

				}
			}
		}

		



	}

}
