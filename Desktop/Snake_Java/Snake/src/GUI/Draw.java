package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.JLabel;

import Game.Snake;



public class Draw extends JLabel{
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d= (Graphics2D) g;
		Point p;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
		
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, Gui.width, Gui.height);
		
		g.setColor(Color.green);
		
		//Snakeschwanz zeichnen
		for(int i=0;i<Snake.tl.size();i++) {
			
			p=Snake.ptc(Snake.tl.get(i).getX(), Snake.tl.get(i).getY());
			g.fillRect(p.x, p.y, 32, 32);
			
			
		}
		
		//Snakekopf zeichnen;
		p=Snake.ptc(Snake.h.getX(),Snake.h.getY());
		g.fillRect(p.x, p.y, 32, 32);
		
		//Essen zeichenn
		g.setColor(new Color(205,42,0));
		p.x= Snake.essen.getX();
		p.y=Snake.essen.getY();
		g.fillRect(p.x, p.y, 32, 32);
		
		g.setColor(Color.GRAY);
		
		for(int i=0;i<16;i++) {
			for (int j=0;j<16;j++) {
				g.drawRect(i*32+Gui.xoff, j*32+Gui.yoff,32,32);
				
			}
		}
		
		g.setColor(Color.black);
		g.drawRect(Gui.xoff,Gui.yoff, 512, 512);
		
		
		
		repaint();
		
	}
	
	

}
