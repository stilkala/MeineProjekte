package GUI;

import javax.swing.JFrame;

import Action.KeyHandler;

public class Gui {
	
	JFrame jf;
	Draw d;
	KeyHandler k=new KeyHandler();
	public static int width=800;
	public static int height=600;
	
	public static int xoff=135;
	public static int yoff=20;
	
	
	public void create() {
		jf= new JFrame("Snake");
		jf.setSize(width, height);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		jf.setLayout(null);
		jf.addKeyListener(k);
		
		d=new Draw();
		d.setBounds(0,0,width,height);
		d.setVisible(true);
		jf.add(d);
		jf.requestFocus();
		jf.setVisible(true);
		
	}
	

}
