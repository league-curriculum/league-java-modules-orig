package _07_timers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
/*
 * We're going to make a simple game using a timer. We'll have a countdown
 * in the middle of the screen, and the player needs to hit spacebar right 
 * as the countdown hits zero. 
 */
public class IntroToTimers extends JPanel implements ActionListener, KeyListener{
	static final int WIDTH = 500;
	static final int HEIGHT = 500;
	JFrame frame = new JFrame();
	Font font = new Font("Arial", Font.BOLD, 50);
	int time;
	int maxTime = 45;
	int speed = 30;
	
	// 1. Declare a Timer variable, but do not initialize it.


	public static void main(String[] args) {
		IntroToTimers tg = new IntroToTimers();
		tg.setup();
	}

	private void setup() {
		frame.add(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension (WIDTH,HEIGHT));
		frame.pack();
		frame.addKeyListener(this);
		
		// 2. Set the time variable to maxTime

		// 3. Initialize timer to a new Timer object. For the first argument, use 1000/speed. For the second argument, use this

		// 11. Run it! Notice how it doesn't update? That's because our timer isn't triggering the actionPerformed() method yet!
		// 12. Make the timer start!

		// 13. Run the program. Is it possible for you to win? 
		// 14. Figure out how to make it harder or easier! (Which condition is most related to whether you win or not?)
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 8. Decrement time

		// 9. if time is less than or equal to 2...

			// 10. Set time equal to maxTime

		
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		// 4. if keyCode is 32 (that's the spacebar key!)...


			// 5. if time is less than 2...

				// 6. Tell them they win!

			
			// 7. Otherwise, set time equal to maxTime

		
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.RED);
		g.setFont(font);
		g.drawString(time+"", WIDTH/2-50, HEIGHT/2);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
