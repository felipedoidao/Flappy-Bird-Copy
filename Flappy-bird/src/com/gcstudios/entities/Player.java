package com.gcstudios.entities;

import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;
import com.gcstudios.world.World;


public class Player extends Entity{
	
	public boolean isPressed = false;
	int lostTime = 0;
	
	public Player(int x, int y, int width, int height,double speed,BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}
	
	public void tick(){
	
		if(Game.lost == false){
			if(!isPressed){
				y+=speed;
	
			}else{
				y-=speed;
			}
		}else{
			lostTime++;
			if(lostTime >= 60){
				World.restartGame();
			}
		}
		

		if(this.getY() > Game.HEIGHT){
			World.restartGame();
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
