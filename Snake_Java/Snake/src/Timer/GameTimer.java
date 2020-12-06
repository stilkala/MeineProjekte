package Timer;

import Action.Collision;
import Game.Snake;

public class GameTimer extends Thread {
	
	public static boolean running =true;
	int slp=300;
	
	public void run() {
		
		
		try {
			sleep(slp);
			Snake.move();
			Snake.waitToMove=false;
			if(Collision.colEssen2()) {
				
						Snake.essen.reset();
						Snake.addTail();
						if(slp>=50) {
						slp-=20;
						}
			}
			if(Collision.self()) {
				Snake.tl.clear();
			}
			if(Collision.wall()) {
				Snake.tl.clear();
				Snake.h.setX(7);
				Snake.h.setY(7);
			}
			
			run();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
