package invadersSRC;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Rocketship extends GameObject {
	int speed;
	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 5;
	}
	void update() {
		super.update();
		switch (keyEvent) {
        case KeyEvent.VK_DOWN:
            y += 5;
            break;
        case KeyEvent.VK_UP:
            y -= 5;
            break;
        case KeyEvent.VK_LEFT:
            x -= 5;
            break;
        case KeyEvent.VK_RIGHT:
            x += 5;
            break;
		}
	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
	}

}
