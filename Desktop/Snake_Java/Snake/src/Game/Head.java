package Game;

public class Head {
	private int x=7,y=7;
	Direction d;
	
	public Head(int x, int y) {
		
		this.x=x;
		this.y=y;
		d=Direction.UP;
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

	public Direction getD() {
		return d;
	}

	public void setD(Direction d) {
		this.d = d;
	}

}
