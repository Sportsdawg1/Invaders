package invadersSRC;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship r;
	long enemyTimer = 0;
	int enemySpawnTime = 5000;
	int score = 0;
	ArrayList<Projectile> projectileList = new ArrayList<>();
	ArrayList<Alien> alienList = new ArrayList<>();
	void addProjectile(Projectile p) {
		projectileList.add(p);
	}

	void addAlien(Alien a) {
		alienList.add(a);
	}

	public ObjectManager(Rocketship r) {
		this.r = r;
	}

	void update() {
		r.update();
		for (int i = 0; i < projectileList.size(); i++) {
			projectileList.get(i).update();
		}
		for (int i = 0; i < alienList.size(); i++) {
			alienList.get(i).update();
		}

	}

	void draw(Graphics g) {
		r.draw(g);
		for (int i = 0; i < projectileList.size(); i++) {
			projectileList.get(i).draw(g);
		}
		for (int i = 0; i < alienList.size(); i++) {
			alienList.get(i).draw(g);
		}
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
			enemyTimer = System.currentTimeMillis();
		}
	}

	void purgeObjects() {
		for (int i = 0; i < projectileList.size(); i++) {
			if (!projectileList.get(i).isAlive) {
				projectileList.remove(i);
			}
		}
		for (int i = 0; i < alienList.size(); i++) {
			if (!alienList.get(i).isAlive) {
				alienList.remove(i);
			}
		}
	}

	void checkCollision() {
		for(Alien a : alienList){
		    if(r.collisionBox.intersects(a.collisionBox)) {
		    		r.isAlive = false;
		    }
		}
		
		for (int i = 0; i < projectileList.size(); i++) {
			Projectile p = projectileList.get(i);
			for (int j = 0; j < alienList.size(); j++) {
				if(alienList.get(j).collisionBox.intersects(p.collisionBox)) {
					alienList.get(j).isAlive = false;
				}
			}
		}
	}

}
