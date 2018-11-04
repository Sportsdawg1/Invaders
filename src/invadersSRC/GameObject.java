package invadersSRC;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class GameObject {
	int x;
    int y;
    int width;
    int height;
    int keyEvent;
	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	void update() {
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
		g.fillRect(x, y, 100, 100);
	}
}
