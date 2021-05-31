package _05_Polymorphs;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class MovingMorph extends Polymorph {
    
    Random rand = new Random();
    
    public MovingMorph(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void update() {
        
        int newX = getX() + rand.nextInt(10) + 5;
        int newY = getY() + rand.nextInt(10) + 5;
        
        
        if(getX() > PolymorphWindow.WIDTH) {
            setX(0);
        }
        else {
            setX(newX);
        }
        
        if(getY() > PolymorphWindow.HEIGHT) {
            setY(0);
        }
        else {
            setY(newY);
        }
        
    }

}
