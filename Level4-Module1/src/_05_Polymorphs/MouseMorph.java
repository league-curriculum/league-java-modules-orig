package _05_Polymorphs;

import java.awt.Color;
import java.awt.Graphics;

public class MouseMorph extends Polymorph {
    
    public MouseMorph(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void update() {
        
    }

}
