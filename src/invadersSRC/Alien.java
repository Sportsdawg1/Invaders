package invadersSRC;

import java.awt.Graphics;

public class Alien extends GameObject{

	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	void update() {
		super.update();
		y++;
	}
	
	void draw(Graphics g) {
		g.fillRect(x, y, width, height);
	}

}
