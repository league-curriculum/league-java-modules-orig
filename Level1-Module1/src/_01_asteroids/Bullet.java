package _01_asteroids;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Bullet implements ActionListener {

	int x, y;
	int speed = 20;
	int size = 5;
	double angle;
	Rectangle coll;
	Timer timer;
	boolean isAlive = true;
	
	public Bullet(int x, int y, double angle) {
		this.x = x;
		this.y = y;
		this.angle = angle;
		
		coll = new Rectangle(x - size / 2, y - size / 2, size, size);
		timer = new Timer(1000, this);
		timer.start();
	}
	
	public void update() {
		x += (Math.cos(Math.toRadians(angle)))*speed;
		y += (Math.sin(Math.toRadians(angle)))*speed;
		
		if (x < 0)
			x = AsteroidsGame.WIDTH;
		if (x > AsteroidsGame.WIDTH)
			x = 0;
		if (y < 0)
			y = AsteroidsGame.HEIGHT;
		if (y > AsteroidsGame.HEIGHT)
			y = 0;
		coll.setLocation(x - size / 2, y - size / 2);
	}
	
	public void draw(Graphics g) {
		Graphics2D graphics2D = (Graphics2D) g;
		graphics2D.rotate(Math.toRadians(angle), x, y);
		graphics2D.setColor(Color.WHITE);
		graphics2D.draw(coll);
		graphics2D.rotate(-Math.toRadians(angle), x, y);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		isAlive = false;
	}
}
