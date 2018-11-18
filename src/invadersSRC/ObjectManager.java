package invadersSRC;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	Rocketship r;
	ArrayList <Projectile> projectileList = new ArrayList<>();
	void addProjectile(Projectile p) {
		projectileList.add(p);
	}
	public ObjectManager(Rocketship r) {
		this.r = r;
	}
	void update () {
		r.update();
		for (int i = 0; i < projectileList.size(); i++) {
			projectileList.get(i).update();
		}
	}
	void draw (Graphics g) {
		r.draw(g);
		for (int i = 0; i < projectileList.size(); i++) {
			projectileList.get(i).draw(g);
		}
	}
}
