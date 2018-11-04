package invadersSRC;

import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame = new JFrame();
	final static int WIDTH = 500;
	final static int HEIGHT = 800;
	GamePanel panel = new GamePanel();
	public LeagueInvaders() {
		
	}
	void setup() {
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.startGame();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeagueInvaders i = new LeagueInvaders();
		i.setup();
	}

}
