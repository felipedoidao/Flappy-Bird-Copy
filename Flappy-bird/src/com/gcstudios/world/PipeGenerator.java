package com.gcstudios.world;

import com.gcstudios.entities.Entity;
import com.gcstudios.entities.Pipe;
import com.gcstudios.main.Game;

public class PipeGenerator {

    public int time = 0;
    public int targetTime = 120;

    public void tick(){
        time++;
        if(time >= targetTime){
            int height1 = Entity.rand.nextInt(50 - 30) + 30;    
            Pipe pipe1 = new Pipe(Game.WIDTH, 0, 20, height1, 1, null);

            int height2 = Entity.rand.nextInt(50 - 30) + 30;
            Pipe pipe2 = new Pipe(Game.WIDTH, Game.HEIGHT - height2, 20, height2, 1, null);

            Game.entities.add(pipe1);
            Game.entities.add(pipe2);
            time = 0;
        }


    }
}
