package _01_asteroids;

import java.awt.*;
import java.util.Random;

public class Asteroid {
	Random random = new Random();
	int RADIUS = random.nextInt(10) + 25;
	int DIAMETER = 2 * RADIUS;
	int x, y, speed;
	double xSpeed, ySpeed, angle;
	Rectangle collisionBox;
	boolean isAlive = true;

	public Asteroid(int x, int y) {
		this.x = x;
		this.y = y;

		speed = random.nextInt(10) + 5;

		collisionBox = new Rectangle(x - RADIUS, y - RADIUS, DIAMETER, DIAMETER);

		angle = random.nextInt(360);
		xSpeed = (int) (Math.cos(Math.toRadians(angle)) * speed);
		ySpeed = (int) (Math.sin(Math.toRadians(angle)) * speed);
	}

	public Asteroid(int x, int y, int radius) {
		this.x = x;
		this.y = y;

		RADIUS = radius;
		DIAMETER = radius * 2;
		speed = random.nextInt(10) + 5;

		collisionBox = new Rectangle(x - RADIUS, y - RADIUS, DIAMETER, DIAMETER);

		angle = random.nextInt(360);
		xSpeed = (int) (Math.cos(Math.toRadians(angle)) * speed);
		ySpeed = (int) (Math.sin(Math.toRadians(angle)) * speed);
	}

	void update() {
		x += xSpeed;
		y += ySpeed;

		if (x < 0)
			x = AsteroidsGame.WIDTH;
		if (x > AsteroidsGame.WIDTH)
			x = 0;
		if (y < 0)
			y = AsteroidsGame.HEIGHT;
		if (y > AsteroidsGame.HEIGHT)
			y = 0;

		collisionBox.setLocation(x - RADIUS, y - RADIUS);
	}

	void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawOval(x - RADIUS, y - RADIUS, DIAMETER, DIAMETER);
	}

}
