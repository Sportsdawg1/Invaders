package invadersSRC;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Graphics a; 
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Rocketship ship = new Rocketship(250,700,50,50);
	public static BufferedImage alienImg;
    public static BufferedImage rocketImg;
    public static BufferedImage bulletImg;
    public static BufferedImage spaceImg;
	public ObjectManager manager = new ObjectManager(ship);
	//Game  = new Game(10, 10, 100, 100);
	public GamePanel() {
		timer = new Timer(1000/60, this);
		try {
            alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
            rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
            bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
            spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
		} catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
		}
	}
	void startGame() {
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g){             
		if (currentState == MENU_STATE) {
            drawMenuState(g);
		 } else if (currentState == GAME_STATE) {
            drawGameState(g);
		 } else if (currentState == END_STATE) {
            drawEndState(g);
        }
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if (currentState == MENU_STATE) {
             updateMenuState();
		 } else if (currentState == GAME_STATE) {
             updateGameState();
             
		 } else if (currentState == END_STATE) {
             updateEndState();
         }


		//.update();
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("typed");
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		ship.keyEvent = e.getKeyCode();
		
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if(currentState > END_STATE){
				currentState = MENU_STATE;
			}
			if(currentState == MENU_STATE) {
				ship = new Rocketship(250,700,50,50);
				manager = new ObjectManager(ship);
				ship.isAlive = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			manager.addProjectile(new Projectile(ship.x + ship.width/2 - 5, ship.y, 10, 10));
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//.keyEvent = 0;
		System.out.println("released");
		if(e.getKeyCode() == ship.keyEvent) {
			ship.keyEvent = 0;
		}
	}
	void updateMenuState() {
		
	}
	void updateGameState() {
		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		manager.purgeObjects();
		JFrame f = ((JFrame) (this.getParent().getParent().getParent().getParent()));
		f.setTitle("Invaders - " + manager.getScore());
		if(manager.r.isAlive == false) {
			currentState = END_STATE;
		}
	}
	void updateEndState() {
		
	}
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.setFont(titleFont);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setColor(Color.ORANGE);
		g.drawString("INVADERS", 10, 80);
	}
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		manager.draw(g);
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.setFont(titleFont);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setColor(Color.GREEN);
		g.drawString("YOU DIE", 10, 80);
	}
}
