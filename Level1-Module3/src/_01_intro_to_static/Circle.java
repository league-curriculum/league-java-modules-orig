package _01_intro_to_static;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Circle {
    int x, y;

    /*
     * Add/remove the word "static" at the beginning of these variables
     */
    int radius;
    Color color;

    public Circle(int r, Color c) {
        radius = r;
        color = c;

        Random rand = new Random();
        x = rand.nextInt(Canvas.WIDTH / 2);
        y = rand.nextInt(Canvas.HEIGHT / 2);
    }

    void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 2 * radius, 2 * radius);
    }
}
