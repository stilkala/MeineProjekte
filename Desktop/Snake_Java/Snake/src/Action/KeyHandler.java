package Action;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Game.Direction;
import Game.Snake;

public class KeyHandler implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			//if(!(Snake.h.getD()== Direction.DOWN) && !Snake.waitToMove) {
				Snake.h.setD(Direction.UP);
				Snake.waitToMove=true;	
		//	}
			
			break;
		case KeyEvent.VK_A:
			//if(!(Snake.h.getD()== Direction.RIGHT) && !Snake.waitToMove) {
				Snake.h.setD(Direction.LEFT);
				Snake.waitToMove=true;	
			//}
			break;
		case KeyEvent.VK_S:
		//	if(!(Snake.h.getD()== Direction.UP) && !Snake.waitToMove) {
				Snake.h.setD(Direction.DOWN);
				Snake.waitToMove=true;	
			//}
			
			
			break;
		case KeyEvent.VK_D:
			//if(!(Snake.h.getD()== Direction.LEFT) && !Snake.waitToMove) {
				Snake.h.setD(Direction.RIGHT);
				Snake.waitToMove=true;	
			//}
			
			break;
		
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
