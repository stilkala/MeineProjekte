package Game;

import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;

import GUI.Gui;

public class Essen {
private int x;
private int y;
int px;
int py;




public Essen() {
	
	
	this.px=ThreadLocalRandom.current().nextInt(0,15);
	this.py=ThreadLocalRandom.current().nextInt(0,15);
	
	this.x=this.px*32+Gui.xoff;
	this.y=this.py*32+Gui.yoff;
	
	
}

public void reset() {
	
	this.px=ThreadLocalRandom.current().nextInt(0,15);
	this.py=ThreadLocalRandom.current().nextInt(0,15);
	
	this.x=this.px*32+Gui.xoff;
	this.y=this.py*32+Gui.yoff;
	
	
}

public int getX() {
	return x;
}

public void setX(int x) {
	this.x = x;
}

public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
}

public int get_px() {
	
	return px;
	
}

public int get_py() {
	
	return py;
	
}




}
