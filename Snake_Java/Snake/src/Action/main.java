package Action;


import GUI.Gui;
import Timer.GameTimer;

public class main {

	public static void main(String[] args) {
		
		Gui g=new Gui();
		GameTimer gm= new GameTimer();
		
		g.create();
		// TODO Auto-generated method stub
		gm.start();
		
		

	}

}
